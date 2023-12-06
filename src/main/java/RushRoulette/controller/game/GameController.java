package RushRoulette.controller.game;

import RushRoulette.Model.Game.Arena.Arena;
import RushRoulette.controller.Controller;

public abstract class GameController extends Controller<Arena> {
    public GameController(Arena arena){super(arena);}
}
