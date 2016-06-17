package uk.ac.ucl.cs.gc01.week4.moreGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;

public class MouseListener extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MouseListener frame = new MouseListener();
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
	public MouseListener() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel coordinatesLabel = new JLabel();
		coordinatesLabel.setText("Axis");
		coordinatesLabel.setBounds(166, 226, 117, 16);
		contentPane.add(coordinatesLabel);
		
		JLabel label = new JLabel("You can move this");
		label.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				label.setLocation(e.getX(), e.getY());
				coordinatesLabel.setText("Axis: " + e.getX() + ", " + e.getY());
			}
		});
		label.setBounds(47, 77, 150, 16);
		contentPane.add(label);
		
		JButton btnNewButton = new JButton("but not this");
		btnNewButton.setBounds(279, 72, 117, 29);
		contentPane.add(btnNewButton);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("nor this");
		rdbtnNewRadioButton.setBounds(25, 165, 141, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(289, 165, 90, 27);
		contentPane.add(comboBox);
		
	}

}
