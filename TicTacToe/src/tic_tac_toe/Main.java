package tic_tac_toe;

import tic_tac_toe.player.HumanPlayer;

public class Main {
    public static void main(String[] args) {
        GameEngine gameEngine = new GameEngine("X");
        gameEngine.startGame();
    }
}
