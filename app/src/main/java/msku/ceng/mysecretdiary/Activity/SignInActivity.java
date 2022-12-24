package msku.ceng.mysecretdiary.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import msku.ceng.mysecretdiary.R;

public class SignInActivity extends AppCompatActivity {
    private Button button;
    private TextView dontHaveAccText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        button = findViewById(R.id.signInButton);
        dontHaveAccText = findViewById(R.id.dontHaveAccText);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),MainActivity.class);
                startActivity(intent);
            }
        });

        dontHaveAccText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),SignUpActivity.class);
                startActivity(intent);
            }
        });

    }
}