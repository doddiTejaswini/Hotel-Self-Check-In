package com.turquoise.hotelbookrecomendation.Activities;

import static com.turquoise.hotelbookrecomendation.Utils.Utilities.newActivity;

import androidx.appcompat.app.AppCompatActivity;
import com.turquoise.hotelbookrecomendation.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class RegisterActivity extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

    }

    public void onLoginClick(View v){

        if (v.getId() == R.id.gotoLogin) {

            newActivity(RegisterActivity.this, LoginActivity.class);

        } else {

            startActivity(new Intent(this, MainActivity.class));
        }

    }
}