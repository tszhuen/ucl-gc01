package uk.ac.ucl.cs.gc01.week4.currency;

import javax.swing.JTextField;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.swt.widgets.Display;

public class CurrencyConverter extends Composite {
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	JTextField t;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public CurrencyConverter(Composite parent, int style) {
		super(parent, style);
		t = new JTextField();
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
