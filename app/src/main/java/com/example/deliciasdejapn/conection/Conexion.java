package com.example.deliciasdejapn.conection;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Conexion extends SQLiteOpenHelper {

    private static final String database="bd_mercagro";
    private static final int version=1;
    private static final String tb_usuario="create table if not exists tb_usuario(id_usuario integer primary key autoincrement,\n" +
            "nombre text, correo text, clave text, estado integer);";
    private static final String tb_comida="create table if not exists tb_comida(id_comida integer primary key autoincrement,\n" +
            "nombre text, precio text, cantidad text, descripcion text, estado integer);";

    public Conexion(Context context){
        super(context, database, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(tb_usuario);
        sqLiteDatabase.execSQL(tb_comida);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
