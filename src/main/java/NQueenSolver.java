import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NQueenSolver {

    private final ArrayList<ArrayList<Integer>> solutions = new ArrayList<>();
    private ArrayList<Integer> current_solution;
    private ArrayList<Integer> alreadyDefined;
    private int num_queens;

    public ArrayList<ArrayList<Integer>> solve(ArrayList<Integer> incompleteList){
        initConfiguration(incompleteList);

        backtracking_dfs(0);
        return solutions;
    }

    private void initConfiguration(ArrayList<Integer> incompleteList) {
        current_solution = new ArrayList<>(incompleteList);
        alreadyDefined = getDefinedIndexes();
        num_queens = incompleteList.size();
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

        if (!checkCurrent(level)) return;
        if (level == num_queens) addValidSolution(current_solution);

        else {
            if (alreadyDefined.contains(level)) {backtracking_dfs(level + 1);
            } else {
                buildCandidate(level);
            }
        }
    }

    private void addValidSolution(ArrayList<Integer> current_solution){
        solutions.add(new ArrayList<>(current_solution));
    }

    private boolean checkCurrent(int level) {
        return isValidCombination(current_solution, level);
    }

    public void buildCandidate(int level){
        IntStream.range(0, num_queens).forEach(i -> {
            current_solution.set(level, i);
            backtracking_dfs(level + 1);
        });
        current_solution.set(level, -1);
    }
}
