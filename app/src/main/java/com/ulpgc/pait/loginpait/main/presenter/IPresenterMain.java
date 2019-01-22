package com.ulpgc.pait.loginpait.main.presenter;

import com.ulpgc.pait.loginpait.main.events.MainEvent;

import org.greenrobot.eventbus.Subscribe;

public interface IPresenterMain {
    void cerrarSesion();
    void onStart();
    void onStop();
    void onEventLoginThread(MainEvent event);
    void obtenerUsuario(String email);
    void eliminarUsuario(String id);
    void actualizarDatos(String id, String email, String username);

}
