package com.example.notesheet.DataBase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.notesheet.Models.Notes;




@Database(entities = Notes.class, version = 1, exportSchema = false)
public abstract class RoomDB extends RoomDatabase {
    private static RoomDB datebase;
    private static String DATABASE_NAME = "NoteApp";

    public synchronized static RoomDB getInstance(Context context){
        if (datebase == null){
            datebase = Room.databaseBuilder(context.getApplicationContext(),
                   RoomDB.class, DATABASE_NAME )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();

        }
        return datebase;
    }

    public abstract MainDAO mainDAO();
}
