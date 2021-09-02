package com.example.deliciasdejapn.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.deliciasdejapn.Controller.Login;
import com.example.deliciasdejapn.Controller.Registrar;
import com.example.deliciasdejapn.Controller.Registrar_Comida;
import com.example.deliciasdejapn.conection.Conexion;
import com.example.deliciasdejapn.interfaz.IUsuario;
import com.example.deliciasdejapn.model.Comida;
import com.example.deliciasdejapn.model.Usuario;


public class DaoUsuario implements IUsuario {

        @Override
        public boolean create(Usuario object, Registrar context) {
            boolean respuesta=false;
            Conexion conexion=new Conexion(context);
            SQLiteDatabase consulta=conexion.getWritableDatabase();
            ContentValues registro=new ContentValues();
            registro.put("nombre", object.getNombre());
            registro.put("correo", object.getCorreo());
            registro.put("clave", object.getClave());
            registro.put("estado", object.getEstado());

            if(consulta.insert("tb_usuario", null, registro) > 0){
                respuesta=true;
                consulta.close();
            }
            return respuesta;
        }

    @Override
    public boolean login(Usuario object, Login context) {
            boolean respuesta=false;
            Conexion conexion=new Conexion(context);
            SQLiteDatabase consulta=conexion.getReadableDatabase();
            Cursor registros=consulta.rawQuery("select correo, clave from tb_usuario where estado=1", null);
        if(registros.moveToFirst()){
            do{
                if(registros.getString(0).equals(object.getCorreo()) && registros.getString(1).equals(object.getClave())){
                    respuesta= true;
                }
            }while (registros.moveToNext());
        }
        conexion.close();
        return respuesta;
    }

    @Override
    public boolean registrarC(Comida object, Registrar_Comida context) {
        boolean respuesta=false;
        Conexion conexion=new Conexion(context);
        SQLiteDatabase consulta=conexion.getWritableDatabase();
        ContentValues registro=new ContentValues();
        registro.put("nombre", object.getNombre());
        registro.put("precio", object.getPrecio());
        registro.put("cantidad", object.getCantidad());
        registro.put("descripcion", object.getDescrpicion());
        registro.put("estado", object.getEstado());

        if(consulta.insert("tb_comida", null, registro) > 0){
            respuesta=true;
            consulta.close();
        }
        return respuesta;
    }

}
