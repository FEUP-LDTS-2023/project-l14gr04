package RushRoulette.Model.Game.Elements;

public class Player extends Element {
    private int dead;
    private static int score;
    private static int lives=3;
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
        Player.lives = lives;
    }

    public int getLives() {
        return lives;
    }

    public void isHit(){
        lives -= 1;
    }
    public void resetLives(){
        lives = 3;
    }

    public void coinConsumed(){
        score+=1;
    }

    public void levelPoints(){
        score+=10;}

    public void resetScore(){
        score=0;
    }

    public void addLife(){
        lives+=1;
    }




}
