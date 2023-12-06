package Viewer.Game;

import Model.Game.Elements.Element;
import gui.GUI;

public interface ElementViewer <T extends Element> {
    void draw(T element, GUI gui);
}
