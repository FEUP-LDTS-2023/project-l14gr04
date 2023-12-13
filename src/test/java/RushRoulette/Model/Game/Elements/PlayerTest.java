package RushRoulette.Model.Game.Elements;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    Player player;

    @BeforeEach
    void setUp(){
        player= new Player(3,3);
    }

    @Test
    void resetLivesTest(){
        player.addLife();
        player.resetLives();
        Assertions.assertEquals(player.getLives(),3);
    }

    @Test
    void resetScore(){
        player.coinConsumed();
        player.resetScore();
        Assertions.assertEquals(player.getScore(),0);
    }

    @Test
    void deadTest(){
        player.isDead();
        Assertions.assertEquals(player.getDead(),1);
    }

    @Test
    void aliveTest(){
        player.resetLives();
        Assertions.assertEquals(player.getDead(),0);
    }

    @Test
    void levelPointsTest(){
        player.resetScore();
        player.levelPoints();
        Assertions.assertEquals(player.getScore(),10);
    }

    @Test
    void  invulnerabilityTest(){
        player.resetPowerUps();
        player.invulnerable();
        Assertions.assertEquals(player.getInvulnerability(),1);
    }

    @Test
    void setInvulnerability(){
        player.setInvulnerability(0);
        Assertions.assertEquals(player.getInvulnerability(),0);
        player.setInvulnerability(1);
        Assertions.assertEquals(player.getInvulnerability(),1);

    }
}
