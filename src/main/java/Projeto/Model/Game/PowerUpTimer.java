package Projeto.Model.Game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PowerUpTimer {
    private int initialTime=5;
    private int currentTime;
    private Timer timer;



    public PowerUpTimer(){
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
            timer.stop();
            currentTime=initialTime;
        }
    }


    public int getCurrentTime() {
        return currentTime;
    }


}
