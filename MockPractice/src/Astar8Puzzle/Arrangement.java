package Astar8Puzzle;

import java.util.ArrayList;

public class Arrangement {
    ArrayList<ArrayList<Integer>> elements;

    public Arrangement(ArrayList<ArrayList<Integer>> elements) {
        this.elements = elements;
    }

    Arrangement(){
        elements = new ArrayList<>();
        var temp = new ArrayList<Integer>();
        temp.add(0);
        temp.add(0);
        temp.add(0);

        elements.add(new ArrayList<Integer>(temp));
        elements.add(new ArrayList<Integer>(temp));
        elements.add(new ArrayList<Integer>(temp));
    }

    Arrangement(Arrangement arrangement){
        this.elements = new ArrayList<>();

        elements.add(new ArrayList<>(arrangement.elements.get(0)));
        elements.add(new ArrayList<>(arrangement.elements.get(1)));
        elements.add(new ArrayList<>(arrangement.elements.get(2)));
    }

    public int accessElement(Position position){
        return elements.get(position.i).get(position.j);
    }

    public void modifyElement(Position position, int value){
        elements.get(position.i).set(position.j, value);
    }

    public Position locateElement(int val){
        for (int i = 0; i < elements.size(); i++) {
            for (int j = 0; j < elements.get(i).size(); j++) {
                Position currentPosition = new Position(i,j);

                if (accessElement(currentPosition) == val){
                    return currentPosition;
                }
            }
        }

        return new Position();// Returns invalid position as (-1, -1)
    }

    public void beautify(){
        System.out.println("-------------------------");
    }

    public void print(){
        beautify();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("|\t" + accessElement(new Position(i,j)) + "\t|");
            }
            System.out.println();
        }
        beautify();
    }
}
