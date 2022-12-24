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


    public NotesRepository(Application application){
        NotesDatabase database = NotesDatabase.getDatabaseInstance(application.getApplicationContext());
        notesDao = database.notesDao();
        getAllNotes  = notesDao.getAllNotes();
    }

   public   void insertNotes(Notes notes){
        notesDao.insertNotes(notes);
    }

    public void deleteNotes(int id){
        notesDao.deleteNotes(id);
    }

   public  void updateNotes(Notes notes){
        notesDao.updateNotes(notes);
    }
}
