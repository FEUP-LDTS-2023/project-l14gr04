package RushRoulette.Model.Game.Elements;

import RushRoulette.Model.Game.GameTimer;
import RushRoulette.Model.Game.PowerUpTimer;

public class Player extends Element {
    private int dead;
    private static int pontuationSystem=0;
    private static int score;
    private static int lives=3;
    private static PowerUpTimer powerUpTimer= new PowerUpTimer();
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
        score+=2;
    }

    public void levelPoints(){
        score+=10;}

    public void resetScore(){
        score=0;
    }

    public void addLife(){
        lives+=1;
    }


    public PowerUpTimer getPowerUpTimer() {
        return powerUpTimer;
    }

    public void setPowerUpTimer(PowerUpTimer powerUpTimer) {
        this.powerUpTimer = powerUpTimer;
    }

    public void setPontuationSystem(int pontuationSystem) {
        this.pontuationSystem=pontuationSystem;
    }


    public void half(){
        pontuationSystem=1;
        PowerUpTimer powerUpTimer=new PowerUpTimer();
        setPowerUpTimer(powerUpTimer);
    }

    public void dup(){
        pontuationSystem=2;
        PowerUpTimer powerUpTimer=new PowerUpTimer();
        setPowerUpTimer(powerUpTimer);
    }

    public void DoubleCoinConsumed(){score+=4;}

    public void HalfCoinConsumed(){
        score+=1;
    }

    public int getPointsSystem() {
        return pontuationSystem;
    }
}
