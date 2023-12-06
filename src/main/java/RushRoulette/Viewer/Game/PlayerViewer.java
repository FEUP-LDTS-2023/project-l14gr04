package RushRoulette.Viewer.Game;

import RushRoulette.Model.Game.Elements.Player;
import RushRoulette.gui.GUI;

public class PlayerViewer implements ElementViewer<Player> {
    @Override
    public void draw(Player player, GUI gui) {
        gui.drawPlayer(player.getPosition());
    }
}
