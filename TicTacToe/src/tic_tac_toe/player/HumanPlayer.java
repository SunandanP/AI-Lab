package tic_tac_toe.player;

import tic_tac_toe.Board;
import java.util.Scanner;

public class HumanPlayer extends Player {
    private static Scanner SCANNER;

    static {
        SCANNER = new Scanner(System.in);
    }

    public HumanPlayer(String symbol) {
        super(symbol);
    }


    public Board getMove(Board board){
        int input = 0;
        while (!(input <= 9 && input >= 1)){
            if (input != 0)
                System.out.println("Invalid input!");
            System.out.println("| 1 | 2 | 3 |");
            System.out.println("| 4 | 5 | 6 |");
            System.out.println("| 7 | 8 | 9 |");
            System.out.print("Choose one from above : ");
            input = SCANNER.nextInt();
        }

        board = new Board(board);
        if (this.symbol == "O")
            board.placeO(MAPPING.get(input).getI(), MAPPING.get(input).getJ());
        else
            board.placeX(MAPPING.get(input).getI(), MAPPING.get(input).getJ());
        return board;
    }
}
