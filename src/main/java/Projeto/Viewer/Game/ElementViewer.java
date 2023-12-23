package Projeto.Viewer.Game;

import Projeto.Model.Game.Elements.Element;
import Projeto.gui.GUI;

public interface ElementViewer <T extends Element> {
    void draw(T element, GUI gui);
}
