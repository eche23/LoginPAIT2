/*package com.ulpgc.pait.loginpait.main.presenter;


import com.ulpgc.pait.loginpait.main.events.MainEvent;
import com.ulpgc.pait.loginpait.main.model.IModelMain;
import com.ulpgc.pait.loginpait.main.model.ModelMain;
import com.ulpgc.pait.loginpait.main.view.IViewMain;
import com.ulpgc.pait.loginpait.main.view.MainActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class PresenterMain implements IPresenterMain {

    private IViewMain view;
    private IModelMain model;
    private EventBus eventBus;

    public PresenterMain(MainActivity view) {
        this.view = view;
        model = new ModelMain();
        eventBus = EventBus.getDefault();
    }

    @Override
    public void onStart() {
        eventBus.register(this);
    }

    @Override
    public void onStop() {
        eventBus.unregister(this);
    }

    @Override
    @Subscribe
    public void onEventLoginThread(MainEvent event) {
        switch (event.getEventType()) {
            case MainEvent.SUCCESS_DATA_GET_FROM_DB:
                view.setData(event.getUsuario());
                break;
            case MainEvent.FAIL_DATA_GET_FROM_DB:
                view.showToast("Error al cargar los datos");
                break;
            case  MainEvent.UPDATE_SUCCESS:
                view.showToast("Actualizacion Completada");
                view.setData(event.getUsuario());
                break;
            case MainEvent.UPDATE_ERROR:
                view.showToast("No se ha podido actualizar correctamente");
                break;
            case MainEvent.LOGOUT_SUCCESS:
                view.showToast("Hasta pronto!");
                view.backToLogin();
                break;
            case MainEvent.DELETE_ERROR:
                view.showToast("Error, no se ha podido borrar");
                break;
            case MainEvent.DELETE_SUCCESS:
                view.showToast("Account Deleted");
                view.backToLogin();
        }
    }

    @Override
    public void loadData(String email) {
        model.loadData(email);
    }

    @Override
    public void updateName(String id, String newName) {
        model.updateData(id,newName);
    }

    @Override
    public void logOut() {
        model.logOut();
    }

    @Override
    public void deleteAccount(String id) {
        model.deleteData(id);
    }
}*/
