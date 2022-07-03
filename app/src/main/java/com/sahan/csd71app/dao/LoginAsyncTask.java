package com.sahan.csd71app.dao;

import android.os.AsyncTask;
import android.util.Log;

import com.sahan.csd71app.model.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class LoginAsyncTask extends AsyncTask<Void, Void, User> {

    private static final String TAG = "customTag2";
    private static final String LOGIN_URL = "http://10.0.2.2:8000/csd71/auth-api.php";


    private String email;
    private String password;

    public LoginAsyncTask(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    protected User doInBackground(Void... voids) {
        User user = new User();
        user.setLogged_in(false);

        try{
            URL url = new URL(LOGIN_URL);
            HttpURLConnection httpURLConnection =(HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(1000*5);
            httpURLConnection.setReadTimeout(1000*5);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoInput(true);//downloads?
            httpURLConnection.setDoOutput(true);//upload

            JSONObject objData = new JSONObject();
            objData.put("email", URLEncoder.encode(email,"utf-8"));
            objData.put("password", URLEncoder.encode(password,"utf-8"));

            String jsonString = objData.toString();

            OutputStream outputStream = httpURLConnection.getOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "utf-8");
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

            bufferedWriter.write(jsonString);
            bufferedWriter.flush();
            bufferedWriter.close();

            if (httpURLConnection.getResponseCode() == 200){
                InputStream inputStream = httpURLConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                String line;
                StringBuilder sb = new StringBuilder();
                while ((line = bufferedReader.readLine()) != null){
                    sb.append(line);
                }
                JSONArray jsonArray = new JSONArray(sb.toString());
                JSONObject authObj = jsonArray.getJSONObject(0);
                String authValue = authObj.get("AUTH").toString();

                switch (authValue) {
                    case "SUCCESS":
                        user.setLogged_in(true);
                        JSONObject userObj = jsonArray.getJSONObject(1).getJSONObject("USER");
                         user.setId(userObj.getInt("id"));
                         user.setEmail(userObj.getString("email"));
                         user.setGender(userObj.getString("gender"));
                         user.setMobile(userObj.getString("mobile"));
                        break;
                    case "FAILED":
                        user = null;
                        break;
                }

            }

        } catch (IOException | JSONException e) {
            e.printStackTrace();
            Log.i(TAG, "ERROR : "+e.getMessage());
        }

        return user;
    }
}
