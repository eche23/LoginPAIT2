package com.ulpgc.pait.loginpait.main.model;

interface MainInteractor {

    void cerrarSesion();
    void obtenerUsuario(String email);
    void eliminarUsuario(String id);
    void actualizarDatos(String id, String email, String username);
}
