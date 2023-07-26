package game.squaresfall;

import game.squaresfall.gui.Playing;
import game.squaresfall.gui.menu;

import javax.swing.*;
import java.awt.*;

public class frame extends JFrame {

    panel panel;

    public frame(){

        panel = new panel();

        setTitle("SquaresFall");
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        addKeyListener(new menu());

        this.add(panel);
        pack();

    }

}
