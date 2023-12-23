
package Projeto.controller;

import Projeto.controller.Music.Sounds;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import Projeto.controller.Music.MusicPlayer;
import Projeto.controller.Music.Music;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class MusicPlayerTest {
    Music gameSoundTrackMock = Mockito.mock(Music.class);
    Music gameSoundTrack2Mock = Mockito.mock(Music.class);
    Music gameSoundTrack3Mock = Mockito.mock(Music.class);
    Music gameOverMock = Mockito.mock(Music.class);
    Music selectMock = Mockito.mock(Music.class);
    Music menuSoundTrackMock = Mockito.mock(Music.class);
    Music hitMock = Mockito.mock(Music.class);
    Music hpMock = Mockito.mock(Music.class);
    Music newLevelMock = Mockito.mock(Music.class);
    Music doubleMoneyMock = Mockito.mock(Music.class);
    Music halfMoneyMock = Mockito.mock(Music.class);
    Music invulnerableMock = Mockito.mock(Music.class);
    Music coinMock = Mockito.mock(Music.class);
    Music victoryMock = Mockito.mock(Music.class);

    MusicPlayer musicPlayerSpy;
    @BeforeEach
    void MusicPlayererSetup() {
        MusicPlayer musicPlayer = MusicPlayer.getInstance();

        musicPlayer.setGameSoundTrack(gameSoundTrackMock);

        musicPlayer.setGameOver(gameOverMock);

        musicPlayer.setMenuSoundTrack(menuSoundTrackMock);

        musicPlayer.setSelect(selectMock);

        musicPlayer.setGameSoundTrack2(gameSoundTrack2Mock);

        musicPlayer.setGameSoundTrack3(gameSoundTrack3Mock);

        musicPlayer.setHit(hitMock);

        musicPlayer.setHP(hpMock);

        musicPlayer.setNewLevel(newLevelMock);

        musicPlayer.setDoubleMoney(doubleMoneyMock);

        musicPlayer.setHalfMoney(halfMoneyMock);

        musicPlayer.setInvulnerable(invulnerableMock);

        musicPlayer.setCoin(coinMock);

        musicPlayer.setVictory(victoryMock);

        musicPlayerSpy = Mockito.spy(musicPlayer);
    }

    //--------------START-----------
    @Test
    void startGameSoundTrack() {
        musicPlayerSpy.start(Sounds.GAME_SOUNDTRACK);
        Mockito.verify(gameSoundTrackMock, Mockito.times(1)).startAndLoop();
    }

    @Test
    void startGameSoundTrack2() {
        musicPlayerSpy.start(Sounds.GAME_SOUNDTRACK2);
        Mockito.verify(gameSoundTrack2Mock, Mockito.times(1)).startAndLoop();
    }
    @Test
    void startGameSoundTrack3() {
        musicPlayerSpy.start(Sounds.GAME_SOUNDTRACK3);
        Mockito.verify(gameSoundTrack3Mock, Mockito.times(1)).startAndLoop();
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

    @Test
    void startHit() {
        musicPlayerSpy.start(Sounds.HIT);
        Mockito.verify(hitMock, Mockito.times(1)).start();
    }
    @Test
    void startHP(){
        musicPlayerSpy.start(Sounds.HP);
        Mockito.verify(hpMock, Mockito.times(1)).start();
    }    @Test
    void startNewLevel(){
        musicPlayerSpy.start(Sounds.NEW_LVL);
        Mockito.verify(newLevelMock, Mockito.times(1)).start();
    }    @Test
    void starDoubleMoney(){
        musicPlayerSpy.start(Sounds.DOUBLE_MONEY);
        Mockito.verify(doubleMoneyMock, Mockito.times(1)).start();
    }    @Test
    void startHalfMoney(){
        musicPlayerSpy.start(Sounds.HALF_MONEY);
        Mockito.verify(halfMoneyMock, Mockito.times(1)).start();
    }
    @Test
    void startInvulnerable(){
        musicPlayerSpy.start(Sounds.INVULNERABLE);
        Mockito.verify(invulnerableMock, Mockito.times(1)).start();
    }    @Test
    void startCoin(){
        musicPlayerSpy.start(Sounds.COIN);
        Mockito.verify(coinMock, Mockito.times(1)).start();
    }    @Test
    void startVictory(){
        musicPlayerSpy.start(Sounds.VICTORY);
        Mockito.verify(victoryMock, Mockito.times(1)).startAndLoop();
    }

    //--------------STOP-----------
    @Test
    void stopGameSoundTrack() {
        musicPlayerSpy.stop(Sounds.GAME_SOUNDTRACK);
        Mockito.verify(gameSoundTrackMock, Mockito.times(1)).stop();
    }
    @Test
    void stopGameSoundTrack2() {
        musicPlayerSpy.stop(Sounds.GAME_SOUNDTRACK2);
        Mockito.verify(gameSoundTrack2Mock, Mockito.times(1)).stop();
    }
    @Test
    void stopGameSoundTrack3() {
        musicPlayerSpy.stop(Sounds.GAME_SOUNDTRACK3);
        Mockito.verify(gameSoundTrack3Mock, Mockito.times(1)).stop();
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

    @Test
    void stopHit() {
        musicPlayerSpy.stop(Sounds.HIT);
        Mockito.verify(hitMock, Mockito.times(1)).stop();
    }
    @Test
    void stopHP(){
        musicPlayerSpy.stop(Sounds.HP);
        Mockito.verify(hpMock, Mockito.times(1)).stop();
    }    @Test
    void stopNewLevel(){
        musicPlayerSpy.stop(Sounds.NEW_LVL);
        Mockito.verify(newLevelMock, Mockito.times(1)).stop();
    }    @Test
    void stopDoubleMoney(){
        musicPlayerSpy.stop(Sounds.DOUBLE_MONEY);
        Mockito.verify(doubleMoneyMock, Mockito.times(1)).stop();
    }    @Test
    void stopHalfMoney(){
        musicPlayerSpy.stop(Sounds.HALF_MONEY);
        Mockito.verify(halfMoneyMock, Mockito.times(1)).stop();
    }    @Test
    void stopInvulnerable(){
        musicPlayerSpy.stop(Sounds.INVULNERABLE);
        Mockito.verify(invulnerableMock, Mockito.times(1)).stop();
    }
    @Test
    void stopCoin(){
        musicPlayerSpy.stop(Sounds.COIN);
        Mockito.verify(coinMock, Mockito.times(1)).stop();
    }    @Test
    void stopVictory(){
        musicPlayerSpy.stop(Sounds.VICTORY);
        Mockito.verify(victoryMock, Mockito.times(1)).stop();
    }

    //--------------STOP_ALL-----------

    @Test
    void stopAll() {
        musicPlayerSpy.stopAll();
        Mockito.verify(gameSoundTrackMock, Mockito.times(1)).stop();
        Mockito.verify(gameSoundTrack2Mock, Mockito.times(1)).stop();
        Mockito.verify(gameSoundTrack3Mock, Mockito.times(1)).stop();
        Mockito.verify(menuSoundTrackMock, Mockito.times(1)).stop();
        Mockito.verify(gameOverMock, Mockito.times(1)).stop();
        Mockito.verify(selectMock, Mockito.times(1)).stop();
        Mockito.verify(hitMock, Mockito.times(1)).stop();
        Mockito.verify(hpMock, Mockito.times(1)).stop();
        Mockito.verify(newLevelMock, Mockito.times(1)).stop();
        Mockito.verify(doubleMoneyMock, Mockito.times(1)).stop();
        Mockito.verify(halfMoneyMock, Mockito.times(1)).stop();
        Mockito.verify(selectMock, Mockito.times(1)).stop();
        Mockito.verify(coinMock, Mockito.times(1)).stop();
        Mockito.verify(victoryMock, Mockito.times(1)).stop();
    }

}
