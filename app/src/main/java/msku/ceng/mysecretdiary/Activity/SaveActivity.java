package msku.ceng.mysecretdiary.Activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.Date;

import msku.ceng.mysecretdiary.Model.Notes;
import msku.ceng.mysecretdiary.R;
import msku.ceng.mysecretdiary.ViewModel.NotesViewModel;
import msku.ceng.mysecretdiary.databinding.ActivitySaveBinding;


public class SaveActivity extends AppCompatActivity {
    private Button button;
    String todayDate;
    String diaryMood;
    String diaryDate;
    String diaryDetail;
    ActivitySaveBinding binding;
    NotesViewModel notesViewModel;
    CoordinatorLayout coordinatorLayout;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //using binding to access easily on views
        binding = ActivitySaveBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        notesViewModel = ViewModelProviders.of(this).get(NotesViewModel.class);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        binding.dateText.setText(java.time.LocalDate.now().toString());


        binding.saveButton.setOnClickListener(v -> {
            //saveTodayDate
            todayDate = java.time.LocalDate.now().toString();

            //Get the selected RadioButton value
            int radioButtonID = binding.moodRadioGroup.getCheckedRadioButtonId();
            View radioButton = binding.moodRadioGroup.findViewById(radioButtonID);
            int idx = binding.moodRadioGroup.indexOfChild(radioButton);
            RadioButton r = (RadioButton) binding.moodRadioGroup.getChildAt(idx);


            if (r == null ){
                AlertDialog.Builder builder = new AlertDialog.Builder(SaveActivity.this);
                builder.setTitle("Hey!");
                builder.setMessage("Please fill and check all the fields.");
                builder.setNegativeButton("Okay", null).show();
            }else{
                String selectedText = r.getText().toString();
                diaryMood = selectedText;
                diaryDetail = binding.diaryEntry.getText().toString();

               createNotes( todayDate, diaryMood, diaryDetail);
            }
        });


    }

    private void createNotes(String todayDate,String diaryMood,String diaryDetail){
        Notes note  = new Notes();
        note.notesDate = todayDate;
        note.notesDetail = diaryDetail;
        note.notesMood = diaryMood;
        notesViewModel.insertNotes(note);
        Toast.makeText(this,"Today diary entry created succesffully",Toast.LENGTH_SHORT).show();


        finish();
        System.out.println("save: " + note.id);
    }
}