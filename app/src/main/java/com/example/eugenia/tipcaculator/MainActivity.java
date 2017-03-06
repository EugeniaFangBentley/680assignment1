package com.example.eugenia.tipcaculator;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.text.DecimalFormat;
import android.graphics.Typeface;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private Button btn_go;
    private EditText et_check_amount, et_number_of_people, et_tip_percentage;
    private TextView tv_total_bill, tv_total_tip, tv_total_per_person, tv_tip_per_person;
    private float default_tip = 15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //information input
        et_check_amount=(EditText)findViewById(R.id.check_amt);
        et_check_amount.requestFocus();
        et_number_of_people=(EditText)findViewById(R.id.num_ppl);
        et_tip_percentage=(EditText)findViewById(R.id.tip_percentage);

        //information output
        tv_total_bill=(TextView)findViewById(R.id.total_bill);
        tv_total_tip=(TextView)findViewById(R.id.total_tip);
        tv_total_per_person=(TextView)findViewById(R.id.total_per_person);
        tv_tip_per_person=(TextView)findViewById(R.id.tip_per_person);

       //calculation
        btn_go=(Button)findViewById(R.id.go);
        btn_go.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){
                //no empty fields allowed
                if (et_check_amount.getText().toString().equals("")|| et_number_of_people.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"***Please enter the Check Amount and the Number of People***",Toast.LENGTH_LONG).show();
                    return;
                }

                if (et_tip_percentage.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"15% default percentage applied", Toast.LENGTH_LONG).show();

                    String check_amount = et_check_amount.getText().toString();
                    String number_of_people = et_number_of_people.getText().toString();

                    //set two decimal display
                    DecimalFormat df = new DecimalFormat("0.00");

                    float total_tip = Float.parseFloat(check_amount) * default_tip/100;
                    String total_tip_string = df.format(total_tip);

                    float total_bill = Float.parseFloat(check_amount) + total_tip;
                    String total_bill_string = df.format(total_bill);

                    float total_per_person = total_bill / (Float.parseFloat(number_of_people));
                    String total_per_person_string = df.format(total_per_person);

                    float tip_per_person = total_tip / (Float.parseFloat(number_of_people));
                    String tip_per_person_string = df.format(tip_per_person);

                    tv_total_bill.setText(String.valueOf(total_bill_string));
                    tv_total_tip.setText(String.valueOf(total_tip_string));
                    tv_total_per_person.setText(String.valueOf(total_per_person_string));
                    tv_tip_per_person.setText(String.valueOf(tip_per_person_string));

                    return;

                }
                String check_amount = et_check_amount.getText().toString();
                String number_of_people = et_number_of_people.getText().toString();
                String tip_percentage = et_tip_percentage.getText().toString();

                DecimalFormat df = new DecimalFormat("0.00");

                float total_tip = Float.parseFloat(check_amount) * Float.parseFloat(tip_percentage)/100;
                String total_tip_string = df.format(total_tip);

                float total_bill = Float.parseFloat(check_amount) + total_tip;
                String total_bill_string = df.format(total_bill);

                float total_per_person = total_bill / (Float.parseFloat(number_of_people));
                String total_per_person_string = df.format(total_per_person);

                float tip_per_person = total_tip / (Float.parseFloat(number_of_people));
                String tip_per_person_string = df.format(tip_per_person);

                tv_total_bill.setText(String.valueOf(total_bill_string));
                tv_total_tip.setText(String.valueOf(total_tip_string));
                tv_total_per_person.setText(String.valueOf(total_per_person_string));
                tv_tip_per_person.setText(String.valueOf(tip_per_person_string));

            }
        });
    }
}

