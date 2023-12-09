package RushRoulette.States;


import RushRoulette.Model.PopUpScreens.Victory;
import RushRoulette.Viewer.PopUpScreens.VictoryViewer;
import RushRoulette.Viewer.Viewer;
import RushRoulette.controller.Controller;
import RushRoulette.controller.PopUpScreens.VictoryController;


public class VictoryState extends State<Victory> {
    public VictoryState(Victory model) {
        super(model);
    }

    @Override
    protected Viewer<Victory> getViewer() {
        return new VictoryViewer(getModel());
    }

    @Override
    protected Controller<Victory> getController() {
        return new VictoryController(getModel());
    }
}