package Projeto.controller.Music;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Music {
    private Clip music;

    public Music(String music) {
        this.music = loadMusic(music);
    }

    public Clip getMusic() {
        return music;
    }

    public void setMusic(Clip music) {
        this.music = music;
    }

    public boolean isPlaying(){return music.isRunning();}

    public Clip loadMusic(String music) throws NullPointerException{
        try {
            String rootPath = new File(System.getProperty("user.dir")).getPath();
            //String musicPath = rootPath + "/src/main/resources/" + music;

            Path musicPath = Paths.get(rootPath, "src", "main", "resources","Music", music);

            String musicFilePath = musicPath.toString();

            File musicFile = new File(musicFilePath);

            AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicFile);
            Clip musicClip = AudioSystem.getClip();
            musicClip.open(audioInput);

            FloatControl gainControl = (FloatControl) musicClip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-25.0f);

            return musicClip;

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage()) ;
            e.printStackTrace();
        }
        return null;
    }

    public void start() { //for one time sounds
        music.setMicrosecondPosition(0);
        music.start();
    }

    public  void startAndLoop(){ //for continuous sounds
        music.setMicrosecondPosition(0);
        music.start();
        music.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop() {music.stop();}

}
