package com.example.edittext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText ed1,ed2,ed3;
    private TextView txv;
    int size = 15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setBackgroundDrawableResource(R.drawable.dog_01);
        ed1 = findViewById(R.id.editText);
        ed2 = findViewById(R.id.editText2);
        ed3 = findViewById(R.id.editText3);
        txv = findViewById(R.id.textView);
    }

    public void response(View view){
        float height = Float.parseFloat(ed2.getText().toString());
        float weight = Float.parseFloat(ed3.getText().toString());
        float BMI_1 = calculateBMI(height,weight);
        String BMI_2 = String.valueOf(BMI_1);

        txv.setTextSize(size);
        txv.setText(ed1.getText().toString()+" Hello!"+"\n"+"your BMI is "+BMI_2);
        Toast.makeText(this, standerdBMI(BMI_1), Toast.LENGTH_SHORT).show();
    }

    private float  calculateBMI(float height , float weight){
        float BMI = (float)(weight/Math.pow(height/100,2));
        return BMI;
    }

    private String standerdBMI(double BMI){
        String alart ="";

        if(BMI>25){
            alart = String.valueOf("You are way too heavy!!!");
            getWindow().setBackgroundDrawableResource(R.drawable.cat_fat01);
        }else if(BMI<18.5){
            alart = String.valueOf("You are too thin!!!");
            getWindow().setBackgroundDrawableResource(R.drawable.cat_01);
        }else{
            alart = String.valueOf("Your body is good!!!");
        }
        return  alart;
    }
}
