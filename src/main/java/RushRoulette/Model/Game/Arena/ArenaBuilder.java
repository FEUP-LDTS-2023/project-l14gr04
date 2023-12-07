package RushRoulette.Model.Game.Arena;

import RushRoulette.Model.Game.Elements.*;
import RushRoulette.Model.Game.GameTimer;
import RushRoulette.Model.Position;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public abstract class ArenaBuilder {

    public Arena createArena() throws IOException {
        Arena arena = new Arena(getWidth(), getHeight());

        arena.setPlayer(createPlayer());
        arena.setEnemies(createEnemies());
        arena.setWalls(createWalls());
        arena.setCoins(createCoins());
        arena.setPowerUps(createPowerUps());

        GameTimer gameTimer = new GameTimer(); // 10 seconds, adjust as needed
        arena.setGameTimer(gameTimer);

        return arena;
    }

    protected abstract List<PowerUp> createPowerUps();

    protected abstract List<Coin> createCoins();

    protected abstract List<Enemy> createEnemies();

    protected abstract Player createPlayer();

    protected abstract int getWidth();

    protected abstract int getHeight();

    protected abstract List<Wall> createWalls();


}