import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> arrayList = new ArrayList<>(Arrays.asList(-1, -1, -1, -1, 1));
        List<List<Integer>> solutions = new NQueenBoard().solve(arrayList);
        for (List<Integer> solution : solutions){
            System.out.println(solution);
        }

    }
}
