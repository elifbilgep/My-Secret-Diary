package msku.ceng.mysecretdiary.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import msku.ceng.mysecretdiary.Dao.UserDao;

@Database(entities = {UserEntity.class}, version = 1)
public abstract class UserDatabase {

    private static final String dbName = "user";
    private static UserDatabase userDatabase;

    public static synchronized UserDatabase getUserDatabase(Context context){

        if (userDatabase == null){
            userDatabase = Room.databaseBuilder(context, UserDatabase., dbName)
                    .fallbackToDestructiveMigration()
                    .build();
        }

        return userDatabase;
    }

    public abstract UserDao userDao();
}
