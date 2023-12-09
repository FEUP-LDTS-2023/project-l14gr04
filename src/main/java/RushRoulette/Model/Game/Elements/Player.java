package RushRoulette.Model.Game.Elements;

import RushRoulette.Model.Game.GameTimer;
import RushRoulette.Model.Game.PowerUpTimer;
import RushRoulette.controller.Music.MusicPlayer;
import RushRoulette.controller.Music.Sounds;

public class Player extends Element {
    private int dead;
    private static int pontuationSystem=0;

    private static int invulnerability=0;

    private static int score;
    private static int lives=3;
    private static PowerUpTimer powerUpTimer= new PowerUpTimer();
    public Player(int x, int y){
        super(x, y);
        this.dead = 0;
    }

    public int getInvulnerability() {
        return invulnerability;
    }

    public void setInvulnerability(int invulnerability) {
        Player.invulnerability = invulnerability;
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

    public int getLives() {
        return lives;
    }

    public void isHit(){
        lives -= 1;
        MusicPlayer.getInstance().start(Sounds.HIT);
    }
    public void resetLives(){
        lives = 3;
    }

    public void coinConsumed(){
        MusicPlayer.getInstance().start(Sounds.COIN);
        score+=2;
    }

    public void DoubleCoinConsumed(){
        MusicPlayer.getInstance().start(Sounds.COIN);
        score+=4;
    }

    public void HalfCoinConsumed(){
        MusicPlayer.getInstance().start(Sounds.COIN);
        score+=1;
    }

    public void levelPoints(){

        score+=10;
    }

    public void resetScore(){
        score=0;
    }

    public void addLife(){
        MusicPlayer.getInstance().start(Sounds.HP);
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
        MusicPlayer.getInstance().start(Sounds.HALF_MONEY);
        PowerUpTimer powerUpTimer=new PowerUpTimer();
        setPowerUpTimer(powerUpTimer);
    }

    public void dup(){
        pontuationSystem=2;
        MusicPlayer.getInstance().start(Sounds.DOUBLE_MONEY);
        PowerUpTimer powerUpTimer=new PowerUpTimer();
        setPowerUpTimer(powerUpTimer);
    }


    public int getPointsSystem() {
        return pontuationSystem;
    }

    public void invulnerable(){
        invulnerability=1;
        MusicPlayer.getInstance().start(Sounds.INVULNERABLE);
        PowerUpTimer powerUpTimer=new PowerUpTimer();
        setPowerUpTimer(powerUpTimer);
    }
}
