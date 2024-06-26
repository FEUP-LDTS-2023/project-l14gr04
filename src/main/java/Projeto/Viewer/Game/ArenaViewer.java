package Projeto.Viewer.Game;

import Projeto.Model.Game.Arena.Arena;
import Projeto.Model.Game.Elements.Element;
import Projeto.Model.Position;
import Projeto.Viewer.Viewer;
import Projeto.gui.GUI;

import java.util.List;

public class ArenaViewer extends Viewer<Arena> {
    public String type=new String();
    public ArenaViewer(Arena arena) {
        super(arena);
    }

    public String getType(){
        if (getModel().getPlayer().getPointsSystem()==1){
            type="Half Points";
        } else if (getModel().getPlayer().getPointsSystem()==2) {
            type="Double Points";
        } else if (getModel().getPlayer().getInvulnerability()==1) {
            type="Invulnerability";
        } else if (getModel().getPlayer().getInvulnerability()==0||getModel().getPlayer().getPointsSystem()==0) {
            type=new String();
        }
        return type;
    }

    @Override
    protected void drawElements(GUI gui) {
        drawListElements(gui, getModel().getWalls(), new WallViewer());
        drawListElements(gui, getModel().getEnemies(), new EnemyViewer());
        drawListElements(gui,getModel().getCoins(),new CoinViewer());
        drawListElements(gui, getModel().getPowerUps(),new PowerUpViewer());

        drawElement(gui, getModel().getPlayer(), new PlayerViewer());

        gui.drawText(new Position(0, 0), "Score: " + getModel().getPlayer().getScore() , "#FFD700");

        gui.drawText(new Position(11, 0), "HP:" + (getModel().getPlayer().getLives()) , "#FF0000");

        gui.drawText(new Position(32,0),"Timer:" + getModel().getGameTimer().getCurrentTime(), "#FFD700");

        if(getModel().getArenaController().getLevel() < 10){
            gui.drawText(new Position(14,20),"Level:0"+ getModel().getArenaController().getLevel()+"/30", "#FFD700");
        }
        else {
            gui.drawText(new Position(14,20),"Level:"+ getModel().getArenaController().getLevel()+"/30", "#FFD700");
        }

        gui.drawText(new Position(16,0),getType(),"#3EE3BF");

    }

    private <T extends Element> void drawListElements(GUI gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }

}
