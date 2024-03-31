package tic_tac_toe;

import java.util.ArrayList;

public class Board {
    private final String[][] arrangement;
    private int occupied;

    public Board() {
        occupied = 0;
        arrangement = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++){
                arrangement[i][j] = "-";
            }
        }
    }

    public Board(Board board) {
        this.occupied = 0;
        this.arrangement = new Board().arrangement;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arrangement[i][j] = board.arrangement[i][j];
                if (arrangement[i][j] != "-"){
                    this.occupied++;
                }
            }
        }
    }

    public int getOccupied() {
        return occupied;
    }

    public void beautify(){
        System.out.println("=========================");
    }

    public void printBoard(){
        beautify();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++){
                if (j == 0)
                    System.out.print("|\t");
                System.out.print(arrangement[i][j] + "\t");

                System.out.print("|\t");
            }
            System.out.println();
        }
        beautify();
    }
    public void placeX(int i, int j){
        arrangement[i][j] = "X";
        occupied++;

    }

    public void placeO(int i, int j){
        arrangement[i][j] = "O";
        occupied++;

    }
    public void unplaceX(int i, int j){
        arrangement[i][j] = "-";
        occupied--;
    }

    public void unplaceO(int i, int j){
        arrangement[i][j] = "-";
        occupied--;
    }

    public void placeSymbol(int i, int j, String symbol){
        if (symbol == "X")
            placeX(i,j);
        else
            placeO(i,j);
    }

    public void removeSymbol(int i, int j){
        unplaceX(i,j);
    }


    public boolean checkWin(String symbol){
        boolean row = false, col = false, diagonal = false;
        for (int i = 0; i < 3; i++) {
            //row
            if ( arrangement[i][0] == symbol &&
                    arrangement[i][0] == arrangement[i][1] &&
                    arrangement[i][1] == arrangement[i][2]){
                row = true;
            }

            if ( arrangement[0][i] == symbol &&
                    arrangement[0][i] == arrangement[1][i] &&
                    arrangement[1][i] == arrangement[2][i]){
                col = true;
            }

            if (arrangement[0][0] == symbol &&
                arrangement[1][1] == arrangement[0][0] &&
                arrangement[1][1] == arrangement[2][2]){
                diagonal = true;
            }

            if (arrangement[0][2] == symbol &&
                    arrangement[1][1] == arrangement[0][2] &&
                    arrangement[1][1] == arrangement[2][0]){
                diagonal = true;
            }

        }

        return (row || col || diagonal);
    }

    public ArrayList<Integer> availableMoves(){
        var list = new ArrayList<Integer>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (arrangement[i][j] == "-"){
                    // converts i,j format to 1-9 format
                    list.add(i*3 + j + 1);
                }
            }
        }

        return list;
    }
}
