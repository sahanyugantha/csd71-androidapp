package com.sahan.csd71app.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.sahan.csd71app.R;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "customTag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "onCreate");


        //CLICK ME BUTTON...
        Button btn_click = (Button) findViewById(R.id.btnClickMe);
        btn_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(getApplicationContext(), "Hello!", Toast.LENGTH_SHORT);
                toast.show();
            }
        });


        //BMI CALCULATOR...
        EditText etWeight = (EditText) findViewById(R.id.etWeight);
        EditText etHeight = (EditText) findViewById(R.id.etHeight);
        Button btnCalculate = (Button) findViewById(R.id.btnCalculate);
        TextView tvResult = (TextView) findViewById(R.id.tvValue);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String weight = etWeight.getText().toString();//BMI = kg/m2
                String height = etHeight.getText().toString();

                float weightF = Float.parseFloat(weight);
                float heightF = Float.parseFloat(height)/100;

                float result = (float)(Math.round((weightF/(heightF*heightF))*10))/10;

                tvResult.setText("Your BMI : "+result);

            }
        });



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }
}