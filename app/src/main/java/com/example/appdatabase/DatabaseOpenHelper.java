package com.example.appdatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseOpenHelper extends SQLiteOpenHelper{
    final static String TABLE_NAME="equipos";
    final static String _ID="_id";
    final static String EQUIPO_NOMBRE="nombre";
    final static String[] columns={_ID,EQUIPO_NOMBRE};

    final  private static  String CREAR_TABLA="CREATE TABLE " + TABLE_NAME +
            "(" + _ID + " INTEGER PRIMARY KEY, " +
            EQUIPO_NOMBRE + " TEXT NOT NULL) ";

    final private static String DB_NAME="copa_america";
    final private static Integer version=1;

    final private Context mcontext;

    public DatabaseOpenHelper(Context context){
        super(context,DB_NAME,null,version);
        this.mcontext=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREAR_TABLA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    void deleteDatabase(){
        this.mcontext.deleteDatabase(DB_NAME);
    }
}
