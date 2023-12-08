package RushRoulette.controller.Music;

public class MusicPlayer {

    private Music gameSoundTrack;
    private Music menuSoundTrack;
    private Music gameOver;
    private Music select;
    private static MusicPlayer musicManager;

    private MusicPlayer() {
        gameSoundTrack = new Music("GameSoundTrack.wav");
        gameOver = new Music("GameOver.wav");
        menuSoundTrack = new Music("MenuSoundTrack.wav");
        select = new Music("Select.wav");
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

    public void setGameOver(Music gameOver) {
        this.gameOver = gameOver;
    }

    public void setSelect(Music select){this.select = select;}


    public void start(Sounds sound) {
        switch(sound) {
            case GAME_SOUNDTRACK -> gameSoundTrack.startAndLoop();
            case GAMEOVER -> gameOver.start();
            case MENU_SOUNDTRACK -> menuSoundTrack.startAndLoop();
            case SELECT -> select.start();
        }
    }

    public void stop(Sounds sound) {
        switch(sound) {
            case GAME_SOUNDTRACK -> gameSoundTrack.stop();
            case GAMEOVER -> gameOver.stop();
            case  MENU_SOUNDTRACK -> menuSoundTrack.stop();
            case SELECT -> select.stop();
        }
    }

    public boolean isPlaying(Sounds sound) {
        return switch (sound) {
            case GAME_SOUNDTRACK -> gameSoundTrack.isPlaying();
            case GAMEOVER -> gameOver.isPlaying();
            case MENU_SOUNDTRACK -> menuSoundTrack.isPlaying();
            case SELECT -> select.isPlaying();
        };
    }

    public void stopAll() {
        gameSoundTrack.stop();
        gameOver.stop();
        menuSoundTrack.stop();
        select.stop();
        //...
    }


}
