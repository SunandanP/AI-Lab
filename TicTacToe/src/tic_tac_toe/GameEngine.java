package tic_tac_toe;

import tic_tac_toe.player.HumanPlayer;
import tic_tac_toe.player.SmartComputerPlayer;

public class GameEngine {
    private Board board;
    private final SmartComputerPlayer smartComputerPlayer;
    private final HumanPlayer humanPlayer;

    public GameEngine(String mySymbol) {
        humanPlayer = new HumanPlayer(mySymbol);
        smartComputerPlayer = new SmartComputerPlayer((mySymbol.equals("X")) ? "O" : "X");
        board = new Board();
    }

    public void startGame(){
        var mySymbol = (humanPlayer.getSymbol() == "O") ? "X" : "O";
        board.printBoard();
        while (true){
            board = humanPlayer.getMove(board);
            board.printBoard();
            if (board.checkWin(humanPlayer.getSymbol())){
                System.out.println("You win!");
                break;
            }
            if (board.getOccupied() == 9){
                System.out.println("It's a draw!");
                break;
            }
            board = smartComputerPlayer.getMove(board);
            board.printBoard();
            if (board.checkWin(mySymbol)){
                System.out.println("You lose!");
                break;
            }
            if (board.getOccupied() == 9){
                System.out.println("It's a draw!");
                break;
            }
        }
    }


}
