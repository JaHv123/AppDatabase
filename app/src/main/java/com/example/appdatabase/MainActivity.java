package com.example.appdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private DatabaseOpenHelper databaseOpenHelper;
    private SimpleCursorAdapter simpleCursorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseOpenHelper = new DatabaseOpenHelper(this);
        limpiarDB();
        insertarDB();

        Cursor cursor = leerDatos();

        for (cursor.moveToFirst();!cursor.isAfterLast();cursor.moveToNext()){
            String equipo = cursor.getString(1);
            Toast.makeText(this,equipo,Toast.LENGTH_LONG).show();
        }
    }

    private void limpiarDB(){
        databaseOpenHelper.getWritableDatabase().delete(DatabaseOpenHelper.TABLE_NAME,null,null);

    }

    private void insertarDB(){
        ContentValues values= new ContentValues();
        values.put(DatabaseOpenHelper.EQUIPO_NOMBRE,"Peru");

        databaseOpenHelper.getWritableDatabase().insert(databaseOpenHelper.TABLE_NAME,
                null,values);

        values.clear();

        values.put(DatabaseOpenHelper.EQUIPO_NOMBRE,"Argentina");

        databaseOpenHelper.getWritableDatabase().insert(databaseOpenHelper.TABLE_NAME,
                null,values);

        values.clear();


        values.put(DatabaseOpenHelper.EQUIPO_NOMBRE,"Brasil");

        databaseOpenHelper.getWritableDatabase().insert(databaseOpenHelper.TABLE_NAME,
                null,values);

        values.clear();


        values.put(DatabaseOpenHelper.EQUIPO_NOMBRE,"Chile");

        databaseOpenHelper.getWritableDatabase().insert(databaseOpenHelper.TABLE_NAME,
                null,values);
        values.clear();

    }

    private Cursor leerDatos(){
        return databaseOpenHelper.getWritableDatabase().query(DatabaseOpenHelper.TABLE_NAME,
                databaseOpenHelper.columns,null,new String[]{},null,null,null);

    }
}
