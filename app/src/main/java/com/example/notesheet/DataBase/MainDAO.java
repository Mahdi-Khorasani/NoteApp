package com.example.notesheet.DataBase;

import static androidx.room.OnConflictStrategy.REPLACE;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.notesheet.Models.Notes;

import java.util.List;

@Dao
public interface MainDAO {
    @Insert(onConflict = REPLACE)
    void insert(Notes notes);
@Query("SELECT * FROM notes ORDER BY ID DESC")
    List<Notes> getAL();

    @Query("UPDATE notes Set title = :title, notes = :notes WHERE ID = :ID ")
    void update (int ID, String title, String notes);
@Delete
    void delete (Notes notes);
@Query("UPDATE notes SET pinned = :pin WHERE ID = :id")
    void  pin(int id, boolean pin);

}
