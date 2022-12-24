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

    @ColumnInfo(name = "notesDetail")
    public String notesDetail;

    @ColumnInfo(name = "categoryName")
    public   String categoryName;

}
