import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> sourceGrid = new ArrayList<>();

        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(1);
        temp.add(2);
        temp.add(3);
        sourceGrid.add(new ArrayList<>(temp));
        temp.clear();
        temp.add(8);
        temp.add(0);
        temp.add(4);
        sourceGrid.add(new ArrayList<>(temp));
        temp.clear();
        temp.add(7);
        temp.add(6);
        temp.add(5);
        sourceGrid.add(new ArrayList<>(temp));
        temp.clear();


        ArrayList<ArrayList<Integer>> destinationGrid = new ArrayList<>();
        temp.add(8);
        temp.add(1);
        temp.add(3);
        destinationGrid.add(new ArrayList<>(temp));
        temp.clear();
        temp.add(0);
        temp.add(2);
        temp.add(4);
        destinationGrid.add(new ArrayList<>(temp));
        temp.clear();
        temp.add(7);
        temp.add(6);
        temp.add(5);
        destinationGrid.add(new ArrayList<>(temp));
        temp.clear();


        Puzzle source = new Puzzle(sourceGrid, new Position(1,1));
        Puzzle destination = new Puzzle(destinationGrid, new Position(0,1));

        source.setHeuristic(source.manhattanDistance(destination));
        source.setFScore(source.manhattanDistance(destination));

        AStarPuzzleEngine engine = new AStarPuzzleEngine(source, destination, 0);
        engine.findSolution();
    }
}