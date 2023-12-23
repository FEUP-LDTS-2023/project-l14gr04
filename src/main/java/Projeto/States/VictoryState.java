package Projeto.States;


import Projeto.Model.PopUpScreens.Victory;
import Projeto.Viewer.PopUpScreens.VictoryViewer;
import Projeto.Viewer.Viewer;
import Projeto.controller.Controller;
import Projeto.controller.PopUpScreens.VictoryController;


public class VictoryState extends State<Victory> {
    public VictoryState(Victory model) {
        super(model);
    }

    @Override
    public Viewer<Victory> getViewer() {
        return new VictoryViewer(getModel());
    }

    @Override
    public Controller<Victory> getController() {
        return new VictoryController(getModel());
    }
}