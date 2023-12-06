package RushRoulette.Viewer.Game;

import RushRoulette.Model.Game.Elements.PowerUp;
import RushRoulette.gui.GUI;

public class PowerUpViewer implements ElementViewer<PowerUp> {
    @Override
    public void draw(PowerUp powerUp, GUI gui) {
            gui.drawPowerUp(powerUp.getPosition());
    }
}
