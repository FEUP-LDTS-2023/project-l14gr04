package RushRoulette.Viewer.Game;

import RushRoulette.Model.Game.Elements.Wall;
import RushRoulette.gui.GUI;

public class WallViewer implements ElementViewer<Wall> {
    @Override
    public void draw(Wall wall, GUI gui) {
        gui.drawWall(wall.getPosition());
    }
}
