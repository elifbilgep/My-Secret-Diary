package msku.ceng.mysecretdiary.Repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import msku.ceng.mysecretdiary.Dao.NotesDao;
import msku.ceng.mysecretdiary.Database.NotesDatabase;
import msku.ceng.mysecretdiary.Model.Notes;

public class NotesRepository {
    public NotesDao notesDao;
    public LiveData<List<Notes>> getAllNotes;
    public LiveData<List<Notes>> getAllNotesHappy;
    public LiveData<List<Notes>> getAllNotesSad;
    public LiveData<List<Notes>> getAllNotesAngry;
    public LiveData<List<Notes>> getAllNotesExcited;


    public NotesRepository(Application application){
        NotesDatabase database = NotesDatabase.getDatabaseInstance(application);
        notesDao = database.notesDao();
        getAllNotes  = notesDao.getAllNotes();
        getAllNotesHappy = notesDao.getAllNotesHappy();
        getAllNotesSad = notesDao.getAllNotesSad();
        getAllNotesAngry = notesDao.getAllNotesAngry();
        getAllNotesExcited = notesDao.getAllNotesExcited();
    }

   public void insertNotes(Notes notes){
        notesDao.insertNotes(notes);
    }

   public void deleteNotes(int id){
        notesDao.deleteNotes(id);
    }

   public  void updateNotes(Notes notes){
        notesDao.updateNotes(notes);
    }


}
