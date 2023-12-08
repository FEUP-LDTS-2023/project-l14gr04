package RushRoulette.controller.Music;

public class MusicPlayer {

    private Music gameSoundTrack;

    private Music gameSoundTrack2;
    private Music menuSoundTrack;
    private Music gameOver;
    private Music select;
    private Music hit;
    private static MusicPlayer musicManager;

    private MusicPlayer() {
        gameSoundTrack = new Music("GameSoundTrack.wav");
        gameSoundTrack2 = new Music("GameSoundTrack2.wav");
        gameOver = new Music("GameOver.wav");
        menuSoundTrack = new Music("MenuSoundTrack.wav");
        select = new Music("Select.wav");
        hit = new Music("Hit.wav");
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

    public void setGameOver(Music gameOver) {
        this.gameOver = gameOver;
    }

    public void setSelect(Music select){this.select = select;}

    public void setHit(Music hit){this.hit = hit;}


    public void start(Sounds sound) {
        switch(sound) {
            case GAME_SOUNDTRACK -> gameSoundTrack.startAndLoop();
            case GAMEOVER -> gameOver.start();
            case MENU_SOUNDTRACK -> menuSoundTrack.startAndLoop();
            case SELECT -> select.start();
            case GAME_SOUNDTRACK2 -> gameSoundTrack2.startAndLoop();
            case HIT -> hit.start();
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
        }
    }

    public boolean isPlaying(Sounds sound) {
        return switch (sound) {
            case GAME_SOUNDTRACK -> gameSoundTrack.isPlaying();
            case GAMEOVER -> gameOver.isPlaying();
            case MENU_SOUNDTRACK -> menuSoundTrack.isPlaying();
            case SELECT -> select.isPlaying();
            case GAME_SOUNDTRACK2 -> gameSoundTrack2.isPlaying();
            case HIT -> hit.isPlaying();
        };
    }

    public void stopAll() {
        gameSoundTrack.stop();
        gameOver.stop();
        menuSoundTrack.stop();
        select.stop();
        gameSoundTrack2.stop();
        hit.stop();
    }


}
