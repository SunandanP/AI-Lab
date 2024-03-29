import java.util.ArrayList;

public class RoutingEngine {
    private DistanceTable distanceTable;

    private ArrayList<ArrayList<Integer>> paths;
    public RoutingEngine(DistanceTable distanceTable) {
        this.distanceTable = distanceTable;
        this.paths = new ArrayList<>();
    }

    public DistanceTable getDistanceTable() {
        return distanceTable;
    }

    public void setDistanceTable(DistanceTable distanceTable) {
        this.distanceTable = distanceTable;

    }

    public ArrayList<ArrayList<Integer>> getPaths() {
        return paths;
    }

    public void setPaths(ArrayList<ArrayList<Integer>> paths) {
        this.paths = paths;
    }

    public RoutingEngine() {
        distanceTable = new DistanceTable();
        this.paths = new ArrayList<>();
    }

    public int getMinimum(int i, ArrayList<Integer> distances){
        int size = distanceTable.getDistances()[i].length;
        int[][] arr = distanceTable.getDistances();
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int j = 0; j < size; j++) {
            if (arr[i][j] < min && !distances.contains(j)){
                min = arr[i][j];
                minIndex = j;
            }
        }

        return minIndex;
    }

    public void createPaths(){
        for (int i = 0; i < distanceTable.getDistances().length; i++){
            ArrayList<Integer> visited = new ArrayList<>();
            ArrayList<Integer> path = new ArrayList<>();
            visited.add(i);
            path.add(i);
            int next = i;
            while (visited.size() < distanceTable.getDistances().length){
                next = getMinimum(next, visited);
                visited.add(next);
                path.add(next);
            }
            path.add(i);
            paths.add(path);

        }
        calculateCosts();



    }

    public int getCost(int i, int j){
        return distanceTable.getDistances()[i][j];
    }

    public void calculateCosts(){
        int[][] arr = distanceTable.getDistances();
        ArrayList<Integer> costs = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            costs.add(0);
        }

        for (int i = 0; i < paths.size(); i++) {
            for (int j = 0; j < paths.get(i).size(); j++) {
                var path = paths.get(i);
                if (j + 1 < path.size() && getCost(path.get(j), path.get(j + 1)) != Integer.MAX_VALUE){
                    costs.set(i, costs.get(i) + getCost(path.get(j), path.get(j + 1)));

                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < costs.size(); i++){
            if (costs.get(i) < min){
                min = costs.get(i);
            }
            System.out.println(paths.get(i) + " : " + costs.get(i));
        }

        int finalMin = min;
        System.out.println("Selected path : "+ paths.get(costs.indexOf(costs.stream().min(Integer::compareTo).orElse(null))));
    }
}
