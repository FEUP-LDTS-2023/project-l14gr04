package Projeto.controller.game;

import Projeto.Model.Game.Arena.Arena;
import Projeto.controller.Controller;

public abstract class GameController extends Controller<Arena> {
    public GameController(Arena arena){super(arena);}
}
