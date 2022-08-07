package com.sahan.csd71app.dao;

import static com.sahan.csd71app.configs.EndPoints.MOVIE_URL;

import android.os.AsyncTask;

import com.sahan.csd71app.model.Movie;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MoviesAsyncTask extends AsyncTask<Void,Void, List<Movie>> {


    @Override
    protected List<Movie> doInBackground(Void... voids) {
        return getMovieList();
    }

    public List<Movie> getMovieList(){
        try {
            URL url = new URL(MOVIE_URL);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(1000*5);
            httpURLConnection.setReadTimeout(1000*5);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setDoInput(true); //downloads.
            httpURLConnection.setDoOutput(false); //uploads.

            if (httpURLConnection.getResponseCode() == 200){
                InputStream inputStream = httpURLConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
                BufferedReader reader = new BufferedReader(inputStreamReader);

                String line = "";
                StringBuilder sb = new StringBuilder();
                while ((line = reader.readLine()) != null){
                    sb.append(line);
                }

                String jsonString = sb.toString();
                JSONArray array = new JSONArray(jsonString);
                List<Movie> movieList = new ArrayList<>();
                for (int i = 0; i < array.length(); i++) {
                    JSONObject obj = array.getJSONObject(i);

                    Movie movie = new Movie();
                    movie.setId(obj.getInt("id"));
                    movie.setName(obj.getString("name"));
                    movie.setGenre(obj.getString("genre"));
                    movie.setLanguage(obj.getString("language"));
                    movie.setDuration(obj.getString("duration"));
                    movie.setYear(obj.getInt("year"));
                    movie.setCoverURL(obj.getString("url"));

                    movieList.add(movie);
                }
                return movieList;
            }
        } catch (Exception  e){
            e.printStackTrace();
        }
        return null;
    }
}


