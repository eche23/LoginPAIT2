package com.ulpgc.pait.loginpait.main.view;

import com.ulpgc.pait.loginpait.user.User;

public interface IViewMain {
    void irALogin();
    void cerrarSesion();
    void mostrarEmail();
    void mostrarCargando();
    void ocultarCargando();
    void obtenerUsuario(String email);
    void pintarUsuario(User usuario);
    void errorObtenerDatos();
    void eliminarUsuario(String id);
    void eliminarUsuarioSatisfactorio();
    void eliminarUsuarioError();
    void actualizarDatos(String id, String email, String username);
    void mensajeActualizarDatos();
}
