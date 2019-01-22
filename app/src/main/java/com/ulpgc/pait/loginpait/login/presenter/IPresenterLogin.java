package com.ulpgc.pait.loginpait.login.presenter;


import com.ulpgc.pait.loginpait.login.events.LoginEvents;

public interface IPresenterLogin {

    void onCreate();
    void onDestroy();
    void toLogin(String email, String password);
    void forgotPassword(String email);
    void onEventLoginThread(LoginEvents events);
}