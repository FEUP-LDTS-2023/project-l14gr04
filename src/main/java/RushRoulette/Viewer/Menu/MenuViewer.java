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

        for(int i=0; i<getModel().getNumberEntries();i++){
            gui.drawText(
                    new Position(17, 9+i),
                    getModel().getEntry(i),
                    getModel().isSelected(i)? "#FFD700" : "#FFFFFF");
        }
    }
}
