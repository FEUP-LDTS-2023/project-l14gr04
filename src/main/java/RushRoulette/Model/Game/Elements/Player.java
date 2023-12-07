package RushRoulette.Model.Game.Elements;

public class Player extends Element {
    private int dead;
    public Player(int x, int y){
        super(x, y);
        this.dead=0;
    }

    public void isDead(){
        this.dead=1;
    }

    public int getDead(){
        return dead;
    } //if dead==0 player is alive, if dead==1 player is dead

}
