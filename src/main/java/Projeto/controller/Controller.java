package Projeto.controller;

import Projeto.Application;
import Projeto.gui.GUI;

import java.io.IOException;

public abstract class Controller<T> {
    private  T model;
    public Controller(T model){this.model=model;}
    public T getModel(){return model;}
    public abstract void step(Application application, GUI.ACTION action, long time) throws IOException;
    public void setModel(T model) {
        this.model = model;
    }
}
