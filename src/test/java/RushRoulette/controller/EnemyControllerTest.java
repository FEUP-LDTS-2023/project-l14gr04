package RushRoulette.controller;

import RushRoulette.Application;
import RushRoulette.Model.Game.Arena.Arena;
import RushRoulette.Model.Game.Elements.Enemy;
import RushRoulette.Model.Game.Elements.Player;
import RushRoulette.Model.Game.Elements.Wall;
import RushRoulette.Model.Position;
import RushRoulette.controller.game.EnemyController;
import RushRoulette.gui.GUI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class EnemyControllerTest {
    private EnemyController controller;
    private Player player;
    private Arena arena;
    private Application application;

    @BeforeEach
    void setUp() {
        arena = new Arena(10, 10);

        player = new Player(5, 5);
        arena.setPlayer(player);

        arena.setWalls(Arrays.asList());
        arena.setEnemies(Arrays.asList());

        controller = new EnemyController(arena);

        application = Mockito.mock(Application.class);
    }

    @Test
    void moveMonsters() throws IOException {
        Enemy enemy = new Enemy(5, 5);
        arena.setEnemies(Arrays.asList(enemy));

        controller.step(application, GUI.ACTION.NONE, 1000);

        assertNotEquals(new Position(5, 5), enemy.getPosition());
    }

    @Test
    void moveMonstersClosed() throws IOException {
        Enemy enemy = new Enemy(5, 5);
        arena.setEnemies(Arrays.asList(enemy));
        arena.setWalls(Arrays.asList(
                new Wall(4, 5),
                new Wall(6, 5),
                new Wall(5, 4),
                new Wall(5, 6)
        ));

        for (int i = 0; i < 10; i++)
            controller.step(application, GUI.ACTION.NONE, 1000);

        assertEquals(new Position(5, 5), enemy.getPosition());
    }

    @Test
    void moveMonstersGap() throws IOException {
        Enemy enemy = new Enemy(5, 5);
        arena.setEnemies(Arrays.asList(enemy));
        arena.setWalls(Arrays.asList(
                new Wall(4, 5),
                new Wall(6, 5),
                new Wall(5, 4)
        ));

        long time = 0;

        while (enemy.getPosition().equals(new Position(5, 5))) {
            time += 500;
            controller.step(application, GUI.ACTION.NONE, time);
        }

        assertEquals(new Position(5, 6), enemy.getPosition());
    }
}

