package Tower_Of_Hanoi;

import java.util.Stack;

public class Peg {
    private Stack<Disc> discs;


    Peg(){
        discs = new Stack<>();
    }

    public Stack<Disc> getDiscs() {
        return discs;
    }

    public void setDiscs(Stack<Disc> discs) {
        this.discs = discs;
    }


    @Override
    public String toString() {
        return "Peg{" +
                "operator=" + discs +
                '}';
    }
}
