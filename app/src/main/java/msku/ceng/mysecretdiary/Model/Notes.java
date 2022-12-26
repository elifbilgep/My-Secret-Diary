package msku.ceng.mysecretdiary.Model;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "NotesDB")
public class Notes {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "notesDate")
    public String notesDate;

    @ColumnInfo(name = "noteDetail")
    public String notesDetail;

    @ColumnInfo(name = "mood")
    public String notesMood;

}
