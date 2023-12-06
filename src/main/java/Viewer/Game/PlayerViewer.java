package Viewer.Game;

import Model.Game.Elements.Player;
import gui.GUI;

public class PlayerViewer implements ElementViewer<Player> {
    @Override
    public void draw(Player player, GUI gui) {
        gui.drawPlayer(player.getPosition());
    }
}
