import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NQueenSolver {

    private ArrayList<ArrayList<Integer>> solutions;
    private ArrayList<Integer> current_solution;
    private ArrayList<Integer> alreadyDefined;
    private int num_queens;

    public ArrayList<ArrayList<Integer>> solve(ArrayList<Integer> incompleteList){

        num_queens = incompleteList.size();
        solutions = new ArrayList<>();
        current_solution = new ArrayList<>(incompleteList);
        alreadyDefined = getDefinedIndexes();

        backtracking_dfs(0);
        return solutions;
    }

    private ArrayList<Integer> getDefinedIndexes() {
        return IntStream.range(0, current_solution.size()).filter(i -> current_solution.get(i) != -1).
                boxed().collect(Collectors.toCollection(ArrayList::new));
    }

    private boolean isValidCombination(ArrayList<Integer> combination, int level){
        return IntStream.range(0, level)
                .noneMatch(i -> IntStream.range(i + 1, level)
                        .anyMatch(j -> combination.get(i).equals(combination.get(j)) ||
                                combination.get(i).equals(combination.get(j) + (j - i)) ||
                                combination.get(i).equals(combination.get(j) - (j - i))));
    }

    private void backtracking_dfs(int level){

        if (!isValidCombination(current_solution, level)) return;
        if (level == num_queens) solutions.add(new ArrayList<>(current_solution));

        else {
            if (alreadyDefined.contains(level)) {backtracking_dfs(level + 1);
            } else {
                IntStream.range(0, num_queens).forEach(i -> {
                    current_solution.set(level, i);
                    backtracking_dfs(level + 1);
                });
                current_solution.set(level, -1);
            }
        }
    }
}
