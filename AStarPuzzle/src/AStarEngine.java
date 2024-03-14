import java.util.ArrayList;

public class AStarEngine {
  private ArrayList<Position> visited;
  private Puzzle source;
  private Puzzle destination;
  private int currentCount;

  public AStarEngine(Puzzle source, Puzzle destination, int currentCount) {
    visited = new ArrayList<>();
    this.source = source;
    this.destination = destination;
    this.currentCount = currentCount;
  }

  public ArrayList<Position> getVisited() {
    return visited;
  }

  public void setVisited(ArrayList<Position> visited) {
    this.visited = visited;
  }

  public int getCurrentCount() {
    return currentCount;
  }

  public void setCurrentCount(int currentCount) {
    this.currentCount = currentCount;
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

  public void initPuzzle(Puzzle puzzle){
    puzzle.setHeuristic(Puzzle.manhattanDistance(puzzle, destination));
    puzzle.setGScore(currentCount);
    puzzle.setFScore(puzzle.getHeuristic() + puzzle.getGScore());
    puzzle.setBlankPosition(puzzle.getArrangement().locateElement(0));
  }

  public void tracePath(){
    Puzzle temp = source;
    initPuzzle(temp);
    createPossibility(temp);
  }

  private boolean isVisited(Position position){
    for (int i = 0; i < visited.size(); i++) {
      Position current = visited.get(i);
      if(current.getX() == position.getX() && current.getY() == position.getY()){
        return true;
      }
    }

    return false;
  }


  public void createPossibility(Puzzle puzzle){
    puzzle.getArrangement().print(puzzle);
    if (puzzle.getArrangement().equals(destination.getArrangement()) || isVisited(new Position(puzzle.getBlankPosition().getX(), puzzle.getBlankPosition().getY()))){
      return;
    }

    visited.add(new Position(puzzle.getBlankPosition().getX(), puzzle.getBlankPosition().getY()));

    ArrayList<Puzzle> possibilities = new ArrayList<>();
//    ArrayList<Integer> outOfPositionElements = Puzzle.getOutOfPlaceElements(puzzle, destination);

    if (puzzle.swapUp()){
      Puzzle temp = new Puzzle(puzzle);
      initPuzzle(temp);
      possibilities.add(temp);
      puzzle.swapDown();
    }

    if (puzzle.swapDown()){
      Puzzle temp = new Puzzle(puzzle);
      initPuzzle(temp);
      possibilities.add(temp);
      puzzle.swapUp();
    }

    if (puzzle.swapLeft()){
      Puzzle temp = new Puzzle(puzzle);
      initPuzzle(temp);
      possibilities.add(temp);
      puzzle.swapRight();
    }

    if (puzzle.swapRight()){
      Puzzle temp = new Puzzle(puzzle);
      initPuzzle(temp);
      possibilities.add(temp);
      puzzle.swapLeft();
    }

    //find out minimum
    int min = possibilities.getFirst().getFScore();
    ArrayList<Puzzle> mins = new ArrayList<>();
    for (int i = 0; i < possibilities.size(); i++) {
      if (possibilities.get(i).getFScore() < min){
        min = possibilities.get(i).getFScore();
      }
    }

    //add all minimum valued puzzles to an execution list
    for (int i = 0; i < possibilities.size(); i++) {
      if (possibilities.get(i).getFScore() == min){
        if (!isVisited(possibilities.get(i).getBlankPosition()))
          mins.add(possibilities.get(i));
      }
    }

    currentCount++;

    for(var x : mins){
      createPossibility(x);
    }
  }
}