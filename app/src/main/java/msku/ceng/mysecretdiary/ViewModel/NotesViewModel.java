package msku.ceng.mysecretdiary.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import msku.ceng.mysecretdiary.Model.Notes;
import msku.ceng.mysecretdiary.Repository.NotesRepository;

public class NotesViewModel extends AndroidViewModel {

    public NotesRepository repository;
    public LiveData<List<Notes>> getAllNotes;


    public NotesViewModel(@NonNull Application application) {
        super(application);

         repository = new NotesRepository(application);
         getAllNotes = repository.getAllNotes;
    }

    public void insertNotes(Notes notes){
        repository.insertNotes(notes);
    };

    public void deleteNotes(int id){
        repository.deleteNotes(id);
    };

    public void updateNotes(Notes notes){
        repository.insertNotes(notes);
    };
}
