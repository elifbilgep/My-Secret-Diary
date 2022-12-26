package msku.ceng.mysecretdiary.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import msku.ceng.mysecretdiary.Activity.NotesActivity;
import msku.ceng.mysecretdiary.Model.Notes;
import msku.ceng.mysecretdiary.R;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.notesViewHolder> {
    NotesActivity notesActivity; List<Notes> notes;

    public NotesAdapter(NotesActivity notesActivity, List<Notes> notes) {
        this.notesActivity = notesActivity;
        this.notes = notes;
    }

    @Override
    public notesViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {

        return new notesViewHolder(LayoutInflater.from(notesActivity).inflate(R.layout.item_notes,parent,false));
    }

    @Override
    public void onBindViewHolder(notesViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class notesViewHolder extends RecyclerView.ViewHolder {
        public notesViewHolder(View itemView) {
            super(itemView);
        }
    }
}
