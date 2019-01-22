package com.ulpgc.pait.loginpait.main.model;

interface MainRepository {

    void cerrarSesion();
    void obtenerUsuario(final String email);
    void eliminarUsuario(final String id);
    void actualizarDatos(String id, String email, String username);
}
