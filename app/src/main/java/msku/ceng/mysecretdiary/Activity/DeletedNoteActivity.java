package msku.ceng.mysecretdiary.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import msku.ceng.mysecretdiary.R;

public class DeletedNoteActivity extends AppCompatActivity {
    private Button addDiarybutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deleted_note);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        addDiarybutton = findViewById(R.id.save_button);
        addDiarybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),SaveActivity.class);
                startActivity(intent);
            }
        });
    }
}