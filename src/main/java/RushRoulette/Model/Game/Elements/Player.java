package RushRoulette.Model.Game.Elements;

public class Player extends Element {
    private boolean dead;
    public Player(int x, int y){
        super(x, y);
        this.dead=false;
    }

    public void isDead(){
        this.dead=true;
    }

    public boolean getDead(){
        return dead;
    }

}
