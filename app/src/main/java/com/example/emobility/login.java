package com.example.emobility;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class login extends AppCompatActivity {
    EditText username_box, password_box;
    Button btn_submit;
    TextView show_attempt;

    int count;
    private int resid;
    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username_box = findViewById(R.id.username_box);
        password_box = findViewById(R.id.password_box);
        btn_submit = findViewById(R.id.btn_submit);

    }
     public void submit(View view){
        if(username_box.getText().toString().equals("admin")&&
        password_box.getText().toString().equals("1234")) {
            Toast.makeText(getApplicationContext(),
                    "Login Succeesful",
                    Toast.LENGTH_LONG).show();
            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    Intent intent = new Intent(login.this,main2.class);
                    startActivity(intent);
                    finish();
                }
            }, 3000);

        }else {
            Toast.makeText(getApplicationContext(),
                    "wrong usernane or password\n try again",
                    Toast.LENGTH_LONG).show();

            count--;
            String text = " Attempts remaining: "+Integer.toString(count);
            show_attempt.setText(text);

            if(count==0){
                btn_submit.setEnabled(false);
              }



        }
     }

}
