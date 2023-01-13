package com.example.a201913709048;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.ktx.Firebase;

public class SplashScreen extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    Thread wait;
 @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        firebaseAuth = FirebaseAuth.getInstance();
        SplashThread();
        if(firebaseAuth.getCurrentUser() != null){
            wait.start();
        }
    }

    private void SplashThread() {
     wait = new Thread() {
         @Override
         public void run() {
             try {
                 sleep(3000);
                 startActivity(new Intent(SplashScreen.this, MainActivity.class));
                 finish();
             }
             catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }
     };
    }

    public void registerClick(View view) {
        startActivity(new Intent(this, RegisterActivity.class));
    }
    public void loginClick(View view) {
        startActivity(new Intent(this, LoginActivity.class));
    }
}