package Viewer.Game;

import Model.Game.Elements.PowerUp;
import gui.GUI;

public class PowerUpViewer implements ElementViewer<PowerUp> {
    @Override
    public void draw(PowerUp powerUp, GUI gui) {
            gui.drawPowerUp(powerUp.getPosition());
    }
}
