package msku.ceng.mysecretdiary.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import msku.ceng.mysecretdiary.Dao.UserDao;
import msku.ceng.mysecretdiary.Database.UserDatabase;
import msku.ceng.mysecretdiary.Database.UserEntity;
import msku.ceng.mysecretdiary.R;

public class SettingsActivity extends AppCompatActivity {
    private Button button;


    EditText emailAddress,oldPassword, newPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        button = findViewById(R.id.changePasswordButton);
        emailAddress = findViewById(R.id.editTextEmailAddress);
        oldPassword =findViewById(R.id.editTextOldPassword);
        newPassword = findViewById(R.id.editTextNewPassword);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailAdrText = emailAddress.getText().toString();
                String oldPasswordText = oldPassword.getText().toString();
                String newPasswordText = newPassword.getText().toString();
                if (emailAdrText.isEmpty() || oldPasswordText.isEmpty() || newPasswordText.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Fill all the fields!", Toast.LENGTH_SHORT).show();
                }else{
                    // Perform Query
                    UserDatabase userDatabase = UserDatabase.getUserDatabase(getApplicationContext());
                    final UserDao userDao = userDatabase.userDao();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            UserEntity userEntity = userDao.login(emailAdrText, oldPasswordText);
                            if (userEntity == null){
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(getApplicationContext(), "Invalid Credentials", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }else {
                                userEntity.setPassword(newPasswordText);
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(getApplicationContext(), "Password has changed!", Toast.LENGTH_SHORT).show();
                                    }
                                });

                                Intent i = new Intent(SettingsActivity.this,MainActivity.class);
                                startActivity(i);

                            }
                        }
                    }).start();
                }


            }
        });


    }
}
