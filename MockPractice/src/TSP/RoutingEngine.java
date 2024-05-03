package TSP;

import java.util.ArrayList;

public class RoutingEngine {
    private Routes routes;
    private ArrayList<ArrayList<Integer>> paths;

    public RoutingEngine(Routes routes) {
        this.routes = routes;
        paths = new ArrayList<>();
    }

    public RoutingEngine() {
        this.routes = new Routes();
        paths = new ArrayList<>();
    }

    public Routes getRoutingTable() {
        return routes;
    }

    public void setRoutingTable(Routes routes) {
        this.routes = routes;
    }

    public void createRoutes(){
        int[][] table = routes.getTable();
        ArrayList<Integer> path = new ArrayList<>();
        for (int source = 0; source < table.length; source++){
            path.add(source);

            int curr = source;
            while (path.size() != table.length){
                int min = Integer.MAX_VALUE, nextIndex = -1;
                for (int i = 0; i < table.length; i++) {
                    int val = table[curr][i];
                    if (val < min && !path.contains(i)){
                        nextIndex = i;
                        min = val;
                    }
                }

                path.add(nextIndex);
                curr = nextIndex;
            }

            path.add(source);
            paths.add(new ArrayList<>(path));
            path.clear();
        }

        var costs = calculateCosts();
        paths.stream().forEach(item -> transformPath(item));
        for (int i = 0; i < paths.size(); i++) {
            System.out.println("Route "+ (i+1) +" : "+ paths.get(i) + " Cost : "+ costs.get(i));
        }

        var min = costs.stream().min(Integer::compareTo);
        System.out.println("Selected path : "+paths.get(costs.indexOf(min.get())));
    }

    private ArrayList<Integer> transformPath(ArrayList<Integer> list){
        list.replaceAll(integer -> integer + 1);
        return new ArrayList<>(list);
    }

    private ArrayList<Integer> calculateCosts(){
        ArrayList<Integer> costs = new ArrayList<>();

        for (int i = 0; i < paths.size(); i++) {
            costs.add(0);

            for (int j = 0; j < paths.get(i).size(); j++) {
                var path = paths.get(i);
                if (j+1 < path.size()){
                    costs.set(i, costs.get(i) + routes.getTable()[path.get(j)][path.get(j+1)]);
                }

            }
        }
        return costs;
    }
}