package game.squaresfall.gui;

import game.squaresfall.data;
import game.squaresfall.panel;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

public class menu implements KeyListener {

    Font TitleFont = new Font("Arial", Font.BOLD, 48);
    int TextWidth;

    Font StartGame = new Font("Arial", Font.BOLD, 32);
    int StartWidth;

    boolean invisibility = true;
    long ToggleTime = System.currentTimeMillis();

    public void draw(Graphics2D g) {

        TextWidth = g.getFontMetrics(TitleFont).stringWidth(data.name);
        StartWidth = g.getFontMetrics(StartGame).stringWidth("Press any key to start game!");

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, data.width, data.height);

        g.setColor(Color.WHITE);

        /*try {
            Font ka1 = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("assets/ka1.ttf"));
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }*/

        g.setFont(TitleFont);

        g.drawString(data.name, (data.width-TextWidth)/2, 100);


        g.setFont(StartGame);

        if (invisibility) {
            g.drawString("Press any key to start game!", (data.width-StartWidth)/2, 480);

        }

        if (ToggleTime < System.currentTimeMillis()){
            invisibility = !invisibility;
            ToggleTime += 600;
        }

        g.dispose();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Key pressed");
        if (data.current == data.States.MENU){
            data.current = data.States.PLAYING;
        } else if (data.current == data.States.GAMEOVER){
            data.current = data.States.MENU;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
