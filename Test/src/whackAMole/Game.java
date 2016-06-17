package whackAMole;

import java.util.*;
import javax.swing.Timer;

import java.awt.event.*;

public class Game {

    private static boolean DEBUG = true;

    public static Integer score = 0;
    static final String[] level = new String[] {"easy", "medium", "hard"};
    private static int gapPerMole = 3000; // this is for easy level
    private static int active;
    static Random rand = new Random();
    public static Mole[] moles = new Mole[16];
    private boolean running = true;
    
    public void play() {

    	while (running) {
    		Timer timer = new javax.swing.Timer(gapPerMole, new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		updateMoles();
        		}
    		});
    		timer.start();
    		
    		
    	}
        
     }
        
 

    public static void updateMoles() {
        active = rand.nextInt(16);
        if (DEBUG) System.out.println("Rand num: " + active);
        for (int i = 0; i < 16; i++) {
            if (i == active) {
                moles[i].setActive();        
            } else {
                moles[i].setInactive();
            }
        }
    }

    public static void updateScore() {
        score += 10;
        GameScreen.scoreLabel.setText("Score: " + score);
    }
}