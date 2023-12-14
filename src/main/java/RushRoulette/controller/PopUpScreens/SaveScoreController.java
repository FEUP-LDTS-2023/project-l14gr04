package RushRoulette.controller.PopUpScreens;

import RushRoulette.Application;
import RushRoulette.Model.Menu.LeaderBoard;
import RushRoulette.Model.Menu.Menu;
import RushRoulette.Model.PopUpScreens.SaveScore;
import RushRoulette.States.LeaderBoardState;
import RushRoulette.States.MenuState;
import RushRoulette.States.SaveScoreState;
import RushRoulette.controller.Controller;
import RushRoulette.controller.menu.LeaderBoardEditor;
import RushRoulette.controller.Music.MusicPlayer;
import RushRoulette.controller.Music.Sounds;
import RushRoulette.gui.GUI;

import java.io.IOException;

public class SaveScoreController extends Controller<SaveScore> {
    public SaveScoreController(SaveScore saveScoreScreen) {
        super(saveScoreScreen);
    }

    @Override
    public void step(Application application, GUI.ACTION action, long time) throws IOException {

        switch (action) {
            case LEFT:
                getModel().previousEntry();
                MusicPlayer.getInstance().start(Sounds.SELECT);
                break;
            case RIGHT:
                getModel().nextEntry();
                MusicPlayer.getInstance().start(Sounds.SELECT);
                break;
            case DOWN:
                //to navigate through lines
                MusicPlayer.getInstance().start(Sounds.SELECT);

                if (getModel().menuSelected()) {
                    getModel().jumpCharDistance(2);
                }
                else if (getModel().nextSelected()) {
                    getModel().jumpCharDistance(1);
                }
                else if (getModel().qSelected()) {
                    getModel().jumpCharDistance(10);
                }
                else if (getModel().wSelected()) {
                    getModel().jumpCharDistance(10);

                }
                else if (getModel().eSelected()) {
                    getModel().jumpCharDistance(10);

                }
                else if (getModel().rSelected()) {
                    getModel().jumpCharDistance(10);

                }
                else if (getModel().tSelected()) {
                    getModel().jumpCharDistance(10);

                }
                else if (getModel().ySelected()) {
                    getModel().jumpCharDistance(10);

                }
                else if (getModel().uSelected()) {
                    getModel().jumpCharDistance(10);

                }
                else if (getModel().iSelected()) {
                    getModel().jumpCharDistance(10);

                }
                else if (getModel().oSelected()) {
                    getModel().jumpCharDistance(10);

                }
                else if (getModel().pSelected()) {
                    getModel().jumpCharDistance(9);

                }
                else if (getModel().aSelected()) {
                    getModel().jumpCharDistance(9);

                }
                else if (getModel().sSelected()) {
                    getModel().jumpCharDistance(9);
                }
                else if (getModel().dSelected()) {
                    getModel().jumpCharDistance(9);

                }
                else if (getModel().fSelected()) {
                    getModel().jumpCharDistance(9);

                }
                else if (getModel().gSelected()) {
                    getModel().jumpCharDistance(9);
                }
                else if (getModel().hSelected()) {
                    getModel().jumpCharDistance(9);

                }
                else if (getModel().jSelected()) {
                    getModel().jumpCharDistance(9);

                }
                else if (getModel().kSelected()) {
                    getModel().jumpCharDistance(8);

                }
                else if (getModel().lSelected()) {
                    getModel().jumpCharDistance(7);

                }
                else if (getModel().zSelected()) {
                    getModel().jumpCharDistance(0);

                }
                else if (getModel().xSelected()) {
                    getModel().jumpCharDistance(0);

                }
                else if (getModel().cSelected()) {
                    getModel().jumpCharDistance(0);

                }
                else if (getModel().vSelected()) {
                    getModel().jumpCharDistance(0);

                }
                else if (getModel().bSelected()) {
                    getModel().jumpCharDistance(0);

                }
                else if (getModel().nSelected()) {
                    getModel().jumpCharDistance(0);

                }
                else if (getModel().mSelected()) {
                    getModel().jumpCharDistance(0);

                }
                break;
            case UP:
                MusicPlayer.getInstance().start(Sounds.SELECT);

                if (getModel().menuSelected()) {
                    getModel().jumpCharDistance(0);
                }
                else if (getModel().nextSelected()) {
                    getModel().jumpCharDistance(0);
                }
                else if (getModel().qSelected()) {
                    getModel().jumpCharDistance(-2);
                }
                else if (getModel().wSelected()) {
                    getModel().jumpCharDistance(-3);

                }
                else if (getModel().eSelected()) {
                    getModel().jumpCharDistance(-4);

                }
                else if (getModel().rSelected()) {
                    getModel().jumpCharDistance(-5);

                }
                else if (getModel().tSelected()) {
                    getModel().jumpCharDistance(-6);

                }
                else if (getModel().ySelected()) {
                    getModel().jumpCharDistance(-7);

                }
                else if (getModel().uSelected()) {
                    getModel().jumpCharDistance(-8);

                }
                else if (getModel().iSelected()) {
                    getModel().jumpCharDistance(-9);

                }
                else if (getModel().oSelected()) {
                    getModel().jumpCharDistance(-10);

                }
                else if (getModel().pSelected()) {
                    getModel().jumpCharDistance(-11);

                }
                else if (getModel().aSelected()) {
                    getModel().jumpCharDistance(-10);

                }
                else if (getModel().sSelected()) {
                    getModel().jumpCharDistance(-10);
                }
                else if (getModel().dSelected()) {
                    getModel().jumpCharDistance(-10);

                }
                else if (getModel().fSelected()) {
                    getModel().jumpCharDistance(-10);

                }
                else if (getModel().gSelected()) {
                    getModel().jumpCharDistance(-10);
                }
                else if (getModel().hSelected()) {
                    getModel().jumpCharDistance(-10);

                }
                else if (getModel().jSelected()) {
                    getModel().jumpCharDistance(-10);

                }
                else if (getModel().kSelected()) {
                    getModel().jumpCharDistance(-10);

                }
                else if (getModel().lSelected()) {
                    getModel().jumpCharDistance(-10);

                }
                else if (getModel().zSelected()) {
                    getModel().jumpCharDistance(-9);

                }
                else if (getModel().xSelected()) {
                    getModel().jumpCharDistance(-9);

                }
                else if (getModel().cSelected()) {
                    getModel().jumpCharDistance(-9);

                }
                else if (getModel().vSelected()) {
                    getModel().jumpCharDistance(-9);

                }
                else if (getModel().bSelected()) {
                    getModel().jumpCharDistance(-9);

                }
                else if (getModel().nSelected()) {
                    getModel().jumpCharDistance(-9);

                }
                else if (getModel().mSelected()) {
                    getModel().jumpCharDistance(-9);

                }
                break;

            case SELECT:
                if (getModel().menuSelected()) {
                    MusicPlayer.getInstance().stopAll();
                    MusicPlayer.getInstance().start(Sounds.MENU_SOUNDTRACK);
                    getModel().resetNickName();
                    application.setState(new MenuState(new Menu()));
                }
                else if (getModel().nextSelected()) {
                    //edit file
                    LeaderBoardEditor LBE = new LeaderBoardEditor(getModel().getScore(), getModel().getNickname());
                    LBE.modifyLeaderBoard();
                    getModel().resetNickName();
                    //go to leaderboard
                    application.setState(new LeaderBoardState(new LeaderBoard()));

                }
                else if (getModel().qSelected()) {
                    getModel().addKey("q");
                    application.setState(new SaveScoreState(new SaveScore(getModel().getScore())));

                }
                else if (getModel().wSelected()) {
                    getModel().addKey("w");
                    application.setState(new SaveScoreState(new SaveScore(getModel().getScore())));

                }
                else if (getModel().eSelected()) {
                    getModel().addKey("e");
                    application.setState(new SaveScoreState(new SaveScore(getModel().getScore())));

                }
                else if (getModel().rSelected()) {
                    getModel().addKey("r");
                    application.setState(new SaveScoreState(new SaveScore(getModel().getScore())));

                }
                else if (getModel().tSelected()) {
                    getModel().addKey("t");
                    application.setState(new SaveScoreState(new SaveScore(getModel().getScore())));

                }
                else if (getModel().ySelected()) {
                    getModel().addKey("y");
                    application.setState(new SaveScoreState(new SaveScore(getModel().getScore())));

                }
                else if (getModel().uSelected()) {
                    getModel().addKey("u");
                    application.setState(new SaveScoreState(new SaveScore(getModel().getScore())));

                }
                else if (getModel().iSelected()) {
                    getModel().addKey("i");
                    application.setState(new SaveScoreState(new SaveScore(getModel().getScore())));

                }
                else if (getModel().oSelected()) {
                    getModel().addKey("o");
                    application.setState(new SaveScoreState(new SaveScore(getModel().getScore())));

                }
                else if (getModel().pSelected()) {
                    getModel().addKey("p");
                    application.setState(new SaveScoreState(new SaveScore(getModel().getScore())));

                }
                else if (getModel().aSelected()) {
                    getModel().addKey("a");
                    application.setState(new SaveScoreState(new SaveScore(getModel().getScore())));

                }
                else if (getModel().sSelected()) {
                    getModel().addKey("s");
                    application.setState(new SaveScoreState(new SaveScore(getModel().getScore())));

                }
                else if (getModel().dSelected()) {
                    getModel().addKey("d");
                    application.setState(new SaveScoreState(new SaveScore(getModel().getScore())));

                }
                else if (getModel().fSelected()) {
                    getModel().addKey("f");
                    application.setState(new SaveScoreState(new SaveScore(getModel().getScore())));

                }
                else if (getModel().gSelected()) {
                    getModel().addKey("g");
                    application.setState(new SaveScoreState(new SaveScore(getModel().getScore())));

                }
                else if (getModel().hSelected()) {
                    getModel().addKey("h");
                    application.setState(new SaveScoreState(new SaveScore(getModel().getScore())));

                }
                else if (getModel().jSelected()) {
                    getModel().addKey("j");
                    application.setState(new SaveScoreState(new SaveScore(getModel().getScore())));

                }
                else if (getModel().kSelected()) {
                    getModel().addKey("k");
                    application.setState(new SaveScoreState(new SaveScore(getModel().getScore())));

                }
                else if (getModel().lSelected()) {
                    getModel().addKey("l");
                    application.setState(new SaveScoreState(new SaveScore(getModel().getScore())));

                }
                else if (getModel().zSelected()) {
                    getModel().addKey("z");
                    application.setState(new SaveScoreState(new SaveScore(getModel().getScore())));

                }
                else if (getModel().xSelected()) {
                    getModel().addKey("x");
                    application.setState(new SaveScoreState(new SaveScore(getModel().getScore())));

                }
                else if (getModel().cSelected()) {
                    getModel().addKey("c");
                    application.setState(new SaveScoreState(new SaveScore(getModel().getScore())));

                }
                else if (getModel().vSelected()) {
                    getModel().addKey("v");
                    application.setState(new SaveScoreState(new SaveScore(getModel().getScore())));

                }
                else if (getModel().bSelected()) {
                    getModel().addKey("b");
                    application.setState(new SaveScoreState(new SaveScore(getModel().getScore())));

                }
                else if (getModel().nSelected()) {
                    getModel().addKey("n");
                    application.setState(new SaveScoreState(new SaveScore(getModel().getScore())));

                }
                else if (getModel().mSelected()) {
                    getModel().addKey("m");
                    application.setState(new SaveScoreState(new SaveScore(getModel().getScore())));

                }
        }

    }
}