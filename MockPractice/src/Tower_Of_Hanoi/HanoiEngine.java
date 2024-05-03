package Tower_Of_Hanoi;

import java.util.ArrayList;

public class HanoiEngine {
    ArrayList<Peg> pegs;
    int discCount;

    public HanoiEngine(int discCount) {
        this.discCount = discCount;
        pegs = new ArrayList<>();

        for (int i = 0; i < discCount; i++)
            pegs.add(new Peg());

        for (int i = 0; i < discCount; i++)
            pegs.getFirst().getDiscs().push(new Disc(discCount - i));

    }

    private void createHanoiSolution(int discCount, Peg source, Peg auxiliary, Peg destination){
        if (discCount > 0){
            createHanoiSolution(discCount - 1, source, destination, auxiliary);
            var temp = source.getDiscs().pop();
            destination.getDiscs().push(temp);
            printState();
            createHanoiSolution(discCount - 1, auxiliary, source, destination);
        }
    }

    public void solve(){
        printState();
        createHanoiSolution(discCount, pegs.getFirst(), pegs.get(1), pegs.get(2));
    }

    private void printState(){
        var one = pegs.getFirst().getDiscs();
        var two = pegs.get(1).getDiscs();
        var three = pegs.get(2).getDiscs();

        for (int i = discCount; i >= 1; i--){
            System.out.print(((one.size() >= i) ? one.get(i-1).getLabel() : "|"));
            System.out.print("\t");
            System.out.print(((two.size() >= i) ? two.get(i-1).getLabel() : "|"));
            System.out.print("\t");
            System.out.print(((three.size() >= i) ? three.get(i-1).getLabel() : "|"));
            System.out.println();
        }
        System.out.println();
    }
}
