package Projeto.controller.Music;

public class MusicPlayer {

    private Music gameSoundTrack;
    private Music gameSoundTrack2;
    private Music gameSoundTrack3;
    private Music menuSoundTrack;
    private Music gameOver;
    private Music victory;
    private Music select;
    private Music hit;
    private Music hp;
    private Music doubleMoney;
    private Music halfMoney;
    private Music newLevel;
    private Music coin;
    private Music invulnerable;
    private static MusicPlayer musicManager;

    private MusicPlayer() {
        gameSoundTrack = new Music("GameSoundTrack.wav");
        gameSoundTrack2 = new Music("GameSoundTrack2.wav");
        gameSoundTrack3 = new Music("GameSoundTrack3.wav");
        gameOver = new Music("GameOver.wav");
        victory = new Music("Victory.wav");
        menuSoundTrack = new Music("MenuSoundTrack.wav");
        select = new Music("Select.wav");
        hit = new Music("Hit.wav");

        hp = new Music("HP.wav");
        doubleMoney = new Music("DoubleMoney.wav");
        halfMoney = new Music("HalfMoney.wav");
        newLevel = new Music("NewLVL.wav");
        coin = new Music("Coin.wav");
        invulnerable = new Music("Invulnerable.wav");
    }

    public static MusicPlayer getInstance() { //singleton PATTERN i think
        if (musicManager == null) {
            musicManager = new MusicPlayer();
        }
        return musicManager;
    }


    public void setMenuSoundTrack(Music menuSoundTrack) {
        this.menuSoundTrack = menuSoundTrack;
    }

    public void setGameSoundTrack(Music gameSoundTrack) {
        this.gameSoundTrack = gameSoundTrack;
    }

    public void setGameSoundTrack2(Music gameSoundTrack2) {
        this.gameSoundTrack2 = gameSoundTrack2;
    }

    public void setGameSoundTrack3(Music gameSoundTrack3) {
        this.gameSoundTrack3 = gameSoundTrack3;
    }

    public void setGameOver(Music gameOver) {
        this.gameOver = gameOver;
    }

    public void setVictory(Music victory){this.victory = victory;}

    public void setSelect(Music select){this.select = select;}

    public void setHit(Music hit){this.hit = hit;}
    public void setCoin(Music coin) {this.coin = coin;}
    public void setHP(Music hp){this.hp = hp;}
    public void setNewLevel(Music newLevel){this.newLevel = newLevel;}
    public void setDoubleMoney(Music doubleMoney){this.doubleMoney = doubleMoney;}
    public void setHalfMoney(Music halfMoney){this.halfMoney = halfMoney;}
    public void setInvulnerable(Music invulnerable) {
        this.invulnerable = invulnerable;
    }


    public void start(Sounds sound) {
        switch(sound) {
            case GAME_SOUNDTRACK -> gameSoundTrack.startAndLoop();
            case GAMEOVER -> gameOver.start();
            case MENU_SOUNDTRACK -> menuSoundTrack.startAndLoop();
            case SELECT -> select.start();
            case GAME_SOUNDTRACK2 -> gameSoundTrack2.startAndLoop();
            case HIT -> hit.start();
            case GAME_SOUNDTRACK3 -> gameSoundTrack3.startAndLoop();
            case VICTORY -> victory.startAndLoop();
            case HP -> hp.start();
            case NEW_LVL -> newLevel.start();
            case HALF_MONEY -> halfMoney.start();
            case DOUBLE_MONEY -> doubleMoney.start();
            case COIN -> coin.start();
            case INVULNERABLE -> invulnerable.start();
        }
    }

    public void stop(Sounds sound) {
        switch(sound) {
            case GAME_SOUNDTRACK -> gameSoundTrack.stop();
            case GAMEOVER -> gameOver.stop();
            case  MENU_SOUNDTRACK -> menuSoundTrack.stop();
            case SELECT -> select.stop();
            case GAME_SOUNDTRACK2 -> gameSoundTrack2.stop();
            case HIT -> hit.stop();
            case GAME_SOUNDTRACK3 -> gameSoundTrack3.stop();
            case VICTORY -> victory.stop();
            case HP -> hp.stop();
            case NEW_LVL -> newLevel.stop();
            case DOUBLE_MONEY -> doubleMoney.stop();
            case HALF_MONEY -> halfMoney.stop();
            case COIN -> coin.stop();
            case INVULNERABLE -> invulnerable.stop();
        }
    }

    public void stopAll() {
        gameSoundTrack.stop();
        gameOver.stop();
        menuSoundTrack.stop();
        select.stop();
        gameSoundTrack2.stop();
        hit.stop();
        gameSoundTrack3.stop();
        victory.stop();
        hp.stop();
        doubleMoney.stop();
        halfMoney.stop();
        newLevel.stop();
        coin.stop();
        invulnerable.stop();
    }



}
