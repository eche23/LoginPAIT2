package com.ulpgc.pait.loginpait.register.presenter;


import com.ulpgc.pait.loginpait.register.events.RegisterEvent;

public interface IPresenterRegister {

    void register(String email, String password, String name);

    void onCreate();
    void onStop();
    void onEventLoginThread(RegisterEvent event);
}
