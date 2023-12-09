package RushRoulette.States;

import RushRoulette.Model.Menu.Instructions;
import RushRoulette.Viewer.Menu.InstructionsViewer;
import RushRoulette.Viewer.Viewer;
import RushRoulette.controller.Controller;
import RushRoulette.controller.menu.InstructionsController;

public class InstructionsState extends State<Instructions> {
    public InstructionsState(Instructions instructions) {
        super(instructions);
    }

    @Override
    protected Viewer<Instructions> getViewer() {
        return new InstructionsViewer(getModel());
    }

    @Override
    protected Controller<Instructions> getController() {
        return new InstructionsController(getModel());
    }
}