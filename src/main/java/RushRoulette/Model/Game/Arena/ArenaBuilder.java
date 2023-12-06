package RushRoulette.Model.Game.Arena;

import RushRoulette.Model.Game.Elements.Wall;

import java.util.List;

public abstract class ArenaBuilder {
    public Arena createArena(){
        Arena arena = new Arena(getWidth(), getHeight());

        /*
        adicionar set player, enemies e powerups
         */
        arena.setWalls(createWalls());
        return arena;
    }
    protected abstract int getWidth();
    protected abstract int getHeight();
    protected abstract List<Wall> createWalls();
}
