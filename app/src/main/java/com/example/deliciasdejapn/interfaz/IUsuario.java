package com.example.deliciasdejapn.interfaz;

import com.example.deliciasdejapn.Controller.Login;
import com.example.deliciasdejapn.Controller.Registrar;
import com.example.deliciasdejapn.Controller.Registrar_Comida;
import com.example.deliciasdejapn.model.Comida;
import com.example.deliciasdejapn.model.Usuario;


public interface IUsuario {
    public boolean create(Usuario object, Registrar context);
    public boolean login(Usuario object, Login context);
    public boolean registrarC(Comida object, Registrar_Comida context);

}
