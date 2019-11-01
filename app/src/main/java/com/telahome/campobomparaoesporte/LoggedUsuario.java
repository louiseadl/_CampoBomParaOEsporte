package com.telahome.campobomparaoesporte;

import com.telahome.campobomparaoesporte.Models.Usuario;

public class LoggedUsuario {
    static private Usuario usuario;

    public static void setUsuario(Usuario usuario) {
        usuario = usuario;
    }

    public static Usuario getUsuario(){
        return usuario;
    }
}
