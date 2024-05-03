package Astar8Puzzle;

import java.util.ArrayList;

public class AStarEngine {
    int currentCount;
    Puzzle source;
    Puzzle destination;
    ArrayList<Position> visited;

    public AStarEngine(int currentCount, Puzzle source, Puzzle destination) {
        this.currentCount = currentCount;
        this.source = source;
        this.destination = new Puzzle(destination);
        this.visited = new ArrayList<>();
    }

    private boolean isVisited(Position position){
        return this.visited.stream().anyMatch(pos -> pos.i == position.i && pos.j == position.j);
    }

    public void tracePath(){
        createPossibilities(source);
    }

    public void createPossibilities(Puzzle puzzle){
        if (isVisited(puzzle.blankPosition)){
            return;
        }

        if (puzzle.HScore == 0){
            System.out.println("Puzzle Solved!");
            puzzle.print(true);
            return;
        }
        else{
            if (currentCount != 0)
                puzzle.print(true);
            else
                puzzle.print(false);
        }


        visited.add(new Position(puzzle.blankPosition));
        // creation of possibilities
        Puzzle temp;
        ArrayList<Puzzle> possibilities = new ArrayList<>();

        if (puzzle.swapUp()){
            if (!isVisited(puzzle.blankPosition)){
                temp = new Puzzle(puzzle);
                temp.init(destination, currentCount);
                possibilities.add(temp);
            }
            puzzle.swapDown();
        }

        if (puzzle.swapDown()){
            if (!isVisited(puzzle.blankPosition)){
                temp = new Puzzle(puzzle);
                temp.init(destination, currentCount);
                possibilities.add(temp);
            }
            puzzle.swapUp();
        }

        if (puzzle.swapLeft()){
            if (!isVisited(puzzle.blankPosition)){
                temp = new Puzzle(puzzle);
                temp.init(destination, currentCount);
                possibilities.add(temp);
            }
            puzzle.swapRight();
        }

        if (puzzle.swapRight()){
            if (!isVisited(puzzle.blankPosition)){
                temp = new Puzzle(puzzle);
                temp.init(destination, currentCount);
                possibilities.add(temp);
            }
            puzzle.swapLeft();
        }

        ArrayList<Puzzle> mins = new ArrayList<>();
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < possibilities.size(); i++) {
            if (min > possibilities.get(i).FScore){
                min = possibilities.get(i).FScore;

            }
        }

        for (int i = 0; i < possibilities.size(); i++) {
            if (possibilities.get(i).FScore == min && !isVisited(possibilities.get(i).blankPosition)){
                mins.add(possibilities.get(i));
            }
        }

        currentCount++;

        for (var x : mins)
            createPossibilities(x);

    }
}
