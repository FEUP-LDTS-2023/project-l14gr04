package Projeto.Viewer.Game;

import Projeto.Model.Game.Elements.Wall;
import Projeto.gui.GUI;

public class WallViewer implements ElementViewer<Wall> {
    @Override
    public void draw(Wall wall, GUI gui) {
        gui.drawWall(wall.getPosition());
    }
}
