package uk.ac.ucl.cs.gc01.week4;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.JLabel;

public class WhackAMole extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JPanel infoArea;
	public static JPanel playGround;
	private JLabel time;
	public JLabel timer;
	private JLabel score;
	public static JLabel scorer;
	private boolean running = true;
	private static int active;
    static Random rand = new Random();
    //public static Mole[] moles = new Mole[16];
    public static int scorekeeper = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WhackAMole frame = new WhackAMole();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WhackAMole() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		JPanel info = info();
        this.getContentPane().add(info, BorderLayout.NORTH);
        //JPanel game = game();
        //this.getContentPane().add(game, BorderLayout.CENTER);
	}
	
	public JPanel info(){
		infoArea = new JPanel();
		playGround.setLayout(new GridLayout(1, 4));
		
        {
        	time = new JLabel("Time");
        	infoArea.add(time);
        }
        {
        	timer = new JLabel(" ");
        	infoArea.add(timer);
        }
        {
        	score = new JLabel("Score");
        	infoArea.add(score);
        }
        {
        	scorer = new JLabel("0");
        	infoArea.add(scorer);
        }
		
		return infoArea;
		
	}}
	
	/*public JPanel game(){
		playGround = new JPanel();
		playGround.setLayout(new GridLayout(4, 4, 10, 10));

        for (int i = 0; i < (16); i++) {
            WhackAMole.moles[i] = new Mole();
            playGround.add(WhackAMole.moles[i]);
        }
 
        playGround.revalidate();
        return playGround;
    }
	
	 public void play() {

	    	while (running) {
	    		Timer timekeeper = new javax.swing.Timer(gapPerMole, new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		updateMoles();
	        		}
	    		});
	    		timekeeper.start();
	    	}
	     }
	 public static void updateMoles() {
	        active = rand.nextInt(16);
	        System.out.println("Rand num: " + active);
	        for (int i = 0; i < 16; i++) {
	            if (i == active) {
	                moles[i].setActive();        
	            } else {
	                moles[i].setInactive();
	            }
	        }
	    }
	 public static void updateScore() {
		 scorekeeper += 10;
		 WhackAMole.scorer.setText(""+scorekeeper);
	    }
}
*/