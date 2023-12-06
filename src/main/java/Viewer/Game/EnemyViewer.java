package Viewer.Game;

import Model.Game.Elements.Enemy;
import Model.Position;
import gui.GUI;

public class EnemyViewer implements ElementViewer<Enemy> {
    @Override
    public void draw(Enemy enemy, GUI gui) {
        gui.drawEnemy(enemy.getPosition());
    }

}
