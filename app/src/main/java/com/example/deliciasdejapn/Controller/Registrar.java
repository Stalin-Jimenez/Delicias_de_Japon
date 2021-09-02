package com.example.deliciasdejapn.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.deliciasdejapn.R;
import com.example.deliciasdejapn.dao.DaoUsuario;
import com.example.deliciasdejapn.model.Usuario;
import com.google.android.material.textfield.TextInputEditText;

public class Registrar extends AppCompatActivity {

    private TextInputEditText nombre;
    private TextInputEditText correo;
    private TextInputEditText clave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        this.nombre=findViewById(R.id.TxtNombre);
        this.correo=findViewById(R.id.TxtCorreo);
        this.clave=findViewById(R.id.TxtClave);
    }
    public void onClick(View view) {
        if(view.getId() == R.id.Btn_registrar){
            Usuario object = new Usuario();
            DaoUsuario dao =new DaoUsuario();

            object.setNombre(nombre.getText().toString());
            object.setCorreo(correo.getText().toString());
            object.setClave(clave.getText().toString());
            object.setEstado(1);

            if(dao.create(object, this) == true){
                Toast toast1 = Toast.makeText(getApplicationContext(), "Usuario creado exitosamente", Toast.LENGTH_SHORT);
                toast1.show();

                Intent iniciar=new Intent(Registrar.this, Login.class);
                startActivity(iniciar);

            }else {
                Toast toast1 = Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT);
                toast1.show();
            }
        }
    }
}