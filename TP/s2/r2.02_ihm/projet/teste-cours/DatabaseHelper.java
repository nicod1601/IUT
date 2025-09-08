package com.example.coursapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "cours.db";
    private static final int DATABASE_VERSION = 1;

    // Table Cours
    private static final String TABLE_COURS = "cours";
    private static final String COLUMN_COURS_ID = "id";
    private static final String COLUMN_COURS_NOM = "nom";

    // Table Parties
    private static final String TABLE_PARTIES = "parties";
    private static final String COLUMN_PARTIE_ID = "id";
    private static final String COLUMN_PARTIE_NOM = "nom";
    private static final String COLUMN_COURS_FK = "cours_id";

    // Table Contenu
    private static final String TABLE_CONTENU = "contenu";
    private static final String COLUMN_CONTENU_ID = "id";
    private static final String COLUMN_CONTENU_TEXTE = "texte";
    private static final String COLUMN_PARTIE_FK = "partie_id";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createCoursTable = "CREATE TABLE " + TABLE_COURS + " (" +
                COLUMN_COURS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_COURS_NOM + " TEXT NOT NULL);";
        db.execSQL(createCoursTable);

        String createPartiesTable = "CREATE TABLE " + TABLE_PARTIES + " (" +
                COLUMN_PARTIE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_PARTIE_NOM + " TEXT NOT NULL, " +
                COLUMN_COURS_FK + " INTEGER, FOREIGN KEY(" + COLUMN_COURS_FK + ") REFERENCES " + TABLE_COURS + "(" + COLUMN_COURS_ID + "))";
        db.execSQL(createPartiesTable);

        String createContenuTable = "CREATE TABLE " + TABLE_CONTENU + " (" +
                COLUMN_CONTENU_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_CONTENU_TEXTE + " TEXT NOT NULL, " +
                COLUMN_PARTIE_FK + " INTEGER, FOREIGN KEY(" + COLUMN_PARTIE_FK + ") REFERENCES " + TABLE_PARTIES + "(" + COLUMN_PARTIE_ID + "))";
        db.execSQL(createContenuTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COURS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PARTIES);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTENU);
        onCreate(db);
    }
}