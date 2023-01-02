package msku.ceng.mysecretdiary.Dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import msku.ceng.mysecretdiary.Database.UserEntity;

@Dao
public interface UserDao {

    @Insert
    void registerUser(UserEntity userEntity);

    @Query("SELECT * FROM users WHERE emailAddress=(:emailAddress) AND password=(:password)")
    UserEntity login(String emailAddress, String password);

/*    @Query("SELECT * FROM users ORDER BY id DESC LIMIT 10")
    UserEntity getLast10Users();*/
}
