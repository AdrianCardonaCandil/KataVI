import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(-1, -1, -1, -1));
        ArrayList<ArrayList<Integer>> solutions = new NQueenSolver().solve(arrayList);
        for (ArrayList<Integer> solution : solutions){
            System.out.println(solution);
        }

    }
}
