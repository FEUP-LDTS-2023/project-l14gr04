package RushRoulette.Viewer.Game;

import RushRoulette.Model.Game.Elements.Enemy;
import RushRoulette.gui.GUI;

public class EnemyViewer implements ElementViewer<Enemy> {
    @Override
    public void draw(Enemy enemy, GUI gui) {
        gui.drawEnemy(enemy.getPosition());
    }

}
