package game.squaresfall.gui;

import game.squaresfall.data;

import java.awt.*;

public class GameOver {

    Font GameOverFont = new Font("Arial", Font.BOLD, 58);
    int WidthFont;

    public void draw(Graphics2D g){

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, data.width, data.height);

        g.setColor(Color.WHITE);
        g.setFont(GameOverFont);

        WidthFont = g.getFontMetrics().stringWidth("Game Over");

        g.drawString("Game Over", (data.width-WidthFont)/2, 100);

        g.dispose();

    }

}
