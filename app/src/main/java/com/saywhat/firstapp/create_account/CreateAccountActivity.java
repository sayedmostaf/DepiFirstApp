package com.saywhat.firstapp.create_account;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.saywhat.firstapp.R;
import com.saywhat.firstapp.login.LoginActivity;
import com.saywhat.firstapp.login.Validator;

public class CreateAccountActivity extends AppCompatActivity {
    TextView loginText;
    private EditText email, password, confirmPassword;
    private Validator validator;
    Button createButton;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        loginText = findViewById(R.id.login_text);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        confirmPassword = findViewById(R.id.confirm_password);
        createButton = findViewById(R.id.signup_button);

        validator = new Validator();
        sharedPreferences = getSharedPreferences("login", MODE_PRIVATE); // Use the same key "login" as in LoginActivity

        loginText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreateAccountActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInputs()) {
                    String emailVal = email.getText().toString().trim();
                    String passwordVal = password.getText().toString().trim();

                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("email", emailVal);
                    editor.putString("password", passwordVal);
                    editor.apply();

                    Intent intent = new Intent(CreateAccountActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    private boolean validateInputs() {

        String emailInput = email.getText().toString().trim();
        String passwordInput = password.getText().toString().trim();

        if (!validator.validEmail(emailInput)) {
            Toast.makeText(this, "Invalid email", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!validator.validPassword(passwordInput)) {
            Toast.makeText(this, "Password must be at least 8 characters", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
