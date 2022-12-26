package msku.ceng.mysecretdiary.Model;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "DiaryDB")
public class Notes {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "diariesDate")
    public String notesDate;

    @ColumnInfo(name = "diariesDetail")
    public String notesDetail;

    @ColumnInfo(name = "mood")
    public String notes;

}
