package RushRoulette.controller;

import RushRoulette.controller.Music.Sounds;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import RushRoulette.controller.Music.MusicPlayer;
import RushRoulette.controller.Music.Music;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class MusicPlayerTest {
    Music gameSoundTrackMock = Mockito.mock(Music.class);
    Music gameOverMock = Mockito.mock(Music.class);
    Music selectMock = Mockito.mock(Music.class);
    Music menuSoundTrackMock = Mockito.mock(Music.class);
    MusicPlayer musicPlayerSpy;
    @BeforeEach
    void MusicPlayererSetup() {
        MusicPlayer musicPlayer = MusicPlayer.getInstance();

        musicPlayer.setGameSoundTrack(gameSoundTrackMock);

        musicPlayer.setGameOver(gameOverMock);

        musicPlayer.setMenuSoundTrack(menuSoundTrackMock);

        musicPlayer.setSelect(selectMock);

        musicPlayerSpy = Mockito.spy(musicPlayer);
    }

    //--------------START-----------
    @Test
    void startGameSoundTrack() {
        musicPlayerSpy.start(Sounds.GAME_SOUNDTRACK);
        Mockito.verify(gameSoundTrackMock, Mockito.times(1)).startAndLoop();
    }
    @Test
    void startGameOver() {
        musicPlayerSpy.start(Sounds.GAMEOVER);
        Mockito.verify(gameOverMock, Mockito.times(1)).start();
    }
    @Test
    void startMenuSoundTrack() {
        musicPlayerSpy.start(Sounds.MENU_SOUNDTRACK);
        Mockito.verify(menuSoundTrackMock, Mockito.times(1)).startAndLoop();
    }

    @Test
    void startSelect() {
        musicPlayerSpy.start(Sounds.SELECT);
        Mockito.verify(selectMock, Mockito.times(1)).start();
    }


    //--------------STOP-----------
    @Test
    void stopGameSoundTrack() {
        musicPlayerSpy.stop(Sounds.GAME_SOUNDTRACK);
        Mockito.verify(gameSoundTrackMock, Mockito.times(1)).stop();
    }
    @Test
    void stopGameOver() {
        musicPlayerSpy.stop(Sounds.GAMEOVER);
        Mockito.verify(gameOverMock, Mockito.times(1)).stop();
    }
    @Test
    void stopMenuSoundTrack() {
        musicPlayerSpy.stop(Sounds.MENU_SOUNDTRACK);
        Mockito.verify(menuSoundTrackMock, Mockito.times(1)).stop();
    }

    @Test
    void stopSelect() {
        musicPlayerSpy.stop(Sounds.SELECT);
        Mockito.verify(selectMock, Mockito.times(1)).stop();
    }


    //--------------isPLAYING-----------

    @Test
    void isPlayingGameSoundTrackTrue() {
        Mockito.when(gameSoundTrackMock.isPlaying()).thenReturn(true);
        boolean playing = musicPlayerSpy.isPlaying(Sounds.GAME_SOUNDTRACK);
        assertTrue(playing);
    }
    @Test
    void isPlayingGameSoundTrackFalse() {
        Mockito.when(gameSoundTrackMock.isPlaying()).thenReturn(false);
        boolean playing = musicPlayerSpy.isPlaying(Sounds.GAME_SOUNDTRACK);
        assertFalse(playing);
    }

    @Test
    void isPlayingGameOverTrue() {
        Mockito.when(gameOverMock.isPlaying()).thenReturn(true);
        boolean playing = musicPlayerSpy.isPlaying(Sounds.GAMEOVER);
        assertTrue(playing);
    }
    @Test
    void isPlayingGameOverFalse() {
        Mockito.when(gameOverMock.isPlaying()).thenReturn(false);
        boolean playing = musicPlayerSpy.isPlaying(Sounds.GAMEOVER);
        assertFalse(playing);
    }

    @Test
    void isPlayingMenuSoundTrackTrue() {
        Mockito.when(menuSoundTrackMock.isPlaying()).thenReturn(true);
        boolean playing = musicPlayerSpy.isPlaying(Sounds.MENU_SOUNDTRACK);
        assertTrue(playing);
    }
    @Test
    void isPlayingMenuSoundTrackFalse() {
        Mockito.when(menuSoundTrackMock.isPlaying()).thenReturn(false);
        boolean playing = musicPlayerSpy.isPlaying(Sounds.MENU_SOUNDTRACK);
        assertFalse(playing);
    }

    @Test
    void isPlayingSelectTrue() {
        Mockito.when(selectMock.isPlaying()).thenReturn(true);
        boolean playing = musicPlayerSpy.isPlaying(Sounds.SELECT);
        assertTrue(playing);
    }

    @Test
    void isPlayingSelectFalse() {
        Mockito.when(selectMock.isPlaying()).thenReturn(false);
        boolean playing = musicPlayerSpy.isPlaying(Sounds.SELECT);
        assertFalse(playing);
    }

    //--------------STOP_ALL-----------

    @Test
    void stopAll() {
        musicPlayerSpy.stopAll();
        Mockito.verify(gameSoundTrackMock, Mockito.times(1)).stop();
        Mockito.verify(menuSoundTrackMock, Mockito.times(1)).stop();
        Mockito.verify(gameOverMock, Mockito.times(1)).stop();
        Mockito.verify(selectMock, Mockito.times(1)).stop();
    }

}
