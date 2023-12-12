package RushRoulette.Model.Game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class GameTimer {
    private int initialTime=10;
    private int currentTime ;
    private Timer timer;



    public GameTimer(){
        currentTime=initialTime;

         timer=new Timer(1000, new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 updateTimer();
             }
         });
        timer.start();
    }




    private void updateTimer(){
        currentTime--;

        if(currentTime<0){
            currentTime=initialTime;

        }
    }


    public int getCurrentTime() {
        return currentTime;
    }


}
