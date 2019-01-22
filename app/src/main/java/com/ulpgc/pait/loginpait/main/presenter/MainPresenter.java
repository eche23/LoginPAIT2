package com.ulpgc.pait.loginpait.main.presenter;


import com.ulpgc.pait.loginpait.main.events.MainEvent;

interface MainPresenter {

    void cerrarSesion();
    void onStart();
    void onStop();
    void onEventLoginThread(MainEvent event);
    void obtenerUsuario(String email);
    void eliminarUsuario(String id);
    void actualizarDatos(String id, String email, String username);
}
