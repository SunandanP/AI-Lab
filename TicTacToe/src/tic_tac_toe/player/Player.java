package tic_tac_toe.player;

import tic_tac_toe.Board;
import tic_tac_toe.Position;

import java.util.HashMap;

public class Player {
    protected String symbol;

    protected static HashMap<Integer, Position> MAPPING;

    static {
        MAPPING = new HashMap<>();
        MAPPING.put(1, new Position(0,0));
        MAPPING.put(2, new Position(0,1));
        MAPPING.put(3, new Position(0,2));
        MAPPING.put(4, new Position(1,0));
        MAPPING.put(5, new Position(1,1));
        MAPPING.put(6, new Position(1,2));
        MAPPING.put(7, new Position(2,0));
        MAPPING.put(8, new Position(2,1));
        MAPPING.put(9, new Position(2,2));
    }

    public Player(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Board getMove(Board board){
        return new Board(board);
    }
}
