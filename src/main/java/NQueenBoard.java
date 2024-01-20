import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NQueenBoard {

    private final List<List<Integer>> solutions = new ArrayList<>();
    private List<Integer> current_solution;
    private List<Integer> alreadyDefined;
    private int num_queens;

    public List<List<Integer>> solve(List<Integer> incompleteList){
        initConfiguration(incompleteList);
        if (check_defined_in_bounds()) return null;

        backtracking_dfs(0);
        return solutions;
    }

    private void initConfiguration(List<Integer> incompleteList) {
        current_solution = new ArrayList<>(incompleteList);
        alreadyDefined = getDefinedIndexes();
        num_queens = incompleteList.size();
    }

    private boolean check_defined_in_bounds() {
        return current_solution.stream().anyMatch(integer -> integer >= num_queens);
    }

    private ArrayList<Integer> getDefinedIndexes() {
        return IntStream.range(0, current_solution.size()).filter(i -> current_solution.get(i) != -1).
                boxed().collect(Collectors.toCollection(ArrayList::new));
    }

    private boolean isValidCombination(List<Integer> combination, int level){
        return IntStream.range(0, level)
                .noneMatch(i -> IntStream.range(i + 1, level)
                        .anyMatch(j -> combination.get(i).equals(combination.get(j)) ||
                                combination.get(i).equals(combination.get(j) + (j - i)) ||
                                combination.get(i).equals(combination.get(j) - (j - i))));
    }

    private void backtracking_dfs(int level){
        if (!isValidCombination(current_solution, level)) return;
        if (level == num_queens) solutions.add(List.copyOf(current_solution));

        else {
            if (alreadyDefined.contains(level)) {backtracking_dfs(level + 1);
            } else {
                buildCandidate(level);
            }
        }
    }

    public void buildCandidate(int level){
        IntStream.range(0, num_queens).forEach(i -> {
            current_solution.set(level, i);
            backtracking_dfs(level + 1);
        });
        current_solution.set(level, -1);
    }
}
