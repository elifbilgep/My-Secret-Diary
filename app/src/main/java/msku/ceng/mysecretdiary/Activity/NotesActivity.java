package msku.ceng.mysecretdiary.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import msku.ceng.mysecretdiary.Adapter.NotesAdapter;
import msku.ceng.mysecretdiary.R;
import msku.ceng.mysecretdiary.ViewModel.NotesViewModel;

public class NotesActivity extends AppCompatActivity {

    private Button saveButton;

    NotesViewModel notesViewModel;
    RecyclerView recyclerView;
    NotesAdapter notesAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        recyclerView = findViewById(R.id.notesRecycler);
        notesViewModel = ViewModelProviders.of(this).get(NotesViewModel.class);
        saveButton = findViewById(R.id.save_button);

       saveButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(v.getContext(),SaveActivity.class);
               startActivity(intent);
           }
       });

        notesViewModel.getAllNotes.observe(this,notes -> {
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            notesAdapter = new NotesAdapter(NotesActivity.this,notes);
            recyclerView.setAdapter(notesAdapter);

        });
    }
}