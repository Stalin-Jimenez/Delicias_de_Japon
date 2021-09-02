package com.example.deliciasdejapn.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.deliciasdejapn.R;
import com.example.deliciasdejapn.dao.DaoUsuario;
import com.example.deliciasdejapn.model.Comida;
import com.example.deliciasdejapn.model.Usuario;
import com.google.android.material.textfield.TextInputEditText;

public class Registrar_Comida extends AppCompatActivity {

    private TextInputEditText nombre;
    private TextInputEditText precio;
    private TextInputEditText cantidad;
    private TextInputEditText descrpicion;
    private TextInputEditText estado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar__comida);

        this.nombre=findViewById(R.id.TxtNombre);
        this.precio=findViewById(R.id.TxtPrecio);
        this.cantidad=findViewById(R.id.TxtCantidad);
        this.descrpicion=findViewById(R.id.TxtDescrpicion);
        this.estado=findViewById(R.id.TxtEstado);

    }

    public void Registrar(View view) {
        if(view.getId() == R.id.BtnRegistrar_C){

            Comida object = new Comida();
            DaoUsuario dao =new DaoUsuario();

            object.setNombre(nombre.getText().toString());
            object.setPrecio(precio.getText().toString());
            object.setCantidad(cantidad.getText().toString());
            object.setDescrpicion(descrpicion.getText().toString());
            object.setEstado(estado.getInputType());

            if(dao.registrarC(object, this) == true){
                Toast toast1 = Toast.makeText(getApplicationContext(), "Comida Registrada exitosamente", Toast.LENGTH_SHORT);
                toast1.show();


            }else {
                Toast toast1 = Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT);
                toast1.show();
            }

        }
    }

    public void home(View view) {
        Intent iniciar=new Intent(Registrar_Comida.this, Home.class);
        startActivity(iniciar);
    }
}