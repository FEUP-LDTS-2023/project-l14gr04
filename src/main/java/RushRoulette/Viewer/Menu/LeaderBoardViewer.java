package RushRoulette.Viewer.Menu;

import RushRoulette.Model.Menu.LeaderBoard;
import RushRoulette.Model.Position;
import RushRoulette.Viewer.Viewer;
import RushRoulette.gui.GUI;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LeaderBoardViewer extends Viewer<LeaderBoard> {



    public LeaderBoardViewer(LeaderBoard LeaderBoardScreen) {
        super(LeaderBoardScreen);

    }


    @Override
    protected void drawElements(GUI gui) {

        //draw from text file
        int lineNumber = 0;
        for( String line : getModel().getEntries()){

            gui.drawText(new Position(0,lineNumber), line, "#FFFFFF");
            lineNumber += 1;
        }

        gui.drawText(new Position(3,19),getModel().getMenuOption(), "#FFD700");


    }

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

}
