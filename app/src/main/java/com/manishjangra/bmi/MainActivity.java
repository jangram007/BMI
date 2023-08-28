package com.manishjangra.bmi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edt_weight, edt_heightinft, edt_heightinIn;
        AppCompatButton btn_calcbmi;
        TextView txtResult;
        LinearLayout linearMain;

        edt_weight = findViewById(R.id.edt_weight);
        edt_heightinft = findViewById(R.id.edt_heightinft);
        edt_heightinIn = findViewById(R.id.edt_heightinIn);
        btn_calcbmi = findViewById(R.id.btn_calcbmi);
        txtResult = findViewById(R.id.txtResult);
        linearMain = findViewById(R.id.linearMain);

        btn_calcbmi.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                int wt = Integer.parseInt(edt_weight.getText().toString());
                int htFt = Integer.parseInt(edt_heightinft.getText().toString());
                int htIn = Integer.parseInt(edt_heightinIn.getText().toString());

                int totalIn = htFt*12+ htIn;
                float totalCm = totalIn*2.53f;
                float totalM =totalCm/100;
                float bmi = wt/(totalM*totalM);

                if(bmi>25){
                    txtResult.setText("You are Overweight");
                   linearMain.setBackgroundColor(getResources().getColor(R.color.overweight));
                } else if (bmi<18){
                    txtResult.setText("You are Underweight");
                    linearMain.setBackgroundColor(getResources().getColor(R.color.underweight));

                }else {
                    txtResult.setText("You are Healthy");
                    linearMain.setBackgroundColor(getResources().getColor(R.color.healthy));

                }
            }
        });
    }
}