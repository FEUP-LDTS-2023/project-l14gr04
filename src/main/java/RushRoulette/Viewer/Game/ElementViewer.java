package RushRoulette.Viewer.Game;

import RushRoulette.Model.Game.Elements.Element;
import RushRoulette.gui.GUI;

public interface ElementViewer <T extends Element> {
    void draw(T element, GUI gui);
}
