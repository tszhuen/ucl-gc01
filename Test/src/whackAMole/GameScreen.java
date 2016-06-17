package whackAMole;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;

public class GameScreen extends JFrame {

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    private final String INSTRUCTIONS= "Click on the moles to get rid of the pests for ever!";
    private final String SCORE = "Score: ";
    private final String LEVEL = "Level: ";
    private final String TIMER = "Timer: ";
    private final int MAX_ROWS = 4;
    private final int MAX_COLS = 4;
    private final int GAP = 10;
    public static JLabel scoreLabel;
    public static JPanel pa; // this is the playing area

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args)
    {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }

        EventQueue.invokeLater(new Runnable() {
            public void run() { 
                try {
                    GameScreen frame = new GameScreen();
                    frame.setVisible(true);
                    Game game = new Game();
                    game.play();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    /**
     * Create the frame.
     */
    public GameScreen() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 450);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        this.setTitle("Whack-A-Mole!");

        JOptionPane.showMessageDialog(null, INSTRUCTIONS, "MOLES", JOptionPane.PLAIN_MESSAGE);

        JPanel info_bar = info_bar();
        this.getContentPane().add(info_bar, BorderLayout.NORTH);
        JPanel playingArea = playingArea();
        this.getContentPane().add(playingArea, BorderLayout.CENTER);

    }


    /**
     * Create the info bar at the top of the game screen
     */
    public JPanel info_bar() {
        JPanel info = new JPanel();
        info.setLayout(new GridLayout(1, 3));
        scoreLabel = new JLabel(SCORE + 0);
        JLabel levelLabel = new JLabel(LEVEL + " " + Game.level[0]);
        // this doesn't work yet
        JLabel timerLabel = new JLabel(TIMER + " ");

        info.add(scoreLabel);
        info.add(levelLabel);
        info.add(timerLabel);
        return info;
    }


    /**
     * Draw the playing grid, using JButtons
     */
    public JPanel playingArea() {
        pa = new JPanel();
        pa.setLayout(new GridLayout(MAX_ROWS, MAX_COLS, GAP, GAP));

        for (int i = 0; i < (MAX_ROWS * MAX_COLS); i++) {
            Game.moles[i] = new Mole();
            pa.add(Game.moles[i]);
        }
 
        pa.revalidate();
        return pa;
    }
}