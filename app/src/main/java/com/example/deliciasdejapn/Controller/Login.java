package com.example.deliciasdejapn.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.deliciasdejapn.R;
import com.example.deliciasdejapn.dao.DaoUsuario;
import com.example.deliciasdejapn.model.Usuario;
import com.google.android.material.textfield.TextInputEditText;

public class Login extends AppCompatActivity {

    private TextInputEditText correo;
    private TextInputEditText clave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.correo=findViewById(R.id.TxtCorreo_L);
        this.clave=findViewById(R.id.TxtClave_L);

    }

    public void Iniciar(View view) {
        if(view.getId() == R.id.BtnIniciar_L){
            if(correo.getText().toString().equals("Stalin") && clave.getText().toString().equals("123")){
                Toast toast1 = Toast.makeText(getApplicationContext(), "Bienvenido Admin", Toast.LENGTH_SHORT);
                toast1.show();
                Intent iniciar=new Intent(Login.this, Registrar_Comida.class);
                startActivity(iniciar);
            }else{
                Usuario object = new Usuario();
                DaoUsuario dao = new DaoUsuario();

                object.setCorreo(correo.getText().toString());
                object.setClave(clave.getText().toString());

                if(dao.login(object, this) == true){
                    Toast toast1 = Toast.makeText(getApplicationContext(), "Logueo Exitoso", Toast.LENGTH_SHORT);
                    toast1.show();
                    Intent iniciar=new Intent(Login.this, Home.class);
                    startActivity(iniciar);

                }else {
                    Toast toast1 = Toast.makeText(getApplicationContext(), "Datos incorectos", Toast.LENGTH_SHORT);
                    toast1.show();
                }
            }
        }
    }
}