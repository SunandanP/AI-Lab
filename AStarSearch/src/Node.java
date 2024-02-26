import java.util.List;

public class Node {
    private String label;
    private int heuristic;
    private List<Edge> edges;

    public Node(String label, int heuristic, List<Edge> edges) {
        this.label = label;
        this.heuristic = heuristic;
        this.edges = edges;
    }

    public Node() {
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getHeuristic() {
        return heuristic;
    }

    public void setHeuristic(int heuristic) {
        this.heuristic = heuristic;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

    @Override
    public String toString() {
        return "Node{" +
                "label='" + label + '\'' +
                ", heuristic=" + heuristic +
                ", edges=" + edges +
                '}';
    }
}

