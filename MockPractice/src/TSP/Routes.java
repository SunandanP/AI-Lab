package TSP;

public class Routes {
    private int[][] table;

    Routes(){
        table = new int[5][5];

        table[0][0] = Integer.MAX_VALUE;
        table[0][1] = 10;
        table[0][2] = 3;
        table[0][3] = 6;
        table[0][4] = 9;

        table[1][0] = 5;
        table[1][1] = Integer.MAX_VALUE;
        table[1][2] = 5;
        table[1][3] = 4;
        table[1][4] = 2;

        table[2][0] = 4;
        table[2][1] = 9;
        table[2][2] = Integer.MAX_VALUE;
        table[2][3] = 7;
        table[2][4] = 8;

        table[3][0] = 7;
        table[3][1] = 1;
        table[3][2] = 3;
        table[3][3] = Integer.MAX_VALUE;
        table[3][4] = 4;

        table[4][0] = 3;
        table[4][1] = 2;
        table[4][2] = 6;
        table[4][3] = 5;
        table[4][4] = Integer.MAX_VALUE;

    }

    public int[][] getTable() {
        return table;
    }
}
