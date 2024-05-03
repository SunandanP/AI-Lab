package Tower_Of_Hanoi;

public class Disc {
    private int label;

    public Disc(int label) {
        this.label = label;
    }

    public int getLabel() {
        return label;
    }

    public void setLabel(int label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "Disc{" +
                "label=" + label +
                '}';
    }
}
