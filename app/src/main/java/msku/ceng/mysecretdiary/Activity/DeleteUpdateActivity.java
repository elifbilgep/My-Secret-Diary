package msku.ceng.mysecretdiary.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import msku.ceng.mysecretdiary.R;

public class DeleteUpdateActivity extends AppCompatActivity {
    private Button deleteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_update);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        deleteButton = findViewById(R.id.delete_button);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),DeletedNoteActivity.class);
                startActivity(intent);
            }
        });
    }
}