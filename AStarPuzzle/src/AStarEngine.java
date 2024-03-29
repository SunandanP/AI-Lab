import java.util.ArrayList;

public class AStarEngine {
  private ArrayList<Position> visited;
  private Puzzle source;
  private Puzzle destination;
  private int currentCount;
  private boolean reached;

  public AStarEngine(Puzzle source, Puzzle destination, int currentCount) {
    visited = new ArrayList<>();
    this.source = source;
    this.destination = destination;
    this.currentCount = currentCount;
    reached = false;
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
    if (!reached){
      puzzle.getArrangement().print(puzzle);
    }

    if (isVisited(new Position(puzzle.getBlankPosition().getX(), puzzle.getBlankPosition().getY()))){
      return;
    }

    if (puzzle.getHeuristic() == 0){
      System.out.println("Reached destination");
      puzzle.getArrangement().print(puzzle);
      reached = true;
      return;
    }

    visited.add(new Position(puzzle.getBlankPosition().getX(), puzzle.getBlankPosition().getY()));

    ArrayList<Puzzle> possibilities = new ArrayList<>();

    if (puzzle.swapUp()){
      Puzzle temp = new Puzzle(puzzle);
      initPuzzle(temp);
      if (!isVisited(temp.getBlankPosition())) {
        possibilities.add(temp);
      }
      puzzle.swapDown();
    }

    if (puzzle.swapDown()){
      Puzzle temp = new Puzzle(puzzle);
      initPuzzle(temp);
      if (!isVisited(temp.getBlankPosition())) {
        possibilities.add(temp);
      }
      puzzle.swapUp();
    }

    if (puzzle.swapLeft()){
      Puzzle temp = new Puzzle(puzzle);
      initPuzzle(temp);
      if (!isVisited(temp.getBlankPosition())) {
        possibilities.add(temp);
      }
      puzzle.swapRight();
    }

    if (puzzle.swapRight()){
      Puzzle temp = new Puzzle(puzzle);
      initPuzzle(temp);
      if (!isVisited(temp.getBlankPosition())) {
        possibilities.add(temp);
      }
      puzzle.swapLeft();
    }

    //find out minimum
    int min = Integer.MAX_VALUE;
    ArrayList<Puzzle> mins = new ArrayList<>();
    for (Puzzle possibility : possibilities) {
      if (possibility.getFScore() < min){
        min = possibility.getFScore();
      }
    }

    //add all minimum valued puzzles to an execution list
    for (Puzzle possibility : possibilities) {
      if (possibility.getFScore() == min){
        if (!isVisited(possibility.getBlankPosition()))
          mins.add(possibility);
      }
    }

    currentCount++;

    for(var x : mins){
      createPossibility(x);
    }
  }
}