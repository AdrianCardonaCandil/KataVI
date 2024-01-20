import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solve {

    private static int num_q;
    private static ArrayList<ArrayList<Integer>> solutions;
    private static ArrayList<Integer> current_solution;

    public static ArrayList<ArrayList<Integer>> solve(int num_queens){

        num_q = num_queens;
        solutions = new ArrayList<>();
        current_solution = IntStream.range(0, num_queens).mapToObj(i -> -1).
                collect(Collectors.toCollection(ArrayList::new));

        backtracking_dfs(0);
        return solutions;
    }

    private static boolean checkSolution(ArrayList<Integer> combination, int level){
        for (int i = 0; i < level; i ++){
            for (int j = i + 1; j < level; j++){
                if (combination.get(i).equals(combination.get(j)) || combination.get(i).
                        equals(combination.get(j) + (j - i)) || combination.get(i).
                        equals(combination.get(j) - (j - i))){
                    return false;
                }
            }
        }
        return true;
    }

    private static void backtracking_dfs(int level){
        if (!checkSolution(current_solution, level)){
            return;
        }
        else if (level == num_q){
            solutions.add(new ArrayList<>(current_solution));
        }
        else {
            for (int i = 0; i < num_q; i++){
                current_solution.set(level, i);
                backtracking_dfs(level + 1);
            }
            current_solution.set(level, -1);
        }
    }

}
