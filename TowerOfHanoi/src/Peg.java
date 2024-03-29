import java.util.Stack;

public class Peg {
    private int label;
    private Stack<Disc> discs;

    public Peg(int label, Stack<Disc> discs) {
        this.label = label;
        this.discs = discs;
    }

    public int getLabel() {
        return label;
    }

    public void setLabel(int label) {
        this.label = label;
    }

    public Stack<Disc> getDiscs() {
        return discs;
    }

    public void setDiscs(Stack<Disc> discs) {
        this.discs = discs;
    }
}
