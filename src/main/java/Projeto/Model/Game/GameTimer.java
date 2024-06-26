package Projeto.Model.Game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
            resetTimer();

        }
    }


    public int getCurrentTime() {
        return currentTime;
    }


    public void resetTimer() {
        currentTime=initialTime;
    }
}
