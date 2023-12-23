package Projeto.States;


import Projeto.Model.Menu.LeaderBoard;
import Projeto.Viewer.Menu.LeaderBoardViewer;
import Projeto.Viewer.Viewer;
import Projeto.controller.Controller;
import Projeto.controller.menu.LeaderBoardController;

public class LeaderBoardState extends State<LeaderBoard> {
    public LeaderBoardState(LeaderBoard leaderBoard) {
        super(leaderBoard);
    }

    @Override
    public Viewer<LeaderBoard> getViewer() {
        return new LeaderBoardViewer(getModel());
    }

    @Override
    public Controller<LeaderBoard> getController() {
        return new LeaderBoardController(getModel());
    }
}
