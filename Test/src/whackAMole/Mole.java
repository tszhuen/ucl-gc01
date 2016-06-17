package whackAMole;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.ImageIcon;

public class Mole extends JButton implements ActionListener {

    private static final long serialVersionUID = 1L;
    private boolean isActive;

    // it seems this doesn't throw an exception.
    ImageIcon hole = new ImageIcon("/user/Lily/desktop/UCL/GC01/material/Mole.jpg");

    public Mole() {
        this.setInactive();
        addActionListener(this);
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setInactive() {
        this.isActive = false;
        this.setIcon(hole);
        this.setBackground(Color.gray);
    }

    public void setActive() {
        this.isActive = true;
        this.setBackground(Color.RED);
    }

    public void hit() {
        this.setInactive();
        Game.updateScore();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        Mole clicked = (Mole) event.getSource();
        if (clicked.getIsActive()) {
            clicked.hit();
        }
    }
}
