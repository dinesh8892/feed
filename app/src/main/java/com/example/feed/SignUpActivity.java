package com.example.feed;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.sign_up);


        final Button verify = (Button) findViewById(R.id.verify_button);
        final ImageView tick = (ImageView) findViewById(R.id.tick);
        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verify.setVisibility(View.GONE);
                tick.setVisibility(View.VISIBLE);
                tick.setImageResource(R.drawable.facebook_checkmark);
            }
        });

        Button sign_up = findViewById(R.id.sign_up_now);
        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signUpIntent = new Intent(SignUpActivity.this, MainActivity.class);
                startActivity(signUpIntent);
            }
        });

    }
}
