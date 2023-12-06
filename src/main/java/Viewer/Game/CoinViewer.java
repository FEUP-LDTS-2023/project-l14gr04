package Viewer.Game;

import Model.Game.Elements.Coin;
import gui.GUI;

public class CoinViewer implements ElementViewer<Coin> {
    @Override
    public void draw(Coin coin, GUI gui) {
        gui.drawCoin(coin.getPosition());
    }
}
