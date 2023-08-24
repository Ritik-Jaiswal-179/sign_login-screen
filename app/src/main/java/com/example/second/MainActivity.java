package com.example.second;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private EditText etLoginUsername, etLoginPassword;
    private TextView tvLoginStatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etLoginUsername = findViewById(R.id.etLoginUsername);
        etLoginPassword = findViewById(R.id.etLoginPassword);
        tvLoginStatus = findViewById(R.id.tvLoginStatus);

//        Button btnLogin = findViewById(R.id.btnLogin);
//        btnLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                login();
//            }
//        });
//
//        Button btnGoToSignUp = findViewById(R.id.btnGoToSignUp);
//        btnGoToSignUp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, signup.class));
//            }
//        });

        Button btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        Button btnGoToSignUp = findViewById(R.id.btnGoToSignUp);
        btnGoToSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, signup.class));
            }
        });
    }

//    private void login() {
//        String username = etLoginUsername.getText().toString();
//        String password = etLoginPassword.getText().toString();
//
//        // Retrieve usersArray from storage or database
//        // For simplicity, let's assume there's a JSONArray named "usersArray"
//        JSONArray usersArray = new JSONArray();
//
//        boolean found = false;
//        try {
//            for (int i = 0; i < usersArray.length(); i++) {
//                JSONObject user = usersArray.getJSONObject(i);
//                if (user.getString("username").equals(username) &&
//                        user.getString("password").equals(password)) {
//                    found = true;
//                    break;
//                }
//            }
//
//            if (found) {
//                tvLoginStatus.setText("Login successful");
//            } else {
//                tvLoginStatus.setText("Login failed");
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//    }

    private void login() {
        String username = etLoginUsername.getText().toString();
        String password = etLoginPassword.getText().toString();

        // Retrieve user data from SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("UserData", Context.MODE_PRIVATE);
        String storedUsername = sharedPreferences.getString("username", "");
        String storedPassword = sharedPreferences.getString("password", "");

        if (username.equals(storedUsername) && password.equals(storedPassword)) {
            tvLoginStatus.setText("Login successful");
        } else {
            tvLoginStatus.setText("Login failed");
        }
    }

}