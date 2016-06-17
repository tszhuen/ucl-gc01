package WhackAMole;

import java.awt.event.*;
import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;


public class Control {
    /**
     * Game logic is kep here. The Game class contains the data for different levels, length of
     * game,and the value of a kill. 
     */

    protected static final String[] level = new String[] {"easy", "medium", "hard"};
    protected static ArrayList<Mole> moles = new ArrayList<Mole>(16);
    private final int GAMELENGTH= 60;  
    private static final int TOTAL_MOLES = 16;

    private static int active;
    static Random rand = new Random();
    protected static Integer score = 0;
    
    /**
     * create a timer and then call updateMoles() event based
     * on seconds passed
     */
    protected void play(String chosenLevel) {
        /**
         * Launches the game and calls regular updates through the Timer util
         * @param String of chosen level of difficulty
         */

        final Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            int seconds = GAMELENGTH;

            public void run () {
                seconds--;
                Game.timer.setText( ""+ seconds);
                   updateMoles();
                if (seconds == 0) {
                    timer.cancel();
                }
            }
        }, 0, 1000);    // timer counts in seconds (1000 ms)
    }


    private void updateMoles() {
        /**
         * draws the moles to the board, choosing one at random to be the active mole
         */
        active = rand.nextInt(TOTAL_MOLES);
        for (int i = 0; i < TOTAL_MOLES; i++) {
            if (i == active) {
                moles.get(i).setActive();
            } else {
                moles.get(i).setInactive();
            }
        }
    }

    // overloaded method;
 /*   private void updateMoles(int num) {
      
        Collections.shuffle(moles);
        for (int i = 0; i < num; i++) {
            moles.get(i).setActive();
        }
        for (int i = num; i < moles.size(); i++) {
            moles.get(i).setInactive();
        }
    }*/


    protected static void updateScore() {
        /**
         * updates the score in the GameScreen info bar
         */
        score ++;
        Game.scorer.setText("Score: " + score);
    }

}