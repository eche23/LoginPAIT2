package com.ulpgc.pait.loginpait.register.model;

public class ModelRegister implements IModelRegister{

    private IRepositoryRegister repository;

    public ModelRegister() {
        repository = new RepositoryRegister();
    }

    @Override
    public void register(String username, String password) {
        repository.register(username, password);
    }
}
