package WhackAMole;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.ImageIcon;

public class Mole extends JButton implements ActionListener {

    private static final long serialVersionUID = 1L;
    private boolean isActive;


    ImageIcon mole = new ImageIcon("/Users/Lily/Desktop/59866.png");
    ImageIcon plusone = new ImageIcon("/Users/Lily/Desktop/white_and_blue_twitter.jpg");

    public Mole() {
        this.setInactive();
        addActionListener(this);
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setInactive() {

        this.isActive = false;
    }

    public void setActive() {

        this.isActive = true;
        this.setIcon(mole);
    }

    public void hit() {
        this.isActive=false;
        this.setIcon(plusone);
        Control.updateScore();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        Mole clicked = (Mole) event.getSource();
        if (clicked.getIsActive()) {
            clicked.hit();
        }
    }
}
