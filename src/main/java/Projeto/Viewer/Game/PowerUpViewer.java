package Projeto.Viewer.Game;

import Projeto.Model.Game.Elements.PowerUp;
import Projeto.gui.GUI;

public class PowerUpViewer implements ElementViewer<PowerUp> {
    @Override
    public void draw(PowerUp powerUp, GUI gui) {
            gui.drawPowerUp(powerUp.getPosition());
    }
}
