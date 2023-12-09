package RushRoulette.Viewer.Menu;

import RushRoulette.Model.Menu.Instructions;
import RushRoulette.Model.Position;
import RushRoulette.Viewer.Viewer;
import RushRoulette.gui.GUI;

public class InstructionsViewer extends Viewer<Instructions> {

    public InstructionsViewer(Instructions instructionsScreen){
        super(instructionsScreen);
    }
    @Override
    protected void drawElements(GUI gui) {
        gui.drawText(new Position(0,0), "======= I N S T R U C T I O N S ========","#0022CC" );
        gui.drawText(new Position(0,1), "||                                    ||","#0022CC");
        gui.drawText(new Position(0,2), "||             OBJECTIVE :            ||","#0022CC" );
        gui.drawText(new Position(0,3), "|| >Survive for as long as you can    ||","#0022CC" );
        gui.drawText(new Position(0,4), "|| >Collect coins for a higher score  ||","#0022CC" );
        gui.drawText(new Position(0,5), "|| >Power-ups are random and they can ||","#0022CC" );
        gui.drawText(new Position(0,6), "|| either help or doom you!           ||","#0022CC" );
        gui.drawText(new Position(0,7), "|| >Dont let the enemies catch you!   ||","#0022CC" );
        gui.drawText(new Position(0,8), "||                                    ||","#0022CC" );
        gui.drawText(new Position(0,9), "||      ---IN GAME CONTROLS---        ||","#0022CC" );
        gui.drawText(new Position(0,10), "||                                    ||","#0022CC" );
        gui.drawText(new Position(0,11), "||       MENU  -->    Q               ||","#0022CC" );
        gui.drawText(new Position(0,12), "||                                    ||","#0022CC" );
        gui.drawText(new Position(0,13), "||        UP   --> ARROW_UP           ||","#0022CC" );
        gui.drawText(new Position(0,14), "||       DOWN  --> ARROW_DOWN         ||","#0022CC" );
        gui.drawText(new Position(0,15), "||       LEFT  --> ARROW_LEFT         ||","#0022CC" );
        gui.drawText(new Position(0,16), "||       RIGHT --> ARROW_RIGHT        ||","#0022CC" );
        gui.drawText(new Position(0,17), "||       DASH  --> ARROW_HOLD         ||","#0022CC" );

        gui.drawText(new Position(0,18), "||                                    ||","#0022CC" );


        gui.drawText(new Position(0,19), "||                                    ||","#0022CC" );
        gui.drawText(new Position(3,19),getModel().getEntry(), "#FFD700");

        gui.drawText(new Position(0,20), "=========================================","#0022CC" );





    }
}
