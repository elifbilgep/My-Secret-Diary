package msku.ceng.mysecretdiary.Activity;

import androidx.appcompat.app.AppCompatActivity;

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

public class SignUpActivity extends AppCompatActivity {
    private Button signUpButton;

    EditText emailAddress, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        emailAddress = findViewById(R.id.editTextTextEmailAddress);
        password = findViewById(R.id.editTextTextPassword2);
        signUpButton = findViewById(R.id.signUpButton);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creating User Entity
                UserEntity userEntity = new UserEntity();
                userEntity.setEmailAddress(emailAddress.getText().toString());
                userEntity.setPassword(password.getText().toString());
                if (validateInput(userEntity)){
                    //Do insert op.
                    UserDatabase userDatabase = UserDatabase.getUserDatabase(getApplicationContext());
                    UserDao userDao =userDatabase.userDao();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            //Register User
                            userDao.registerUser(userEntity);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getApplicationContext(), "User Registered!", Toast.LENGTH_SHORT).show();
                                }
                            });

                        }
                    }).start();
                }else{
                    Toast.makeText(getApplicationContext(), "Fill all the fields!", Toast.LENGTH_SHORT).show();
                }

                Intent intent = new Intent(v.getContext(),MainActivity.class);
                startActivity(intent);
            }
        });

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }

    private Boolean validateInput(UserEntity userEntity){
        if (userEntity.getEmailAddress().isEmpty()|| userEntity.getPassword().isEmpty()){
            return false;
        }
        return true;
    }
}

