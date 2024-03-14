import java.util.ArrayList;

public class Puzzle {
    private Arrangement arrangement;
    private Position blankPosition;
    private int heuristic;
    private int gScore;
    private int fScore;

    public Puzzle(){
        arrangement = new Arrangement();
        blankPosition = new Position();
        heuristic = Integer.MAX_VALUE;
        gScore = Integer.MAX_VALUE;
        fScore = Integer.MAX_VALUE;
    }

    public Puzzle(Arrangement arrangement, Position blankPosition, int heuristic, int gScore, int fScore) {
        this.arrangement = arrangement;
        this.blankPosition = blankPosition;
        this.heuristic = heuristic;
        this.gScore = gScore;
        this.fScore = fScore;
    }

    public Puzzle(Puzzle puzzle){
        this.fScore = puzzle.fScore;
        this.gScore = puzzle.gScore;
        this.arrangement = new Arrangement(puzzle.arrangement);
        this.blankPosition = new Position(puzzle.blankPosition.getX(), puzzle.blankPosition.getY());
        this.heuristic = puzzle.heuristic;
    }

    private void swap(Direction direction){
        int differentiator = 0;
        boolean changeX = false;
        if (direction == Direction.UP){
            differentiator = -1;
            changeX = true;
        } else if (direction == Direction.DOWN) {
            differentiator = +1;
            changeX = true;
        } else if (direction == Direction.LEFT) {
            differentiator = -1;
            changeX = false;
        } else if (direction == Direction.RIGHT) {
            differentiator = +1;
            changeX = false;
        }
        int temp;
        Position pos = blankPosition;
        if (changeX){
            temp = arrangement.accessElement(pos.getX() + differentiator, pos.getY());
            arrangement.modifyElement(pos.getX() + differentiator, pos.getY(), 0);
            arrangement.modifyElement(pos.getX(), pos.getY(), temp);
            pos.setX(pos.getX() + differentiator);
        }
        else{
            temp = arrangement.accessElement(pos.getX(), pos.getY() + differentiator);
            arrangement.modifyElement(pos.getX() , pos.getY() + differentiator, 0);
            arrangement.modifyElement(pos.getX(), pos.getY(), temp);
            pos.setY(pos.getY() + differentiator);
        }

    }

    public boolean swapUp(){
        if (blankPosition.getX() == 0){
            return false;
        }
        else{
            swap(Direction.UP);
            return true;
        }
    }

    public boolean swapDown(){
        if (blankPosition.getX() == 2){
            return false;
        }
        else{
            swap(Direction.DOWN);
            return true;
        }
    }

    public boolean swapLeft(){
        if (blankPosition.getY() == 0){
            return false;
        }
        else{
            swap(Direction.LEFT);
            return true;
        }
    }

    public boolean swapRight(){
        if (blankPosition.getY() == 2){
            return false;
        }
        else{
            swap(Direction.RIGHT);
            return true;
        }
    }

    public static ArrayList<Integer> getOutOfPlaceElements(Puzzle a, Puzzle b){
        int size = 3;
        int dx, dy, total = 0;
        Position posA, posB;
        ArrayList<Integer> elements = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            posA = a.arrangement.locateElement(i);
            posB = b.arrangement.locateElement(i);

            dx = Math.abs(posA.getX() - posB.getX());
            dy = Math.abs(posA.getY() - posB.getY());

            total = (dx + dy);

            if (total != 0){
                elements.add(i);
            }
        }

        return elements;
    }


    public static int manhattanDistance(Puzzle a, Puzzle b){
        int size = 3;
        int dx, dy, total = 0;
        Position posA, posB;
        for (int i = 0; i < 9; i++) {
            posA = a.arrangement.locateElement(i);
            posB = b.arrangement.locateElement(i);

            dx = Math.abs(posA.getX() - posB.getX());
            dy = Math.abs(posA.getY() - posB.getY());

            total += (dx + dy);
        }

        return total;
    }

    public Arrangement getArrangement() {
        return arrangement;
    }

    public void setArrangement(Arrangement arrangement) {
        this.arrangement = arrangement;
    }

    public Position getBlankPosition() {
        return blankPosition;
    }

    public void setBlankPosition(Position blankPosition) {
        this.blankPosition = blankPosition;
    }

    public int getHeuristic() {
        return heuristic;
    }

    public void setHeuristic(int heuristic) {
        this.heuristic = heuristic;
    }

    public int getGScore() {
        return gScore;
    }

    public void setGScore(int gScore) {
        this.gScore = gScore;
    }

    public int getFScore() {
        return fScore;
    }

    public void setFScore(int fScore) {
        this.fScore = fScore;
    }




    @Override
    public String toString() {
        return "Puzzle{" +
                "arrangement=" + arrangement +
                ", blankPosition=" + blankPosition +
                ", heuristic=" + heuristic +
                ", gScore=" + gScore +
                ", fScore=" + fScore +
                '}';
    }
}
