import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solve {

    private static int num_q;
    private static ArrayList<ArrayList<Integer>> solutions;
    private static ArrayList<Integer> current_solution;
    private static ArrayList<Integer> alreadyDefined;

    public static ArrayList<ArrayList<Integer>> solve(ArrayList<Integer> incompleteList){

        num_q = incompleteList.size();
        solutions = new ArrayList<>();
        current_solution = new ArrayList<>(incompleteList);

        // We should know what indexes are already defined so:
        alreadyDefined = IntStream.range(0, current_solution.size()).filter(i -> current_solution.get(i) != -1).
                boxed().collect(Collectors.toCollection(ArrayList::new));

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
            // Do nothing
            return;
        }
        else if (level == num_q){
            solutions.add(new ArrayList<>(current_solution));
        }
        else {
            if (alreadyDefined.contains(level)){
                backtracking_dfs(level += 1);
            } else {
                for (int i = 0; i < num_q; i++){
                    current_solution.set(level, i);
                    backtracking_dfs(level + 1);
                }
                current_solution.set(level, -1);
            }
        }
    }
}
