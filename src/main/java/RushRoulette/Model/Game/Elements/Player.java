package RushRoulette.Model.Game.Elements;

public class Player extends Element {
    private int dead;
    private static int score;
    private static int livesLost;
    public Player(int x, int y){
        super(x, y);
        this.dead = 0;
    }

    public void isDead(){
        this.dead=1;
    }

    public int getDead(){
        return dead;
    } //if dead==0 player is alive, if dead==1 player is dead

    public int getScore(){
        return score;
    }

    public void setLives(int lives) { //for powerUps
        this.livesLost = lives;
    }

    public int getLivesLost() {
        return livesLost;
    }

    public void isHit(){
        this.livesLost += 1;
    }
    public void resetLives(){
        this.livesLost = 0;
    }

    public void coinConsumed(){
        this.score+=1;
    }

    public void levelPoints(){this.score+=10;}

    public void resetScore(){
        this.score=0;
    }
}
