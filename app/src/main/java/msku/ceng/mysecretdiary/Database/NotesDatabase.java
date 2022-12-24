package msku.ceng.mysecretdiary.Database;
import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import msku.ceng.mysecretdiary.Model.Notes;
import msku.ceng.mysecretdiary.Dao.NotesDao;

@Database(entities = {Notes.class},version = 1)
public abstract class NotesDatabase extends RoomDatabase {

    public abstract NotesDao notesDao();

    public static NotesDatabase INSTANCE;

    public static NotesDatabase getDatabaseInstance(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),NotesDatabase.class, "NotesDB").build();
        }
        return INSTANCE;
    }
}
