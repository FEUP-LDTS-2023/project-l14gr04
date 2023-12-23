package Projeto.States;

import Projeto.Model.Menu.Instructions;
import Projeto.Viewer.Menu.InstructionsViewer;
import Projeto.Viewer.Viewer;
import Projeto.controller.Controller;
import Projeto.controller.menu.InstructionsController;

public class InstructionsState extends State<Instructions> {
    public InstructionsState(Instructions instructions) {
        super(instructions);
    }

    @Override
    public Viewer<Instructions> getViewer() {
        return new InstructionsViewer(getModel());
    }

    @Override
    public Controller<Instructions> getController() {
        return new InstructionsController(getModel());
    }
}