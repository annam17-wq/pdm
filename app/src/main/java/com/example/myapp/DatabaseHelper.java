package com.example.myapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "notas.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_NOTAS = "notas";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_TITULO = "titulo";
    public static final String COLUMN_TEXTO = "texto";

    private static final String TABLE_CREATE =
            "CREATE TABLE " + TABLE_NOTAS + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_TITULO + " TEXT, " +
                    COLUMN_TEXTO + " TEXT" +
                    ");";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTAS);
        onCreate(db);
    }

    public long inserirNota(String titulo, String texto) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_TITULO, titulo);
        values.put(COLUMN_TEXTO, texto);
        long id = db.insert(TABLE_NOTAS, null, values);
        db.close();
        return id;
    }

    public List<Nota> obterTodasNotas() {
        List<Nota> listaNotas = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_NOTAS + " ORDER BY " + COLUMN_ID + " DESC";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                int idIndex = cursor.getColumnIndex(COLUMN_ID);
                int tituloIndex = cursor.getColumnIndex(COLUMN_TITULO);
                int textoIndex = cursor.getColumnIndex(COLUMN_TEXTO);

                int id = cursor.getInt(idIndex);
                String titulo = cursor.getString(tituloIndex);
                String texto = cursor.getString(textoIndex);

                Nota nota = new Nota(id, titulo, texto);
                listaNotas.add(nota);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return listaNotas;
    }
}
