package RushRoulette.States;


import RushRoulette.Model.Menu.LeaderBoard;
import RushRoulette.Viewer.Menu.LeaderBoardViewer;
import RushRoulette.Viewer.Viewer;
import RushRoulette.controller.Controller;
import RushRoulette.controller.menu.LeaderBoardController;

public class LeaderBoardState extends State<LeaderBoard> {
    public LeaderBoardState(LeaderBoard leaderBoard) {
        super(leaderBoard);
    }

    @Override
    protected Viewer<LeaderBoard> getViewer() {
        return new LeaderBoardViewer(getModel());
    }

    @Override
    protected Controller<LeaderBoard> getController() {
        return new LeaderBoardController(getModel());
    }
}
