import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList<ArrayList<Integer>> grid = new ArrayList<>();

        temp.add(1);
        temp.add(2);
        temp.add(3);
        grid.add(new ArrayList<>(temp));
        temp.clear();

        temp.add(4);
        temp.add(0);
        temp.add(6);
        grid.add(new ArrayList<>(temp));
        temp.clear();

        temp.add(7);
        temp.add(8);
        temp.add(5);
        grid.add(new ArrayList<>(temp));
        temp.clear();

        Arrangement arrangement = new Arrangement(grid);
        Puzzle source = new Puzzle(arrangement, new Position(2,2), Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);

        grid = new ArrayList<>();

        temp.add(1);
        temp.add(2);
        temp.add(3);
        grid.add(new ArrayList<>(temp));
        temp.clear();

        temp.add(4);
        temp.add(5);
        temp.add(6);
        grid.add(new ArrayList<>(temp));
        temp.clear();

        temp.add(7);
        temp.add(8);
        temp.add(0);
        grid.add(new ArrayList<>(temp));
        temp.clear();

    Arrangement dest = new Arrangement(grid);
    Puzzle destination = new Puzzle(dest, new Position(1,1), Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);

    AStarEngine engine = new AStarEngine(source, destination, 0);
    engine.tracePath();

    }
}