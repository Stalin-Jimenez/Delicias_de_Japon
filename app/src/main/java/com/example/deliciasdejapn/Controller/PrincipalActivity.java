package com.example.deliciasdejapn.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.deliciasdejapn.R;

public class PrincipalActivity extends AppCompatActivity {

    Button ingresar;
    Button registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        ingresar=(Button)findViewById(R.id.button1);
        registrar=(Button)findViewById(R.id.button2);

        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ingresar= new Intent(PrincipalActivity.this, Login.class);
                startActivity(ingresar);


            }
        });

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registrar= new Intent(PrincipalActivity.this, Registrar.class);
                startActivity(registrar);


            }
        });
    }
}