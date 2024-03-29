public class DistanceTable {
    private int[][] distances;

    public DistanceTable(int[][] distances) {
        this.distances = distances;
    }

    public int[][] getDistances() {
        return distances;
    }

    public void setDistances(int[][] distances) {
        this.distances = distances;
    }

    public DistanceTable() {
        distances = new int[5][5];
        distances[0][0] = Integer.MAX_VALUE;
        distances[0][1] = 10;
        distances[0][2] = 3;
        distances[0][3] = 6;
        distances[0][4] = 9;

        distances[1][0] = 5;
        distances[1][1] = Integer.MAX_VALUE;
        distances[1][2] = 5;
        distances[1][3] = 4;
        distances[1][4] = 2;

        distances[2][0] = 4;
        distances[2][1] = 9;
        distances[2][2] = Integer.MAX_VALUE;
        distances[2][3] = 7;
        distances[2][4] = 8;

        distances[3][0] = 7;
        distances[3][1] = 1;
        distances[3][2] = 3;
        distances[3][3] = Integer.MAX_VALUE;
        distances[3][4] = 4;

        distances[4][0] = 3;
        distances[4][1] = 2;
        distances[4][2] = 6;
        distances[4][3] = 5;
        distances[4][4] = Integer.MAX_VALUE;
    }


}
