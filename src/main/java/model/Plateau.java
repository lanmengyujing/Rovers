package model;

public class Plateau {

    private int posX;
    private int posY;

    public Plateau(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public boolean isOutRange(int x, int y) {
        return !(x >= 0 && y >= 0 && (x <= posX) && (y <= posY));
    }
}
