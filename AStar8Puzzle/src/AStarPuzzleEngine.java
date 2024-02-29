import java.util.ArrayList;

public class AStarPuzzleEngine {
    private Puzzle source;
    private Puzzle destination;
    private int current;

    public AStarPuzzleEngine(Puzzle source, Puzzle destination, int current) {
        this.source = source;
        this.destination = destination;
        this.current = current;
    }

    public AStarPuzzleEngine() {
    }

    public Puzzle getSource() {
        return source;
    }

    public void setSource(Puzzle source) {
        this.source = source;
    }

    public Puzzle getDestination() {
        return destination;
    }

    public void setDestination(Puzzle destination) {
        this.destination = destination;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public void findSolution(){
        createPossibility(source);
    }

    public void createPossibility(Puzzle puzzle){
        if (puzzle.getHeuristic() == 0){
            return;
        }

        puzzle.printPuzzle();

        ArrayList<Puzzle> memory = new ArrayList<>();
        if (puzzle.moveBlankDown()){
            memory.add(new Puzzle(puzzle));
            puzzle.moveBlankUp();
        }

        if (puzzle.moveBlankUp()){
            memory.add(new Puzzle(puzzle));
            puzzle.moveBlankDown();
        }

        if (puzzle.moveBlankLeft()){
            memory.add(new Puzzle(puzzle));
            puzzle.moveBlankRight();
        }

        if (puzzle.moveBlankRight()){
            memory.add(new Puzzle(puzzle));
            puzzle.moveBlankLeft();
        }


        for (var x : memory){
            x.setFScore(current + x.manhattanDistance(puzzle));
            x.setHeuristic(x.manhattanDistance(puzzle));
        }

        int min = memory.getFirst().getFScore();
        ArrayList<Puzzle> mins = new ArrayList<>();

        // append all minimum costing arrangements
        for (int i = 0; i < memory.size(); i++){
            if (min > memory.get(i).getFScore()){
                min = memory.get(i).getFScore();
            }
        }

        for (var x : memory){
            if (x.getFScore() == min){
                mins.add(x);
            }
        }

        // check if multiple paths exist
        for(var x : mins){
            createPossibility(x);
        }
    }
}
