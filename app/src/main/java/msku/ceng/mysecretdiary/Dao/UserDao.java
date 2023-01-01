package msku.ceng.mysecretdiary.Dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import msku.ceng.mysecretdiary.Database.UserEntity;

@Dao
public interface UserDao {

    @Insert
    void registerUser(UserEntity userEntity);

    @Query("SELECT * from users where emailAddress=(:emailAddress) and password=(:password)")
    UserEntity login(String emailAddress, String password);
}
