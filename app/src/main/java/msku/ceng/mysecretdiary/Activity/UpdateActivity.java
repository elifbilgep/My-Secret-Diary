package msku.ceng.mysecretdiary.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import msku.ceng.mysecretdiary.Model.Notes;
import msku.ceng.mysecretdiary.R;
import msku.ceng.mysecretdiary.ViewModel.NotesViewModel;
import msku.ceng.mysecretdiary.databinding.ActivitySaveBinding;
import msku.ceng.mysecretdiary.databinding.ActivityUpdateBinding;

public class UpdateActivity extends AppCompatActivity {
    ActivityUpdateBinding binding;

    String sMood;
    String sDate;
    String sNoteDetail;
    int iId;

    NotesViewModel notesViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUpdateBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        notesViewModel = ViewModelProviders.of(this).get(NotesViewModel.class);

        iId = getIntent().getIntExtra("id",0);
        System.out.println(iId);
        sMood = getIntent().getStringExtra("mood");
        sDate = getIntent().getStringExtra("date");
        sNoteDetail = getIntent().getStringExtra("noteDetail");

        switch (sMood) {
            case "Happy":
                binding.updateHappyCheckBox.setChecked(true);
                break;
            case "Sad":
                binding.updateSadCheckBox.setChecked(true);
                break;
            case "Angry":
                binding.updateAngryCheckBox.setChecked(true);
                break;
            case "Excited":
                binding.updateExcitedCheckBox.setChecked(true);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + sMood);
        }
        binding.updateDiaryEntry.setText(sNoteDetail);
        binding.updateDateText.setText(sDate);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        
        binding.updateSaveButton.setOnClickListener(v -> {
          
                int radioButtonID = binding.updateMoodRadioGroup.getCheckedRadioButtonId();
                View radioButton = binding.updateMoodRadioGroup.findViewById(radioButtonID);
                int idx = binding.updateMoodRadioGroup.indexOfChild(radioButton);
                RadioButton r = (RadioButton) binding.updateMoodRadioGroup.getChildAt(idx);
                String selectedText = r.getText().toString();
                String diaryMood = selectedText;
                String diaryDetail = binding.updateDiaryEntry.getText().toString();
                UpdateNotes( sDate, diaryMood, diaryDetail);
            }
        );
    }

    private void UpdateNotes(String sDate, String diaryMood, String diaryDetail) {

            Notes updateNote  = new Notes();
            updateNote.id = iId;
            updateNote.notesDate = sDate;
            updateNote.notesDetail = diaryDetail;
            updateNote.notesMood = diaryMood;

            notesViewModel.updateNotes(updateNote);

            Toast.makeText(this,"Today diary entry created succesffully",Toast.LENGTH_SHORT).show();

            finish();

    }


}

