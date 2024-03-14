import java.util.ArrayList;

public class Arrangement {
      ArrayList<ArrayList<Integer>> elements;
      private static final int MAX = Integer.MAX_VALUE;

      public Arrangement(ArrayList<ArrayList<Integer>> elements) {
            this.elements = elements;
      }

      public Arrangement(Arrangement arrangement){
            this.elements = new ArrayList<>();
            elements.add(new ArrayList<>(arrangement.elements.get(0)));
            elements.add(new ArrayList<>(arrangement.elements.get(1)));
            elements.add(new ArrayList<>(arrangement.elements.get(2)));
      }

      public Arrangement(){
            elements =   new ArrayList<>();
            var temp = new ArrayList<Integer>();
            temp.add(0);
            temp.add(0);
            temp.add(0);

            elements.add(new ArrayList<>(temp));
            elements.add(new ArrayList<>(temp));
            elements.add(new ArrayList<>(temp));
      }

      public Position locateElement(int val){
            for (int i = 0; i < elements.size(); i++) {
                  for(int j = 0; j < elements.size(); j++){
                        if (val == accessElement(i,j)){
                              return new Position(i,j);
                        }
                  }
            }

            return new Position();
      }

      public ArrayList<ArrayList<Integer>> getElements() {
            return elements;
      }

      public void setElements(ArrayList<ArrayList<Integer>> elements) {
            this.elements = elements;
      }

      public int accessElement(int x, int y){
            return elements.get(x).get(y);
      }

      public void modifyElement(int x, int y, int val){
            elements.get(x).set(y, val);
      }

      public void beautify(){
            System.out.println("----------------------------");
      }
      public void beautify2(){
            System.out.println("============================");
      }

      public void print(Puzzle puzzle){
            beautify2();
            System.out.println("Heuristic : "+ puzzle.getHeuristic());
            System.out.println("G-Score : "+ puzzle.getGScore());
            System.out.println("F-Score : "+ puzzle.getFScore());
            beautify();
            for (int i = 0; i < elements.size(); i++) {
                  for (int j = 0; j < elements.size(); j++) {
                        System.out.print("\t" + elements.get(i).get(j) + "\t");
                  }
                  System.out.println();
            }
            beautify2();
      }

      public void print(){
            beautify2();
            for (int i = 0; i < elements.size(); i++) {
                  for (int j = 0; j < elements.size(); j++) {
                        System.out.print("\t" + elements.get(i).get(j) + "\t");
                  }
                  System.out.println();
            }
            beautify2();
      }

      @Override
      public String toString() {
            return "Arrangement{" +
                        "elements=" + elements +
                        '}';
      }
}
