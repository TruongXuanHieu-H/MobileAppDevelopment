package com.hieuhayho.mobileappdevelopment.Slide9.DatabaseSaver;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

// Base class to control database
// Test cases have not implemented yet
public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "mydatabase.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS " +
                "tasks (_id INTEGER PRIMARY KEY, title TEXT, description TEXT)";
        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Handle database upgrades here
    }

    public long insertTask(String title, String description) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("title", title);
        values.put("description", description);
        return db.insert("tasks", null, values);
    }

    public int updateTask(long taskId, String newTitle, String newDescription) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("title", newTitle);
        values.put("description", newDescription);
        String whereClause = "_id=?";
        String[] whereArgs = {String.valueOf(taskId)};
        return db.update("tasks", values, whereClause, whereArgs);
    }

    public int deleteTask(long taskId) {
        SQLiteDatabase db = this.getWritableDatabase();
        String whereClause = "_id=?";
        String[] whereArgs = {String.valueOf(taskId)};
        return db.delete("tasks", whereClause, whereArgs);
    }

    public Cursor getAllTasks() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.query("tasks", null, null, null, null, null, null);
    }
}
