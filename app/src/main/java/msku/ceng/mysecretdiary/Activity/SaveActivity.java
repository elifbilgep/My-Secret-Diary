package msku.ceng.mysecretdiary.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import msku.ceng.mysecretdiary.R;

public class SaveActivity extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        button = findViewById(R.id.save);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),NotesActivity.class);
                startActivity(intent);
            }
        });
    }
}