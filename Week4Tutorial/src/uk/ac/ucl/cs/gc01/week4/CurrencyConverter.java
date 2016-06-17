package uk.ac.ucl.cs.gc01.week4;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CurrencyConverter {

	private JFrame frame;
	private JTextField textField;
	public static JTextField converted;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CurrencyConverter window = new CurrencyConverter();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CurrencyConverter() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		Currency converter = new Currency();
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				converter.onlyNumbers(textField.getText());
			}
		});
		textField.setBounds(85, 60, 130, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		String[] currencies = Currency.currencies.toArray(new String[Currency.currencies.size()]);
		
		JComboBox<String> currenciesBox = new JComboBox<String>(currencies);
		currenciesBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				converter.onlyNumbers(textField.getText());
				converter.currentCurrency = currenciesBox.getSelectedIndex();
			}
		});
		currenciesBox.setBounds(227, 61, 80, 27);
		frame.getContentPane().add(currenciesBox);
		
		JLabel lblTo = new JLabel("TO");
		lblTo.setBounds(319, 65, 31, 16);
		frame.getContentPane().add(lblTo);
		
		JComboBox<String> convertedBox = new JComboBox<String>(currencies);
		convertedBox.setBounds(351, 61, 80, 27);
		frame.getContentPane().add(convertedBox);
		
		JButton btnGo = new JButton("GO!");
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				converter.conversion(convertedBox.getSelectedIndex());
			}
		});
		btnGo.setBounds(176, 112, 117, 29);
		frame.getContentPane().add(btnGo);
		
		converted = new JTextField();
		converted.setBounds(163, 210, 130, 26);
		frame.getContentPane().add(converted);
		converted.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("The result is:");
		lblNewLabel.setBounds(191, 182, 93, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblConvert = new JLabel("Convert");
		lblConvert.setBounds(23, 65, 61, 16);
		frame.getContentPane().add(lblConvert);
		
	}
}
