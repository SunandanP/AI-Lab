package Astar8Puzzle;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InputInterface inputInterface = new InputInterface();
        inputInterface.inputInitiator();

        AStarEngine engine = new AStarEngine(0, inputInterface.a, inputInterface.b);
        engine.tracePath();
    }
}

class InputInterface{
    Puzzle a;
    Puzzle b;

    InputInterface(){
        a = new Puzzle();
        b = new Puzzle();
    }

    public void fillIn(Puzzle puzzle){
        Scanner sc = new Scanner(System.in);
        puzzle.print(false);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println("Row : " + i +" Column : "+ j + "=>" );
                puzzle.arrangement.modifyElement(new Position(i,j), sc.nextInt());
                puzzle.print(false);
            }
        }
    }

    public void inputInitiator(){
        System.out.println("Enter the Source Arrangement values : ");
        fillIn(a);
        System.out.println("Enter the Destination Arrangement values : ");
        fillIn(b);
        System.out.println("===== == Solution == ====");

        // As all the positions were filled by zero before, blankPosition would need to be recalibrated so that it shows the true position of blank Element.
        a.blankPosition = a.arrangement.locateElement(0);
        b.blankPosition = b.arrangement.locateElement(0);

    }
}
