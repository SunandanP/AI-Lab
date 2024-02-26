import java.util.ArrayList;
import java.util.List;

public class AStarEngine {
    private List<Node> nodes;

    private ArrayList<Node> queue;
    private String start;
    private String end;

    public AStarEngine() {
        queue = new ArrayList<>();
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
        var temp = new ArrayList<Edge>();
        temp.add(new Edge(11,"B"));
        temp.add(new Edge(11,"B"));
        temp.add(new Edge(11,"B"));
        temp.add(new Edge(11,"B"));
        temp.add(new Edge(11,"B"));
        queue.add(new Node("A",12, temp));
        queue.add(new Node("D",12, temp));
    }

    public void tracePath(){


        queue.remove(0);
        System.out.println(queue);
    }
}
