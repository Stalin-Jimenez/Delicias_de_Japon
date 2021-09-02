package com.example.deliciasdejapn.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.deliciasdejapn.R;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void ramen(View view) {
        Intent registrar=new Intent(Home.this, ramen.class);
        startActivity(registrar);
    }

    public void teriyaki(View view) {
        Intent registrar=new Intent(Home.this, teriyaki.class);
        startActivity(registrar);
    }

    public void dorayaki(View view) {
        Intent registrar=new Intent(Home.this, dorayaki.class);
        startActivity(registrar);
    }

    public void sushi(View view) {
        Intent registrar=new Intent(Home.this, sushi.class);
        startActivity(registrar);
    }


}