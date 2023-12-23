package Projeto.Viewer.Game;

import Projeto.Model.Game.Elements.Enemy;
import Projeto.gui.GUI;

public class EnemyViewer implements ElementViewer<Enemy> {
    @Override
    public void draw(Enemy enemy, GUI gui) {
        gui.drawEnemy(enemy.getPosition());
    }

}
