package msku.ceng.mysecretdiary.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import msku.ceng.mysecretdiary.R;

public class NotesActivity extends AppCompatActivity {

    private ImageView noteBoxImage;
    private ImageView logOutImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        logOutImage = findViewById(R.id.logOutButton);
        noteBoxImage = findViewById(R.id.noteBoxView);
        noteBoxImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),DeleteUpdateActivity.class);
                startActivity(intent);
            }
        });
        logOutImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),SignInActivity.class);
                startActivity(intent);
            }
        });
    }
}