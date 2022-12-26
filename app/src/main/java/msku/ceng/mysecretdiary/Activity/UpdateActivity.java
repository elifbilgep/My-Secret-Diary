package msku.ceng.mysecretdiary.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import msku.ceng.mysecretdiary.R;
import msku.ceng.mysecretdiary.databinding.ActivitySaveBinding;
import msku.ceng.mysecretdiary.databinding.ActivityUpdateBinding;

public class UpdateActivity extends AppCompatActivity {
    ActivityUpdateBinding binding;

    String sMood;
    String sDate;
    String sNoteDetail;
    String sId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUpdateBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        sId = getIntent().getStringExtra("id");
        sMood = getIntent().getStringExtra("mood");
        sDate = getIntent().getStringExtra("date");
        sNoteDetail = getIntent().getStringExtra("noteDetail");

      switch (sMood){
          case "Happy":
              binding.updateHappyCheckBox.setChecked(true);
              break;
          case  "Sad":
              binding.updateSadCheckBox.setChecked(true);
              break;
          case  "Angry":
              binding.updateAngryCheckBox.setChecked(true);
              break;
          case  "Excited":
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

        binding.updateSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedText = r.getText().toString();
                diaryMood = selectedText;
                diaryDetail = binding.diaryEntry.getText().toString();

                updateNotes( todayDate, diaryMood, diaryDetail);
            }
        });
    }


}