package Projeto.controller.game;

import Projeto.Application;
import Projeto.Model.Game.Arena.Arena;
import Projeto.Model.Position;
import Projeto.gui.GUI;

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
                if(getModel().getPlayer().getInvulnerability()==0) {
                    getModel().getPlayer().isHit();
                    if (getModel().getPlayer().getLives() == 0) getModel().getPlayer().isDead();
                }
            }
            if(getModel().getPlayer().getPowerUpTimer().getCurrentTime()==0) {
                getModel().getPlayer().setPontuationSystem(0);
                getModel().getPlayer().setInvulnerability(0);
            }

                if (getModel().isCoin(position)) {
                    int type=getModel().getPlayer().getPointsSystem();
                    switch(type){
                        case 0:
                            getModel().getPlayer().coinConsumed();
                            break;
                        case 1:
                            getModel().getPlayer().HalfCoinConsumed();
                            break;
                        case 2:
                            getModel().getPlayer().DoubleCoinConsumed();
                            break;
                    }
                    /*if (getModel().getPlayer().getPointsSystem()==0)
                    {getModel().getPlayer().coinConsumed();
                    } else if(getModel().getPlayer().getPointsSystem()==1) {
                        getModel().getPlayer().HalfCoinConsumed();
                    } else if (getModel().getPlayer().getPointsSystem()==2) {
                        getModel().getPlayer().DoubleCoinConsumed();
                    }*/
                }


            if(getModel().isPowerUp(position)){
                getModel().getArenaController().handlePlayerPowerUpCollision();
                if(getModel().getPlayer().getLives() == 0) getModel().getPlayer().isDead();
            }
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
