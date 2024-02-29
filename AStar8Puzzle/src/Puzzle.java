import java.util.ArrayList;

public class Puzzle {
    ArrayList<ArrayList<Integer>> grid;
    private Position blankPosition;
    private int fScore;

    private int heuristic;

    public Puzzle(ArrayList<ArrayList<Integer>> grid, Position blankPosition){
        this.grid = grid;
        this.blankPosition = blankPosition;
        fScore = 0;
        heuristic = 0;
    }

    public Puzzle(Puzzle puzzle){
        this.grid = puzzle.grid;
        this.blankPosition = puzzle.blankPosition;
        this.fScore = puzzle.fScore;
        this.heuristic = puzzle.heuristic;
    }

    public Puzzle(ArrayList<ArrayList<Integer>> grid, Position blankPosition, int current, Puzzle source) {
        this.grid = grid;
        this.blankPosition = blankPosition;
        this.heuristic = manhattanDistance(source);
        this.fScore = manhattanDistance(source) + current;
    }

    public Puzzle(ArrayList<ArrayList<Integer>> grid, Position blankPosition, Puzzle source) {
        this.grid = grid;
        this.blankPosition = blankPosition;
        this.heuristic = manhattanDistance(source);
        this.fScore = manhattanDistance(source);
    }

    public ArrayList<ArrayList<Integer>> getGrid() {
        return grid;
    }

    public void setGrid(ArrayList<ArrayList<Integer>> grid) {
        this.grid = grid;
    }

    public Puzzle() {
        grid = new ArrayList<>();
        for (int i = 0; i < 3; i++)
            grid.add(new ArrayList<>());

        blankPosition = new Position();
        fScore = 100_000_000;
    }


    public int getHeuristic() {
        return heuristic;
    }

    public void setHeuristic(int heuristic) {
        this.heuristic = heuristic;
    }

    public Position getBlankPosition() {
        return blankPosition;
    }

    public void setBlankPosition(Position blankPosition) {
        this.blankPosition = blankPosition;
    }

    public int getFScore() {
        return fScore;
    }

    public void setFScore(int fScore) {
        this.fScore = fScore;
    }

    public Position getPosition(int val){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (val == grid.get(i).get(j)){
                    return new Position(i,j);
                }
            }
        }
        return new Position();
    }

    public int manhattanDistance(Puzzle a){
        int dx, dy, total = 0;
        for (int i = 0; i < 9; i++){
            dx = Math.abs(a.getPosition(i).getX() - this.getPosition(i).getX());
            dy = Math.abs(a.getPosition(i).getY() - this.getPosition(i).getY());
            total = dx + dy;
        }

        return total;
    }

    public void setValue(int x, int y, int val){
        var temp = grid.get(x);
        temp.set(y, val);
        grid.set(x, temp);
    }

    public boolean moveBlankUp(){
        if (blankPosition.getY() == 0){
            return false;
        }
        else{
            int temp = grid.get(blankPosition.getX()).get(blankPosition.getY() - 1);
            setValue(blankPosition.getX(), blankPosition.getY(), temp);
            setValue(blankPosition.getX(), blankPosition.getY() - 1, 0);
            return true;
        }
    }

    public boolean moveBlankDown(){
        if (blankPosition.getY() == 2){
            return false;
        }
        else{
            int temp = grid.get(blankPosition.getX()).get(blankPosition.getY() + 1);
            setValue(blankPosition.getX(), blankPosition.getY(), temp);
            setValue(blankPosition.getX(), blankPosition.getY() + 1, 0);
            return true;
        }
    }

    public boolean moveBlankLeft(){
        if (blankPosition.getX() == 0){
            return false;
        }
        else{
            int temp = grid.get(blankPosition.getX() - 1).get(blankPosition.getY());
            setValue(blankPosition.getX(), blankPosition.getY(), temp);
            setValue(blankPosition.getX() - 1, blankPosition.getY(), 0);
            return true;
        }
    }

    public boolean moveBlankRight(){
        if (blankPosition.getX() == 2){
            return false;
        }
        else{
            int temp = grid.get(blankPosition.getX() + 1).get(blankPosition.getY());
            setValue(blankPosition.getX(), blankPosition.getY(), temp);
            setValue(blankPosition.getX() + 1, blankPosition.getY(), 0);
            return true;
        }
    }

    public void printPuzzle(){
        for (int i = 0; i < 3; i++ ){
            for (int j = 0; j < 3; j++){
                System.out.print(" " + grid.get(i).get(j) + "|");
            }
            System.out.println();
        }
    }
}

