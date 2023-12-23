package Projeto.States;


import Projeto.Application;
import Projeto.Viewer.Viewer;
import Projeto.controller.Controller;
import Projeto.gui.GUI;


import java.io.IOException;

public abstract class State<T> {
    private final T model;
    private final Controller<T> controller;
    private final Viewer<T> viewer;

    public State(T model) {
        this.model = model;
        this.viewer = getViewer();
        this.controller = getController();
    }

    protected abstract Viewer<T> getViewer();

    protected abstract Controller<T> getController();

    public T getModel() {
        return model;
    }

    public void step(Application application, GUI gui, long time) throws IOException {
        GUI.ACTION action = gui.getNextAction();
        controller.step(application, action, time);
        viewer.draw(gui);
    }
}
