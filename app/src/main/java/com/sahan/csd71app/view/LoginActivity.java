package com.sahan.csd71app.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sahan.csd71app.R;
import com.sahan.csd71app.dao.LoginAsyncTask;
import com.sahan.csd71app.model.User;

import java.util.concurrent.ExecutionException;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "customTag3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText etEmail = (EditText) findViewById(R.id.etEmail);
        EditText etPass = (EditText) findViewById(R.id.etPass);
        Button btnSignIn = (Button) findViewById(R.id.btnSignIn);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = etEmail.getText().toString();
                String password = etPass.getText().toString();

                LoginAsyncTask loginAsyncTask = new LoginAsyncTask(email, password);
                try {
                    User user = loginAsyncTask.execute().get();
                    //Log.i(TAG, user.getEmail().toString());
                    if (user != null && user.isLogged_in()){
                        Log.i(TAG, "YEAH!");
                        Toast.makeText(getApplicationContext(), "Successfully logged in ", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);

                        String name = user.getEmail();
                        Bundle bundle = new Bundle();
                        bundle.putString("NAME", name);
                        intent.putExtras(bundle);

                        startActivity(intent);

                    } else {
                        Log.i(TAG, "NOPE!");
                        Toast.makeText(getApplicationContext(), "Logging failed!", Toast.LENGTH_SHORT).show();
                    }
                } catch (ExecutionException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}