package msku.ceng.mysecretdiary.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

import msku.ceng.mysecretdiary.Adapter.NotesAdapter;
import msku.ceng.mysecretdiary.Fragments.ProfileFragment;
import msku.ceng.mysecretdiary.Model.Notes;
import msku.ceng.mysecretdiary.R;
import msku.ceng.mysecretdiary.ViewModel.NotesViewModel;

public class NotesActivity extends AppCompatActivity{

    private Button saveButton; //add note button
    TextView noFilter, happyFilter, sadFilter, angryFilter, excitedFilter;
    NotesViewModel notesViewModel; //All the DB functions access object
    RecyclerView recyclerView; //the view list item will show uğ
    NotesAdapter notesAdapter; //The Adapter which connects UI the live list
    String selected = "noFilter";
    ImageView profileButton;
    ImageView settingsButton;
    Handler handler = new Handler();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        //conncecting variables to UI elements by ID
        recyclerView = findViewById(R.id.notesRecycler);
        notesViewModel = ViewModelProviders.of(this).get(NotesViewModel.class);
        saveButton = findViewById(R.id.save_button);
        noFilter = findViewById(R.id.noFilter);
        happyFilter = findViewById(R.id.happyFilter);
        sadFilter = findViewById(R.id.sadFilter);
        angryFilter = findViewById(R.id.angryFilter);
        excitedFilter = findViewById(R.id.excitedFilter);
        profileButton = findViewById(R.id.profileButton);
        settingsButton = findViewById(R.id.settingsButton);


        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(NotesActivity.this, ProfileActivity.class);
                startActivity(i);
            }
        });

        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(NotesActivity.this, SettingsActivity.class);
                startActivity(i);
            }
        });



        noFilter.setBackgroundResource(R.drawable.filter_selected_shape);//select the no filter first
        noFilter.setOnClickListener(v -> {
            loadData(0);
            noFilter.setBackgroundResource(R.drawable.filter_selected_shape);
            sadFilter.setBackgroundResource(R.drawable.filter_shape);
            angryFilter.setBackgroundResource(R.drawable.filter_shape);
            excitedFilter.setBackgroundResource(R.drawable.filter_shape);
            happyFilter.setBackgroundResource(R.drawable.filter_shape);
        });
        happyFilter.setOnClickListener(v -> {
            loadData(1);
            happyFilter.setBackgroundResource(R.drawable.filter_selected_shape);
            noFilter.setBackgroundResource(R.drawable.filter_shape);
            sadFilter.setBackgroundResource(R.drawable.filter_shape);
            angryFilter.setBackgroundResource(R.drawable.filter_shape);
            excitedFilter.setBackgroundResource(R.drawable.filter_shape);

        });
        sadFilter.setOnClickListener(v -> {
            loadData(2);
            sadFilter.setBackgroundResource(R.drawable.filter_selected_shape);
            noFilter.setBackgroundResource(R.drawable.filter_shape);
            happyFilter.setBackgroundResource(R.drawable.filter_shape);
            angryFilter.setBackgroundResource(R.drawable.filter_shape);
            excitedFilter.setBackgroundResource(R.drawable.filter_shape);

        });
        angryFilter.setOnClickListener(v -> {
            loadData(3);
            angryFilter.setBackgroundResource(R.drawable.filter_selected_shape);
            noFilter.setBackgroundResource(R.drawable.filter_shape);
            sadFilter.setBackgroundResource(R.drawable.filter_shape);
            happyFilter.setBackgroundResource(R.drawable.filter_shape);
            excitedFilter.setBackgroundResource(R.drawable.filter_shape);


        });
        excitedFilter.setOnClickListener(v -> {
            loadData(4);
            excitedFilter.setBackgroundResource(R.drawable.filter_selected_shape);
            noFilter.setBackgroundResource(R.drawable.filter_shape);
            sadFilter.setBackgroundResource(R.drawable.filter_shape);
            happyFilter.setBackgroundResource(R.drawable.filter_shape);
            angryFilter.setBackgroundResource(R.drawable.filter_shape);
        });


        saveButton.setOnClickListener(new View.OnClickListener() {//the function when add button pressed
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), SaveActivity.class);
                startActivity(intent);
            }
        });


        notesViewModel.getAllNotes.observe(this, new Observer<List<Notes>>() {
            @Override
            public void onChanged(List<Notes> notes) {
                setAdapter(notes);
            }
        });



    }
    public void setAdapter(List<Notes> notes) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        notesAdapter = new NotesAdapter(NotesActivity.this, notes);
        recyclerView.setAdapter(notesAdapter);
    }
    private void loadData(int i){
        if (i == 0) {
            notesViewModel.getAllNotes.observe(this, new Observer<List<Notes>>() {
                @Override
                public void onChanged(List<Notes> notes) {
                    setAdapter(notes);
                }
            });
        } else if (i == 1) {
            notesViewModel.getHappyNotes.observe(this, new Observer<List<Notes>>() {
                @Override
                public void onChanged(List<Notes> notes) {
                    setAdapter(notes);
                }
            });
        } else if (i == 2) {
            notesViewModel.getSadNotes.observe(this, new Observer<List<Notes>>() {
                @Override
                public void onChanged(List<Notes> notes) {
                    setAdapter(notes);
                }
            });
        } else if (i == 3) {
            notesViewModel.getAngryNotes.observe(this, new Observer<List<Notes>>() {
                @Override
                public void onChanged(List<Notes> notes) {
                    setAdapter(notes);
                }
            });
        } else if (i == 4) {
            notesViewModel.getExcitedNotes.observe(this, new Observer<List<Notes>>() {
                @Override
                public void onChanged(List<Notes> notes) {
                    setAdapter(notes);
                }
            });
        }


    }
}