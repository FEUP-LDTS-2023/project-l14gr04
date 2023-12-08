package RushRoulette.controller.game;

import RushRoulette.Application;
import RushRoulette.Model.Game.Arena.Arena;
import RushRoulette.Model.Position;
import RushRoulette.controller.Music.MusicPlayer;
import RushRoulette.controller.Music.Sounds;
import RushRoulette.gui.GUI;

public class PlayerController extends GameController {
    public PlayerController(Arena arena){super(arena);}
    public void movePlayerLeft(){movePlayer(getModel().getPlayer().getPosition().getLeft());}
    public void movePlayerRight(){movePlayer(getModel().getPlayer().getPosition().getRight());}
    public void movePlayerUp(){movePlayer(getModel().getPlayer().getPosition().getUp());}
    public void movePlayerDown(){movePlayer(getModel().getPlayer().getPosition().getDown());}

    public void movePlayer(Position position){
        if(getModel().isEmpty(position)){
            getModel().getPlayer().setPosition(position);
            if(getModel().isEnemy(position)){
                MusicPlayer.getInstance().start(Sounds.HIT);
                getModel().getPlayer().isHit();
                if(getModel().getPlayer().getLives() == 0) getModel().getPlayer().isDead();
            }
            if(getModel().isCoin(position)){getModel().getPlayer().coinConsumed();}
        }
    }
    @Override
    public void step(Application application, GUI.ACTION action, long time){
        if(action== GUI.ACTION.UP)movePlayerUp();
        if(action== GUI.ACTION.RIGHT)movePlayerRight();
        if(action== GUI.ACTION.LEFT)movePlayerLeft();
        if(action== GUI.ACTION.DOWN)movePlayerDown();
    }
}
