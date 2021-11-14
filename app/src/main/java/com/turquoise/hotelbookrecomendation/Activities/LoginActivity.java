package com.turquoise.hotelbookrecomendation.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.turquoise.hotelbookrecomendation.R;

import static com.turquoise.hotelbookrecomendation.Utils.Utilities.newActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button login;
    private TextInputLayout username,email,pass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username);
        email = findViewById(R.id.userEmail);
        pass = findViewById(R.id.password);
        login = findViewById(R.id.loginBtn);
        login.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {

        String Email = email.getEditText().getText().toString();
        String Password = pass.getEditText().getText().toString();

        if (v.getId() == R.id.loginBtn) {
            if (getUsername().equals("")) {
                setError(username, "Enter valid username with length greater than 5 char");
            } else {

                SharedPreferences sharedPreferences = getSharedPreferences(getUsername(), MODE_PRIVATE);
                SharedPreferences.Editor editor = getSharedPreferences(getUsername(), MODE_PRIVATE).edit();

                if (sharedPreferences.getString("active", "in").equals("in")) {

                    SharedPreferences.Editor edit = getSharedPreferences("cur", MODE_PRIVATE).edit();
                    edit.putString("user", getUsername());

                }
                newActivity(LoginActivity.this, MainActivity.class);
            }

            if(Email.isEmpty()){
                email.setError("Email is required");
                return;
            }

            if(Password.isEmpty()){
                pass.setError("Password is required");
                return;
            }
        }

        if(v.getId() == R.id.Register)
        {
            newActivity(LoginActivity.this, RegisterActivity.class);
        }
    }

    private void setError(@NonNull TextInputLayout username, String s) {
        username.setError(s);
    }

    private String getUsername() {

        return username.getEditText().getText().toString();

    }
}
