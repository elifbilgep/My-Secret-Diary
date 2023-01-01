package msku.ceng.mysecretdiary.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import msku.ceng.mysecretdiary.Dao.UserDao;
import msku.ceng.mysecretdiary.Database.UserDatabase;
import msku.ceng.mysecretdiary.Database.UserEntity;
import msku.ceng.mysecretdiary.R;

public class SignInActivity extends AppCompatActivity {
    private Button button;
    private TextView dontHaveAccText;

    EditText emailAddress, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        button = findViewById(R.id.signInButton);
        dontHaveAccText = findViewById(R.id.dontHaveAccText);
        emailAddress = findViewById(R.id.editTextTextEmailAddress);
        password = findViewById(R.id.editTextTextPassword2);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailAdrText = emailAddress.getText().toString();
                String passText = password.getText().toString();
                if (emailAdrText.isEmpty() || passText.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Fill all the fields!", Toast.LENGTH_SHORT).show();
                }else{
                    // Perform Query
                    UserDatabase userDatabase = UserDatabase.getUserDatabase(getApplicationContext());
                    final UserDao userDao = userDatabase.userDao();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            UserEntity userEntity = userDao.login(emailAdrText, passText);
                            if (userEntity == null){
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(getApplicationContext(), "Invalid Credentials", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }else {
                                Intent intent = new Intent(v.getContext(),NotesActivity.class);
                                startActivity(intent);
                            }
                        }
                    }).start();
                }


            }
        });

        dontHaveAccText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),SignUpActivity.class);
                startActivity(intent);
            }
        });

    }
}