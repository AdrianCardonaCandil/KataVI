import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(2, -1, 3, -1));
        ArrayList<ArrayList<Integer>> solutions = Solve.solve(arrayList);
        for (ArrayList<Integer> solution : solutions){
            System.out.println(solution);
        }

    }
}
