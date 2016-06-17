package WhackAMole;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import java.util.*;


public class GameScreen extends JFrame {

    /** 
     * sets up initial game screen, extends JFrame
     */

    private static final long serialVersionUID = 1L;
    private final String SCORE = "Score: ";
    private final String LEVEL = "Level: ";
    private final String TIMER = "Timer: ";
    public final int MAX_ROWS = 4;
    public final int MAX_COLS = 4;
    private final int GAP = 10;
    protected static JLabel scoreLabel;
    protected static JLabel timerLabel;
    protected static JPanel pa; // this is the playing area
    protected static String cLevel;

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
                    Control game = new Control();
                    game.play(cLevel);
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
        /**
         * called by the main method to initialize the screen. Do not call this directly.
         */
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 450);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        this.setTitle("Whack-A-Mole!");

        cLevel = (String) JOptionPane.showInputDialog(contentPane, 
                "What level do you want to play?", "Level Selector",
                JOptionPane.QUESTION_MESSAGE, null, Control.level, Control.level[0]);

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
        JLabel levelLabel = new JLabel(LEVEL + " " + cLevel);
        timerLabel = new JLabel(TIMER + " ");

        info.add(scoreLabel);
        info.add(levelLabel);
        info.add(timerLabel);
        return info;
    }


    /**
     * Initializes the playing grid, using JButtons, but doesn't draw it.
     * The first drawing is called in the Game class
     */
    public JPanel playingArea() {
        pa = new JPanel();
        pa.setLayout(new GridLayout(MAX_ROWS, MAX_COLS, GAP, GAP));

        for (int i = 0; i < (MAX_ROWS * MAX_COLS); i++) {
            Control.moles.add(new Mole());
            pa.add(Control.moles.get(i));
        }
 
        pa.revalidate();
        return pa;
    }
}