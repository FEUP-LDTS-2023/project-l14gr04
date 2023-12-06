package RushRoulette.Viewer.Menu;

import RushRoulette.Model.Menu.Menu;
import RushRoulette.Model.Position;
import RushRoulette.Viewer.Viewer;
import RushRoulette.gui.GUI;

public class MenuViewer extends Viewer<Menu> {
    public MenuViewer(Menu menu){super(menu);}
    @Override
    public void drawElements(GUI gui){
        gui.drawText(new Position(5,5), "Menu", "#FFFFFF" );

        for(int i=0; i<getModel().getNumberEntries();i++){
            gui.drawText(
                    new Position(5, 7+i),
                    getModel().getEntry(i),
                    getModel().isSelected(i)? "#FFD700" : "#FFFFFF");
        }
    }
}