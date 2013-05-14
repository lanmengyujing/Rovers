package model;


public class Main {
    public static void main(String[] args) {
        Client marsRoverClient = new Client();
        marsRoverClient.initPlateau();
        while (true) {
            marsRoverClient.start();
        }
    }
}
