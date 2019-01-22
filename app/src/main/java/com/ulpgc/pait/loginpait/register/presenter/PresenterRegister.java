package com.ulpgc.pait.loginpait.register.presenter;

import com.ulpgc.pait.loginpait.register.events.RegisterEvent;
import com.ulpgc.pait.loginpait.register.model.IModelRegister;
import com.ulpgc.pait.loginpait.register.model.ModelRegister;
import com.ulpgc.pait.loginpait.register.view.IViewRegister;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;


public class PresenterRegister implements IPresenterRegister{

    private IViewRegister view;
    private IModelRegister model;
    private EventBus eventBus;

    public PresenterRegister(IViewRegister activity) {
        this.view = activity;
        this.model = new ModelRegister();
        this.eventBus = EventBus.getDefault();
    }


    @Override
    public void onCreate(){
        eventBus.register(this);
    }

    @Override
    public void onStop() {
        eventBus.unregister(this);
    }

    @Override
    public void register(String username, String password) {
        model.register(username, password);
    }


    @Subscribe
    @Override
    public void onEventLoginThread(RegisterEvent event) {
        view.hideProgress();
        switch (event.getEventType()){
            case RegisterEvent.ON_REGISTER_SUCESS:
                view.toMenu();
                break;
            case  RegisterEvent.ON_REGISTER_ERROR:
                view.showError();
                view.clearForm();
                break;
        }
    }
}
