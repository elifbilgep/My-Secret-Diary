package msku.ceng.mysecretdiary.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import msku.ceng.mysecretdiary.Activity.NotesActivity;
import msku.ceng.mysecretdiary.Activity.UpdateActivity;
import msku.ceng.mysecretdiary.Model.Notes;
import msku.ceng.mysecretdiary.R;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.notesViewHolder> {
    NotesActivity notesActivity;
    List<Notes> notes;

    public NotesAdapter(NotesActivity notesActivity, List<Notes> notes) {
        this.notesActivity = notesActivity;
        this.notes = notes;
    }

    @Override
    public notesViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        return new notesViewHolder(
                LayoutInflater.from(notesActivity).inflate(R.layout.item_notes,parent,false));
    }

    @Override
    public void onBindViewHolder(notesViewHolder holder, int position) {
        Notes note = notes.get(position);
        holder.day.setText(note.notesDate);
        holder.mood.setText(note.notesMood);
        holder.noteDetail.setText(note.notesDetail);

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(notesActivity, UpdateActivity.class);

            intent.putExtra("id",note.id);
            intent.putExtra("mood",note.notesMood);
            intent.putExtra("noteDetail",note.notesDetail);
            intent.putExtra("date",note.notesDate);

            notesActivity.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    static class notesViewHolder extends RecyclerView.ViewHolder {
        TextView day, mood,noteDetail;
        public notesViewHolder(View itemView) {
            super(itemView);
            day = itemView.findViewById(R.id.dayText);
            mood = itemView.findViewById(R.id.moodText);
            noteDetail = itemView.findViewById(R.id.noteDetail);
        }
    }
}
