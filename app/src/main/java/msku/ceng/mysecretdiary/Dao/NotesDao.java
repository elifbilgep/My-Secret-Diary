package msku.ceng.mysecretdiary.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import msku.ceng.mysecretdiary.Model.Notes;

@androidx.room.Dao
public interface NotesDao {

    @Query("SELECT * FROM NotesDB")
    LiveData<List<Notes>> getAllNotes();


    @Query("SELECT * FROM NotesDB WHERE mood= :mood ")
     List<Notes> getAllNotesAccMood(String mood);

    @Insert
    void insertNotes(Notes... note);

    @Query("DELETE FROM NotesDB WHERE id=:id")
    void deleteNotes(int id);

    @Update
    void updateNotes(Notes note);
}
