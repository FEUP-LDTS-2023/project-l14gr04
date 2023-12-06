package RushRoulette.Viewer.Game;

import RushRoulette.Model.Game.Elements.Coin;
import RushRoulette.gui.GUI;

public class CoinViewer implements ElementViewer<Coin> {
    @Override
    public void draw(Coin coin, GUI gui) {
        gui.drawCoin(coin.getPosition());
    }
}
