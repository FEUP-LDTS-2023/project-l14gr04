package RushRoulette.Viewer.Menu;

import RushRoulette.Model.Menu.Menu;
import RushRoulette.Model.Position;
import RushRoulette.Viewer.Viewer;
import RushRoulette.gui.GUI;

public class MenuViewer extends Viewer<Menu> {
    public MenuViewer(Menu menu){super(menu);}
    @Override
    public void drawElements(GUI gui){
        gui.drawText(new Position(12,5), "RUSH ROULETTE!", "#FFFFFF" );
        gui.drawText(new Position(12,7), "-----Menu-----", "#FFFFFF" );

        gui.drawText(new Position(17,9), getModel().getEntry(0),  getModel().isSelected(0)? "#FFD700" : "#FFFFFF" );
        gui.drawText(new Position(13,10), getModel().getEntry(1),  getModel().isSelected(1)? "#FFD700" : "#FFFFFF" );
        gui.drawText(new Position(17,11), getModel().getEntry(2),  getModel().isSelected(2)? "#FFD700" : "#FFFFFF" );

    }
}
