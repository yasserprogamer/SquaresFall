package game.squaresfall;

import com.sun.media.jfxmedia.events.PlayerEvent;
import game.squaresfall.gui.GameOver;
import game.squaresfall.gui.Playing;
import game.squaresfall.gui.menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Console;

public class panel extends JPanel implements Runnable {


    boolean Started = false;

    Thread gthread;

    int boxes = data.width/data.TileSize;

    private void gameStart() {

        int location = 0;

        for(int i = 0; i < boxes; i++){
            data.x[i] = location;
            location += data.TileSize;
        }

        gthread = new Thread(this);
        Started = true;
        gthread.start();

    }

    @Override
    public void run() {

        long interval = 1000/data.FPS;
        /*double delta = 0;
        long lastTime = System.nanoTime();*/
        long nextTime = System.currentTimeMillis();
        long elapsedTime;

        while (gthread != null){

            repaint();
            nextTime += interval;
            elapsedTime = nextTime - System.currentTimeMillis();
            try {
                Thread.sleep(elapsedTime);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }

            /*currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / interval;

            if (delta >= 1){
                repaint();
                delta--;
            }

            lastTime = currentTime;*/

        }

    }

    menu menu = new menu();
    Playing gameplay = new Playing();
    GameOver gameover = new GameOver();

    public panel(){
        this.setPreferredSize(new Dimension(data.width, data.height));
        setDoubleBuffered(true);

        addMouseListener(gameplay);
    }

    @Override
    public void paint(Graphics graphics) {

        Graphics2D g = (Graphics2D) graphics;
        if (data.current == data.States.MENU){
            menu.draw(g);
        } else if(data.current == data.States.PLAYING) {
            gameplay.draw(g);
        } else {
            gameover.draw(g);
        }

        if (!Started){
            gameStart();
        }

    }


}
