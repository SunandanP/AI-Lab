package tic_tac_toe.player;

import tic_tac_toe.Board;
import tic_tac_toe.Decision;

import java.util.Random;

public class SmartComputerPlayer extends Player{
    public SmartComputerPlayer(String symbol) {
        super(symbol);
    }

    public Board getMove(Board currentConfig){
        int choice;
        Board board = new Board(currentConfig);
        if (currentConfig.getOccupied() == 0){
            Random random = new Random();
            choice = random.nextInt(1,9);
            if(this.getSymbol() == "X") {
                board.placeX(MAPPING.get(choice).getI(), MAPPING.get(choice).getJ());
            }
            else
                board.placeO(MAPPING.get(choice).getI(), MAPPING.get(choice).getJ());
        }
        else {
            choice = miniMax(currentConfig, this.symbol).getPosition();
            if(symbol == "X") {
                board.placeX(MAPPING.get(choice).getI(), MAPPING.get(choice).getJ());
            }
            else
                board.placeO(MAPPING.get(choice).getI(), MAPPING.get(choice).getJ());
        }

        return board;

    }



    private Decision miniMax(Board state, String player) {
        String maxPlayer = this.getSymbol();
        String otherPlayer = maxPlayer.equals("X") ? "O" : "X";
        Decision best;

        // IF last move resulted in human's win
        if (state.checkWin(otherPlayer)) {
            return new Decision( -1,  1 * (state.getOccupied() + 1));
        }

        // IF there are no spaces left
        else if (state.getOccupied() == 9) {
            return new Decision( -1,  0);
        }

        // IF player is computer
        if (player.equals(maxPlayer)) {
            best = new Decision(-1, Integer.MIN_VALUE);
        }

        // IF player is human
        else {
            best = new Decision(-1, Integer.MAX_VALUE);;
        }

        // For all the possible moves we tryout all the possible configs and evaluate them and select the best out of them
        for (int possibleMove : state.availableMoves()) {
            state.placeSymbol(MAPPING.get(possibleMove).getI(), MAPPING.get(possibleMove).getJ(), player);
            Decision simScore = miniMax(state, otherPlayer);
            state.removeSymbol(MAPPING.get(possibleMove).getI(), MAPPING.get(possibleMove).getJ());

            simScore.setPosition(possibleMove);

            if (player.equals(maxPlayer) && simScore.getScore() > best.getScore()) {
                best = simScore;
            } else if (!player.equals(maxPlayer) && simScore.getScore() <  best.getScore()) {
                best = simScore;
            }
        }

        return best;
    }
}
