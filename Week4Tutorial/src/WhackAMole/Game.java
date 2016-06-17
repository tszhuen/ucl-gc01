package WhackAMole;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.util.*;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class Game {

	private JFrame frame;
	public static JLabel scorer;
	public static JLabel timer;

    static Random rand = new Random();
    public static Mole[] moles = new Mole[16];
    public static int scorekeeper = 0;
    protected static String cLevel;
    

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Game window = new Game();
					window.frame.setVisible(true);
                    Control game = new Control();
                    game.play(cLevel);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Game() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel info = new JPanel();
		frame.getContentPane().add(info, BorderLayout.NORTH);
		info.setLayout(new GridLayout(1, 4));
		
		
		
		JLabel time = new JLabel("Time");
		info.add(time);
		
		timer = new JLabel("");
		info.add(timer);
		
		JLabel score = new JLabel("Score");
		info.add(score);
		
		scorer = new JLabel("");
		info.add(scorer);
		
		JPanel playGround = new JPanel();
		frame.getContentPane().add(playGround, BorderLayout.CENTER);
		playGround.setLayout(new GridLayout(4, 4, 10, 10));
		
		for (int i = 0; i < (16); i++) {
			Control.moles.add(new Mole());
			playGround.add(Control.moles.get(i));
        }
	}
	
	
/*	public void play() {
		final Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask(){
            int seconds = 60;

            public void run () {
                seconds--;
                //timer.setText("Timer: " + seconds);
                        if (seconds > 50) {
                            if (seconds % 3 == 0) updateMoles();
                        } 
                        else if (seconds > 30) {
                            if (seconds % 2 == 0) updateMoles();
                        } 
                        else updateMoles();
    		
            }
            },0,1000);
        
     }
	
	public static void updateMoles() {
        active = rand.nextInt(16);
        for (int i = 0; i < 16; i++) {
            if (i == active) {
                moles[i].setActive();        
            } else {
                moles[i].setInactive();
            }
        }
    }
	public static void updateScore() {
	 scorekeeper++;
	 	Game.scorer.setText(""+scorekeeper);
    }
	
/*	int secondPasses = 0;
	Timer timekeeper = new Timer();
	TimerTask task = new TimerTask(){
		public void run(){
			secondPasses++;
		}
	timer.start();
	};
	
	public void start(){
		timekeeper.scheduleAtFixedRate(task,1000,1000);
	}*/
	

}
