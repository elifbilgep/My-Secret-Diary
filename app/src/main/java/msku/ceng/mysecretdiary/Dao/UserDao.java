package msku.ceng.mysecretdiary.Dao;

import androidx.room.Dao;
import androidx.room.Insert;

import msku.ceng.mysecretdiary.Database.UserEntity;

@Dao
public interface UserDao {

    @Insert
    void registerUser(UserEntity userEntity);
}
