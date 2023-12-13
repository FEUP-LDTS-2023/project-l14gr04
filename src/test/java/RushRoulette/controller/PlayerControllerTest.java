package RushRoulette.controller;

import RushRoulette.Model.Game.Arena.Arena;
import RushRoulette.Model.Game.Elements.Coin;
import RushRoulette.Model.Game.Elements.Player;
import RushRoulette.Model.Game.Elements.Wall;
import RushRoulette.Model.Game.GameTimer;
import RushRoulette.Model.Position;
import RushRoulette.controller.game.PlayerController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerControllerTest {
    private PlayerController controller;
    private Player player;
    private Arena arena;

    @BeforeEach
    void setUp(){
        arena = new Arena(40,20);
        player = new Player(3,3);

        arena.setPlayer(player);
        arena.setWalls(Arrays.asList());
        arena.setEnemies(Arrays.asList());
        arena.setPowerUps(Arrays.asList());
        arena.setCoins(Arrays.asList());
        arena.setGameTimer(new GameTimer());
        arena.getPlayer().resetPowerUps();

        controller = new PlayerController(arena);
    }

    @Test
    void  movePlayerRightEmpty() {
        controller.movePlayerRight();
        assertEquals(new Position(4,3),player.getPosition());
    }
    @Test
    void  movePlayerLeftEmpty() {
        controller.movePlayerLeft();
        assertEquals(new Position(2,3),player.getPosition());
    }
    @Test
    void  movePlayerUpEmpty() {
        controller.movePlayerUp();
        assertEquals(new Position(3,2),player.getPosition());
    }@Test
    void  movePlayerDownEmpty() {
        controller.movePlayerDown();
        assertEquals(new Position(3,4),player.getPosition());
    }

    @Test
    void  movePlayerRightWall() {
        arena.setWalls(Arrays.asList(new Wall(4,3 )));
        controller.movePlayerRight();
        assertEquals(new Position(3,3),player.getPosition());
    }
    @Test
    void  movePlayerLeftWall() {
        arena.setWalls(Arrays.asList(new Wall(2, 3)));
        controller.movePlayerLeft();
        assertEquals(new Position(3,3),player.getPosition());
    }
    @Test
    void  movePlayerUpWall() {
        arena.setWalls(Arrays.asList(new Wall(3, 2)));
        controller.movePlayerUp();
        assertEquals(new Position(3,3),player.getPosition());
    }@Test
    void  movePlayerDownWall() {
        arena.setWalls(Arrays.asList(new Wall(3, 4)));
        controller.movePlayerDown();
        assertEquals(new Position(3,3),player.getPosition());
    }

    @Test
    void  movePlayerRightCoin() {
        List<Coin> coins = new ArrayList<>();
        coins.add(new Coin(4, 3));
        arena.setCoins(coins);
        int previousScore=arena.getPlayer().getScore();
        controller.movePlayerRight();
        assertEquals(new Position(4,3),player.getPosition());
        assertEquals(arena.getPlayer().getScore(),previousScore+2);
    }
    @Test
    void  movePlayerLeftCoin() {
        List<Coin> coins = new ArrayList<>();
        coins.add(new Coin(2, 3));
        arena.setCoins(coins);
        int previousScore= arena.getPlayer().getScore();
        arena.getPlayer().setPontuationSystem(1);
        controller.movePlayerLeft();
        assertEquals(new Position(2,3),player.getPosition());
        assertEquals(arena.getPlayer().getScore(),previousScore+1);
    }
    @Test
    void  movePlayerUpCoin() {
        List<Coin> coins = new ArrayList<>();
        coins.add(new Coin(3, 2));
        arena.setCoins(coins);
        int previousScore= arena.getPlayer().getScore();
        arena.getPlayer().setPontuationSystem(2);
        controller.movePlayerUp();
        assertEquals(new Position(3,2),player.getPosition());
        assertEquals(arena.getPlayer().getScore(),previousScore+4);
    }
    @Test
    void  movePlayerDownCoin() {
        List<Coin> coins = new ArrayList<>();
        coins.add(new Coin(3, 4));
        arena.setCoins(coins);        int previousScore= arena.getPlayer().getScore();
        controller.movePlayerDown();
        assertEquals(new Position(3,4),player.getPosition());
        assertEquals(arena.getPlayer().getScore(),previousScore+2);
    }
}
