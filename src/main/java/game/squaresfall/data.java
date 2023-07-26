package game.squaresfall;

public class data {

    public static final String name = "SquaresFall";

    public static final int width = 600;
    public static final int height = 600;
    public static final int TileSize = 50;

    public static final int FPS = 60;

    public static int[] x = new int[width/TileSize];

    public enum States {
        GAMEOVER,
        PLAYING,
        MENU
    };

    public static States current = States.MENU;

}
