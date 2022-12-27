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


    @Query("SELECT * FROM NotesDB WHERE mood= 'Happy' ")
     LiveData<List<Notes>> getAllNotesHappy();

    @Query("SELECT * FROM NotesDB WHERE mood= 'Sad' ")
    LiveData<List<Notes>> getAllNotesSad();

    @Query("SELECT * FROM NotesDB WHERE mood= 'Excited' ")
    LiveData<List<Notes>> getAllNotesExcited();

    @Query("SELECT * FROM NotesDB WHERE mood= 'Angry' ")
    LiveData<List<Notes>> getAllNotesAngry();

    @Insert
    void insertNotes(Notes... note);

    @Query("DELETE FROM NotesDB WHERE id=:id")
    void deleteNotes(int id);

    @Update
    void updateNotes(Notes note);
}
