package Astar8Puzzle;

public class Position {
    int i;
    int j;

    public Position(){
        this.i = -1;
        this.j = -1;
    }

    public Position(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public Position(Position position){
        this.i = position.i;
        this.j = position.j;
    }
}
