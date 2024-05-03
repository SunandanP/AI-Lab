package Astar8Puzzle;

import java.security.DigestException;

public class Puzzle {
    Arrangement arrangement;
    Position blankPosition;
    int GScore;
    int HScore;
    int FScore;

    public Puzzle(){
        arrangement = new Arrangement();
        blankPosition = arrangement.locateElement(0);
        GScore = Integer.MAX_VALUE;
        FScore = Integer.MAX_VALUE;
        HScore = Integer.MAX_VALUE;
    }

    public Puzzle(Arrangement arrangement, int GScore, int HScore, int FScore) {
        this.arrangement = arrangement;
        this.blankPosition = arrangement.locateElement(0);
        this.GScore = GScore;
        this.HScore = HScore;
        this.FScore = FScore;
    }

    public Puzzle(Puzzle puzzle){
        this.arrangement = new Arrangement(puzzle.arrangement);
        this.blankPosition = new Position(puzzle.blankPosition.i, puzzle.blankPosition.j);
        this.GScore = puzzle.GScore;
        this.HScore = puzzle.HScore;
        this.FScore = puzzle.FScore;
    }

    public static int manhattanDistance(Puzzle a, Puzzle b){
        int dx, dy, total = 0;

        Position posA, posB;
        for (int i = 0; i < 9; i++) {
            posA = a.arrangement.locateElement(i);
            posB = b.arrangement.locateElement(i);

            dx = Math.abs(posA.i - posB.i);
            dy = Math.abs(posA.j - posB.j);

            total += (dx + dy);
        }
        return total;
    }

    public void swap(Direction direction){
        boolean changeHorizontally = false;
        int differentiator = 0;

        if (direction == Direction.UP){
            differentiator = -1;
            changeHorizontally = true;
        }

        if (direction == Direction.DOWN){
            differentiator = +1;
            changeHorizontally = true;
        }

        if (direction == Direction.LEFT){
            differentiator = -1;
            changeHorizontally = false;
        }

        if (direction == Direction.RIGHT){
            differentiator = +1;
            changeHorizontally = false;
        }

        Position position;

        if (changeHorizontally)
            position = new Position(blankPosition.i + differentiator, blankPosition.j);

        else
            position = new Position(blankPosition.i, blankPosition.j + differentiator);

        int temp = arrangement.accessElement(position);
        arrangement.modifyElement(position, 0);
        arrangement.modifyElement(blankPosition, temp);
        blankPosition = position;
    }

    public boolean swapUp(){
        if (blankPosition.i == 0)
            return false;

        else {
            swap(Direction.UP);
            return true;
        }
    }

    public boolean swapDown(){
        if (blankPosition.i == 2)
            return false;

        else {
            swap(Direction.DOWN);
            return true;
        }
    }

    public boolean swapLeft(){
        if (blankPosition.j == 0)
            return false;

        else{
            swap(Direction.LEFT);
            return true;
        }
    }

    public boolean swapRight(){
        if (blankPosition.j == 2)
            return false;

        else {
            swap(Direction.RIGHT);
            return true;
        }
    }

    public void init(Puzzle puzzle,int GScore){
        this.HScore = manhattanDistance(this, puzzle);
        this.GScore = GScore;
        this.FScore = this.GScore + this.HScore;
        this.blankPosition = this.arrangement.locateElement(0);
    }

    public void beautify(){
        System.out.println("-------------------------");
    }

    public void print(boolean info){
        if (info){
            beautify();
            System.out.println("Heuristic value : " + HScore);
            System.out.println("Goal value : " + GScore);
            System.out.println("Final value : " + FScore);
            beautify();
        }

        arrangement.print();
    }
}
