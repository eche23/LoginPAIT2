package com.ulpgc.pait.loginpait.main.model;

public interface IModelMain {
    void cerrarSesion();
    void obtenerUsuario(String email);
    void eliminarUsuario(String id);
    void actualizarDatos(String id, String email, String username);

}
