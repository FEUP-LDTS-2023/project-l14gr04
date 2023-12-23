package Projeto.controller;

import Projeto.Model.Game.Arena.Arena;
import Projeto.Model.Game.Arena.LoaderArenaBuilder;
import Projeto.controller.game.PlayerController;
import Projeto.gui.GUI;
import net.jqwik.api.*;
import net.jqwik.api.constraints.IntRange;

import java.io.IOException;
import java.util.List;

public class NoExitTest {


    @Property
    void allArenasAreClosed(@ForAll @IntRange(min = 1, max = 30) int level,  @ForAll List<GUI.@From("moveActions") ACTION> actions) throws IOException {
        LoaderArenaBuilder rab = new LoaderArenaBuilder(level);
        Arena arena = rab.createArena();
        PlayerController controller = new PlayerController(arena);

        for (GUI.ACTION action : actions) {
            controller.step(null, action, 100);
            if (!(controller.getModel().getPlayer().getPosition().getX() > 0
                    && controller.getModel().getPlayer().getPosition().getY() > 0
                    && controller.getModel().getPlayer().getPosition().getX() < arena.getWidth() - 1
                    && controller.getModel().getPlayer().getPosition().getY() < arena.getHeight() - 1)) {
                throw new AssertionError("Invalid position");
            }
        }
    }

    @Provide
    Arbitrary<GUI.ACTION> moveActions() {
        return Arbitraries.of(GUI.ACTION.UP, GUI.ACTION.RIGHT, GUI.ACTION.DOWN, GUI.ACTION.LEFT);
    }
}