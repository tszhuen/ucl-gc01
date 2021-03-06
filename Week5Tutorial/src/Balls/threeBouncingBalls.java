package Balls;

import java.awt.*;
import java.util.Formatter;
import javax.swing.*;

// Extends JPanel, so as to override the paintComponent() for custom rendering codes. 
public class threeBouncingBalls extends JPanel {
	// Container box's width and height
	private static final int BOX_WIDTH = 600;
	private static final int BOX_HEIGHT = 600;

	// Ball 1's properties: moving horizontally 
	private float ball1Radius = 25; 
	private float ball1X = ball1Radius + 10; // Ball's center (x, y) 
	private float ball1Y = ball1Radius + 20; 
	private float ball1SpeedX = 3; 

	// Ball 2's properties: moving vertically
	private float ball2Radius = 40; 
	private float ball2X = ball1Radius + 10; 
	private float ball2Y = ball1Radius + 20; 
	private float ball2SpeedY = 6;

	// Ball 3's properties
	private float ball3Radius = 20; 
	private float ball3X = ball3Radius + 10; 
	private float ball3Y = ball3Radius + 20; 
	private float ball3SpeedX = 1;   
	private float ball3SpeedY = 6;

	private static final int UPDATE_RATE = 30; // Number of refresh per second

	/** Constructor to create the UI components and init game objects. */
	public threeBouncingBalls() {
		this.setPreferredSize(new Dimension(BOX_WIDTH, BOX_HEIGHT));

		// Start the ball bouncing (in its own thread)
		Thread gameThread = new Thread() {
			public void run() {
				while (true) { // Execute one update step
					// Calculate the ball's new position

					ball1X += ball1SpeedX;
					if (ball1X - ball1Radius < 0) {
						ball1SpeedX = -ball1SpeedX; // Reflect along normal
						ball1X = ball1Radius; // Re-position the ball at the edge
					} else if (ball1X + ball1Radius > BOX_WIDTH) {
						ball1SpeedX = -ball1SpeedX;
						ball1X = BOX_WIDTH - ball1Radius;
					}

					ball2Y += ball2SpeedY;
					if (ball2Y - ball2Radius < 0) {
						ball2SpeedY = -ball2SpeedY;
						ball2Y = ball2Radius;
					} else if (ball2Y + ball2Radius > BOX_HEIGHT) {
						ball2SpeedY = -ball2SpeedY;
						ball2Y = BOX_HEIGHT - ball2Radius;
					}

					ball3X += ball3SpeedX;
					ball3Y += ball3SpeedY;
					// Check if the ball moves over the bounds
					// If so, adjust the position and speed.
					if (ball3X - ball3Radius < 0) {
						ball3SpeedX = -ball3SpeedX; // Reflect along normal
						ball3X = ball3Radius; // Re-position the ball at the edge
					} else if (ball3X + ball3Radius > BOX_WIDTH) {
						ball3SpeedX = -ball3SpeedX;
						ball3X = BOX_WIDTH - ball3Radius;
					}
					// May cross both x and y bounds
					if (ball3Y - ball3Radius < 0) {
						ball3SpeedY = -ball3SpeedY;
						ball3Y = ball3Radius;
					} else if (ball3Y + ball3Radius > BOX_HEIGHT) {
						ball3SpeedY = -ball3SpeedY;
						ball3Y = BOX_HEIGHT - ball3Radius;
					}
					// Refresh the display
					repaint(); // Callback paintComponent()
					// Delay for timing control and give other threads a chance
					try {
						Thread.sleep(800 / UPDATE_RATE);  // milliseconds
					} catch (InterruptedException ex) { }
				}
			}
		};
		gameThread.start();  // Callback run()
	}

	/** Custom rendering codes for drawing the JPanel */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);    // Paint background

		// Draw the box
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, BOX_WIDTH, BOX_HEIGHT);

		// Draw ball1
		g.setColor(Color.RED);
		g.fillOval((int) (ball1X - ball1Radius), (int) (ball1Y - ball1Radius),
				(int)(2 * ball1Radius), (int)(2 * ball1Radius));

		// Draw ball2
		g.setColor(Color.ORANGE);
		g.fillOval((int) (ball2X - ball2Radius), (int) (ball2Y - ball2Radius),
				(int)(2 * ball2Radius), (int)(2 * ball2Radius));

		// Draw ball3
		g.setColor(Color.BLUE);
		g.fillOval((int) (ball3X - ball3Radius), (int) (ball3Y - ball3Radius),
				(int)(2 * ball3Radius), (int)(2 * ball3Radius));

		// Display the ball3's information
		g.setColor(Color.BLACK);
		g.setFont(new Font("Courier", Font.PLAIN, 16));
		StringBuilder sb = new StringBuilder();
		Formatter formatter = new Formatter(sb);
		formatter.format("Ball 1 @(%3.0f,%3.0f), Ball 2 @(%3.0f,%3.0f), Ball 3 @(%3.0f,%3.0f)"
				,ball1X, ball1Y,ball2X, ball2Y,ball3X, ball3Y);
		g.drawString(sb.toString(), 20, 30);
	}


	public static void main(String[] args) {
		// Run GUI in the Event Dispatcher Thread (EDT) instead of main thread.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				// Set up main window (using Swing's Jframe)
				JFrame frame = new JFrame("Tutorial 5 Exercise 3: 3 Bouncing Balls");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setContentPane(new threeBouncingBalls());
				frame.pack();
				frame.setVisible(true);
			}
		});
	}
}