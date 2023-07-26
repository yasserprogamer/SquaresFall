package game.squaresfall.gui;

import game.squaresfall.data;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;

public class Playing implements MouseListener {

    int speed = 4;
    int misses = 0;
    int elimination = 5;
    int points = 0;
    int amount = 2;
    int boxes = data.width/data.TileSize;

    Map<Integer, Integer> squares = new HashMap<>();

    public void draw(Graphics2D g){

        if (misses >= elimination){

            misses = 0;
            points = 0;
            speed = 4;
            amount = 2;
            squares.clear();
            data.current = data.States.GAMEOVER;
        }

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, data.width, data.height);

        g.setColor(Color.WHITE);

        if (points > 56){
            if (elimination < 10)
                elimination += 3;
        } else if (points > 45){
            amount = 13;
        } else if (points > 30){
            if (elimination < 7)
                elimination += 2;
        } else if (points > 15){
            amount = 10;
        } else if (points > 6) {
            amount = 5;
        }

        if (squares.size() == 0){
            int startpoint = -60;
            for (int i = 0; i < amount; i++){
                squares.put(new Random().nextInt(boxes-1), startpoint);
                startpoint -= new Random().nextInt(100)+data.TileSize;
            }
        }

        for(int i = 0; i < boxes; i++){
            g.setColor(Color.WHITE);
            g.drawLine(data.x[i], 0, data.x[i], data.height);
            if (squares.get(i) != null){
                int y = squares.get(i);
                g.setColor(Color.RED);
                g.fillRect(data.x[i], y, data.TileSize, data.TileSize);
                y += speed;
                squares.replace(i, y);
                if (y > data.width){
                    misses += 1;
                    squares.remove(i, y);
                }
            }

        }

        g.setColor(Color.yellow);
        g.setFont(new Font("Arial", Font.PLAIN, 16));
        g.drawString("Points: "+points, 4, 18);
        if (misses > 0){
            g.setColor(Color.RED);
            g.drawString("Misses: "+misses+"/"+elimination, 4, 36);
        }
        g.dispose();

    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        double cx = e.getPoint().getX();
        double cy = e.getPoint().getY();
        Set<Map.Entry<Integer, Integer>> places = squares.entrySet();
        for (Map.Entry<Integer, Integer> place : places) {
            int qx = place.getKey();
            int qy = place.getValue();
            if (cx >= data.x[qx] && cx < (data.x[qx] + data.TileSize)){
                if (cy >= qy && cy <= qy+data.TileSize){
                    points += 1;
                    switch (points){
                        case 8:
                        case 14:
                        case 23:
                        case 32:
                        case 45:
                        case 53:
                        case 68:
                        case 77:
                        case 91:
                        case 100:
                            speed++;
                    }
                    squares.remove(qx, qy);
                }
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
