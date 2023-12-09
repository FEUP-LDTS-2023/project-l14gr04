package RushRoulette.Viewer.Menu;

import RushRoulette.Model.Menu.Menu;
import RushRoulette.Model.Position;
import RushRoulette.Viewer.Viewer;
import RushRoulette.gui.GUI;

public class MenuViewer extends Viewer<Menu> {
    public MenuViewer(Menu menu){super(menu);}
    @Override
    public void drawElements(GUI gui){

        gui.drawText(new Position(0,0), "==============  M E N U  ===============","#8B0000" );
        gui.drawText(new Position(0,1), "||                                    ||","#8B0000" );
        gui.drawText(new Position(0,2), "||                                    ||","#8B0000" );
        gui.drawText(new Position(0,3), "||                                    ||","#8B0000" );
        gui.drawText(new Position(0,4), "||                                    ||","#8B0000" );
        gui.drawText(new Position(0,5), "||                                    ||","#8B0000" );
        gui.drawText(new Position(0,6), "||                                    ||","#8B0000" );
        gui.drawText(new Position(0,7), "||                                    ||","#8B0000" );
        gui.drawText(new Position(0,8), "||                                    ||","#8B0000" );
        gui.drawText(new Position(0,9), "||                                    ||","#8B0000" );
        gui.drawText(new Position(0,10), "||                                    ||","#8B0000" );
        gui.drawText(new Position(0,11), "||                                    ||","#8B0000" );
        gui.drawText(new Position(0,12), "||                                    ||","#8B0000" );
        gui.drawText(new Position(0,13), "||                                    ||","#8B0000" );
        gui.drawText(new Position(0,14), "||                                    ||","#8B0000" );
        gui.drawText(new Position(0,15), "||                                    ||","#8B0000" );
        gui.drawText(new Position(0,16), "||                                    ||","#8B0000" );
        gui.drawText(new Position(0,17), "||                                    ||","#8B0000" );
        gui.drawText(new Position(0,18), "||                                    ||","#8B0000");
        gui.drawText(new Position(0,19), "||                                    ||","#8B0000" );
        gui.drawText(new Position(0,20), "=========================================","#8B0000");

        gui.drawText(new Position(8,5), "WELCOME TO RUSH-ROULETTE!!", "#8B0000" );

        gui.drawText(new Position(17,9), ">" + getModel().getEntry(0),  getModel().isSelected(0)? "#FFD700" : "#8B0000" );
        gui.drawText(new Position(13,10),">" + getModel().getEntry(1),  getModel().isSelected(1)? "#FFD700" : "#8B0000" );
        gui.drawText(new Position(17,11),">" + getModel().getEntry(2),  getModel().isSelected(2)? "#FFD700" : "#8B0000" );

    }
}
