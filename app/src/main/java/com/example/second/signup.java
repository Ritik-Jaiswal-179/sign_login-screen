package com.example.second;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.content.Intent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public class signup extends AppCompatActivity {

    private EditText etUsername, etEmail, etPassword, etPass;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        etUsername = findViewById(R.id.etUsername);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etPass = findViewById(R.id.etPass);

//        Button btnSignUp = findViewById(R.id.btnSignUp);
//        btnSignUp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                signUp();
//            }
//        });
//
//        Button btnGoToLogin = findViewById(R.id.btnGoToLogin);
//        btnGoToLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(signup.this, MainActivity.class));
//            }
//        });

        Button btnSignUp = findViewById(R.id.btnSignUp);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp();
            }
        });

        Button btnGoToLogin = findViewById(R.id.btnGoToLogin);
        btnGoToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(signup.this, MainActivity.class));
            }
        });
    }
//    private void signUp() {
//        String username = etUsername.getText().toString();
//        String email = etEmail.getText().toString();
//        String password = etPassword.getText().toString();
//
//        JSONObject user = new JSONObject();
//        try {
//            user.put("username", username);
//            user.put("email", email);
//            user.put("password", password);
//
//            // Add the user to an array or database
//            // For simplicity, let's assume there's a JSONArray named "usersArray"
//            JSONArray usersArray = new JSONArray();
//            usersArray.put(user);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//    }

    private void signUp() {
        String username = etUsername.getText().toString();
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();

        if (username.isEmpty()) {
            etUsername.setError("Username is required");
            return;
        }

        if (email.isEmpty() || !isValidEmail(email)) {
            etEmail.setError("Please enter a valid email address");
            return;
        }

        if (password.isEmpty()) {
            etPassword.setError("Password is required");
            return;
        }

        // Store the user data in SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("UserData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", username);
        editor.putString("email", email);
        editor.putString("password", password);
        editor.apply();

        // Go to the login page
        startActivity(new Intent(this, MainActivity.class));
    }
    private boolean isValidEmail(CharSequence target) {
        return Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }
}