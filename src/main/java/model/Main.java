package model;


public class Main {
    public static void main(String[] args) {
        Game marsRoverGame = new Game();
        marsRoverGame.initPlateau();
        while (true) {
            marsRoverGame.start();
        }
    }
}
