public class Edge {
    private int cost;
    private String label;

    public Edge(int cost, String label) {
        this.cost = cost;
        this.label = label;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "cost=" + cost +
                ", label='" + label + '\'' +
                '}';
    }
}
