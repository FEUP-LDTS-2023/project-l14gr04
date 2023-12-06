package RushRoulette.controller;

import RushRoulette.Application;
import RushRoulette.gui.GUI;

import java.io.IOException;

public abstract class Controller<T> {
    private final T model;
    public Controller(T model){this.model=model;}
    public T getModel(){return model;}
    public abstract void step(Application application, GUI.ACTION action, long time) throws IOException;
}
