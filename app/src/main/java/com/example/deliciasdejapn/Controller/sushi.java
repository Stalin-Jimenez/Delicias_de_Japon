package com.example.deliciasdejapn.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.deliciasdejapn.R;
import com.example.deliciasdejapn.conection.Conexion;

import java.util.ArrayList;

public class sushi extends AppCompatActivity {

    private ListView listadatos;
    private ArrayList datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sushi);

        listadatos=findViewById(R.id.Sushi);

        Conexion dbHelper = new Conexion(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor c = db.rawQuery("select * from tb_comida where nombre='Sushi'", null);
        datos=new ArrayList<>();
        if(c!=null){
            c.moveToFirst();
            do {
                datos.add("Nombre: "+c.getString(c.getColumnIndex("nombre")));
                datos.add("Precio: "+c.getString(c.getColumnIndex("precio")));
                datos.add("Cantidad: "+c.getString(c.getColumnIndex("cantidad")));
                datos.add("Descrpicion: "+c.getString(c.getColumnIndex("descripcion")));
                datos.add("Estado: "+c.getString(c.getColumnIndex("estado")));
                datos.add("=============================");
            } while (c.moveToNext());
        }

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datos);
        listadatos.setAdapter(adapter);

        c.close();
        db.close();

    }

    public void Pedido(View view) {
        String Numero="593982609486";
        String Mensaje="Hola! muy buenas me gustaria hacer un pedido de Sushi";

        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_VIEW);
        String uri = "whatsapp://send?phone="+Numero+"&text="+Mensaje;
        sendIntent.setData(Uri.parse(uri));
        startActivity(sendIntent);
    }
}