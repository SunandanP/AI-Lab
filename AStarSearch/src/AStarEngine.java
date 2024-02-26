import java.util.ArrayList;
import java.util.List;

public class AStarEngine {
    private List<Node> nodes;
    private static int count;

    private ArrayList<Node> graph;
    private String start;
    private String end;

    public AStarEngine() {
        graph = new ArrayList<>();
    }

    public AStarEngine(List<Node> nodes, String start, String end) {
        this.nodes = nodes;
        this.start = start;
        this.end = end;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public void init(){
        nodes = new ArrayList<>();
        var temp = new ArrayList<Edge>();
        temp.add(new Edge(6,"B"));
        temp.add(new Edge(3,"F"));
        graph.add(new Node("A",10,new ArrayList<>(temp)));
        temp.clear();

        temp.add(new Edge(3,"C"));
        temp.add(new Edge(2,"D"));
        graph.add(new Node("B",8, new ArrayList<>(temp)));
        temp.clear();

        temp.add(new Edge(1,"D"));
        temp.add(new Edge(5,"E"));
        graph.add(new Node("C",5, new ArrayList<>(temp)));
        temp.clear();

        temp.add(new Edge(1,"C"));
        temp.add(new Edge(8,"E"));
        graph.add(new Node("D",3, new ArrayList<>(temp)));
        temp.clear();

        temp.add(new Edge(5,"J"));
        temp.add(new Edge(5,"I"));
        graph.add(new Node("E",3, new ArrayList<>(temp)));
        temp.clear();

        temp.add(new Edge(3,"I"));
        graph.add(new Node("J",0, new ArrayList<>(temp)));
        temp.clear();

        temp.add(new Edge(1,"G"));
        temp.add(new Edge(7,"H"));
        graph.add(new Node("F",6, new ArrayList<>(temp)));
        temp.clear();

        temp.add(new Edge(3,"I"));
        graph.add(new Node("G",5, new ArrayList<>(temp)));
        temp.clear();

        temp.add(new Edge(2,"I"));
        graph.add(new Node("H",3, new ArrayList<>(temp)));
        temp.clear();

        temp.add(new Edge(3,"J"));
        temp.add(new Edge(5,"E"));
        graph.add(new Node("I",1, new ArrayList<>(temp)));
        temp.clear();

        count = 0;
    }

    public void display(){
        init();
        System.out.println(graph);
    }

    public int findNodeByLabel(String label){
        for (int i = 0; i < graph.size(); i++) {
            if (graph.get(i).getLabel().equals(label)){
                return i;
            }
        }
        return -1;
    }

    public int getEstimatedCost(int cost, int heuristic){
        return cost + heuristic;
    }

    public Node getNode(String label){
        return graph.stream().filter(node -> node.getLabel().equals(label)).findFirst().orElse(null);
    }

    public void tracePath(String source, String destination){
        init();
        ArrayList<Edge> tempMeasurements = new ArrayList<>();

        Node sourceNode = getNode(source);
        Node current = sourceNode;
        while (!current.getLabel().equals(destination)){
            nodes.add(current);
            for (int i = 0; i < current.getEdges().size(); i++) {
                count++;
                List<Edge> edges = current.getEdges();
                tempMeasurements.add(
                        new Edge(
                                getEstimatedCost(edges.get(i).getCost(), graph.get(findNodeByLabel(edges.get(i).getLabel())).getHeuristic()), edges.get(i).getLabel()));
            }

            Edge e = tempMeasurements.getFirst();

            for (int i = 0; i < tempMeasurements.size(); i++){
                System.out.println(tempMeasurements.get(i));
                if (e.getCost() > tempMeasurements.get(i).getCost()){
                    e = tempMeasurements.get(i);
                }
            }

            tempMeasurements.clear();

            current = graph.get(findNodeByLabel(e.getLabel()));

        }
        nodes.add(current);
        for (int i = 0; i < nodes.size() - 1; i++) {
            System.out.print(nodes.get(i).getLabel() + " -> ");
        }

        System.out.println(nodes.getLast().getLabel());

        System.out.println("Iterations performed : "+ count);

    }


}
