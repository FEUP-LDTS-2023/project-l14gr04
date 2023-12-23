package Projeto.Viewer.Game;

import Projeto.Model.Game.Elements.Player;
import Projeto.gui.GUI;

public class PlayerViewer implements ElementViewer<Player> {
    @Override
    public void draw(Player player, GUI gui) {
        gui.drawPlayer(player.getPosition());
    }
}
