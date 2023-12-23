package Projeto.States;

import Projeto.Model.Game.Arena.Arena;
import Projeto.Viewer.Game.ArenaViewer;
import Projeto.Viewer.Viewer;
import Projeto.controller.Controller;
import Projeto.controller.game.ArenaController;

public class GameState extends State<Arena> {
    public GameState(Arena arena) {
        super(arena);
    }

    @Override
    public Viewer<Arena> getViewer() {
        return new ArenaViewer(getModel());
    }

    @Override
    public Controller<Arena> getController() {
        return new ArenaController(getModel());
    }
}
