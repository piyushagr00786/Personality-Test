//Activity 0
// Splash Screen. It is the first activity(screen) when the app is opened
package com.map.personalitytest;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;

public class loading extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Waiting for three seconds to display the splash screen. This is a threaded process.
        new Thread(){
            @Override
            public void run(){
                try {
                    sleep(3000);
                    Intent intent;
                    intent=new Intent(getApplicationContext(),Login.class);// After 3 sec user is directed to the Login page(activity - Login.java)
                    startActivity(intent);
                    finish();
                }
                catch (Exception e){}
            }
        }.start();
    }
}
