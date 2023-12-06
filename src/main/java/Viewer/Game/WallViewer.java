package Viewer.Game;

import Model.Game.Elements.Wall;
import gui.GUI;

public class WallViewer implements ElementViewer<Wall> {
    @Override
    public void draw(Wall wall, GUI gui) {
        gui.drawWall(wall.getPosition());
    }
}
