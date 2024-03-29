import java.util.ArrayList;
import java.util.Stack;

public class HanoiEngine {
    private ArrayList<Peg> pegs;
    private int discCount;

    public HanoiEngine(int discCount) {
        this.pegs = new ArrayList<>();
        for (int i = 0; i < 3; i++ )
            pegs.add(new Peg(i + 1, new Stack<>()));
        this.discCount = discCount;

        for (int i = 0; i < discCount; i++){
            pegs.getFirst().getDiscs().push(new Disc(discCount - i));
        }
    }

    public ArrayList<Peg> getPegs() {
        return pegs;
    }

    public void setPegs(ArrayList<Peg> pegs) {
        this.pegs = pegs;
    }

    public int getDiscCount() {
        return discCount;
    }

    public void setDiscCount(int discCount) {
        this.discCount = discCount;
    }

    private void beautify(){
        System.out.println("=========");
    }

    private void printState(){
        Stack<Disc> one = pegs.get(0).getDiscs(), two = pegs.get(1).getDiscs(), three = pegs.get(2).getDiscs();
        int size1 = one.size();
        int size2 = two.size();
        int size3 = three.size();

        beautify();
        System.out.println("A\tB\tC");

        beautify();
        for (int i = discCount; i >= 1; i--){
            System.out.print(((size1 >= i) ? one.get(i-1).getLabel() : "|"));
            System.out.print("\t");
            System.out.print(((size2 >= i) ? two.get(i-1).getLabel() : "|"));
            System.out.print("\t");
            System.out.print(((size3 >= i) ? three.get(i-1).getLabel() : "|"));
            System.out.println();
        }
        beautify();

    }

    public void solveHanoi(){
        printState();
        createPath(discCount, pegs.getFirst(), pegs.get(1), pegs.get(2));
    }

    private void createPath(int discs, Peg peg1, Peg peg2, Peg peg3){
        if (discs > 0){
            createPath(discs - 1, peg1, peg3, peg2);
            Disc removed = peg1.getDiscs().pop();
            peg3.getDiscs().push(removed);
            printState();
            createPath(discs - 1, peg2, peg1, peg3);
        }
    }
}
