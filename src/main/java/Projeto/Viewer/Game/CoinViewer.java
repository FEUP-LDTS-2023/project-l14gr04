package Projeto.Viewer.Game;

import Projeto.Model.Game.Elements.Coin;
import Projeto.gui.GUI;

public class CoinViewer implements ElementViewer<Coin> {
    @Override
    public void draw(Coin coin, GUI gui) {
        gui.drawCoin(coin.getPosition());
    }
}
