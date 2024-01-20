package source;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NQueenBoard {

    private List<Integer> currentSolution;
    private final List<List<Integer>> solutions = new ArrayList<>();
    private List<Integer> definedIndexes;
    private int num_queens;

    public List<List<Integer>> solve(List<Integer> initDistribution){
        initConfiguration(initDistribution);

        if (checkDefinedInBounds()) return List.of();
        dfs_backtracking(0);
        return solutions;
    }

    private void dfs_backtracking(int level) {
        if (!isValidCombination(currentSolution, level)) return;
        if (level == num_queens) solutions.add(List.copyOf(currentSolution));
        else {
            if (definedIndexes.contains(level)) {dfs_backtracking(level + 1);}
            else {
                buildCandidate(level);
            }
        }
    }

    private void buildCandidate(int level) {
        IntStream.range(0, num_queens).forEach(i -> {
            currentSolution.set(level, i);
            dfs_backtracking(level + 1);
        });
        currentSolution.set(level, -1);
    }

    private boolean isValidCombination(List<Integer> combination, int level) {
        return IntStream.range(0, level).noneMatch(i -> IntStream.range(i + 1, level).anyMatch(
           j -> combination.get(i).equals(combination.get(j)) || combination.get(i).equals(combination.
                   get(j) + (j - i)) || combination.get(i).equals(combination.get(j) - (j - i))
        ));
    }

    private void initConfiguration(List<Integer> initDistribution) {
        this.currentSolution = new ArrayList<>(initDistribution);
        this.num_queens = initDistribution.size();
        this.definedIndexes = getDefinedIndexes();
    }

    private List<Integer> getDefinedIndexes() {
        return IntStream.range(0, currentSolution.size()).filter(i -> currentSolution.get(i) != -1).
                boxed().collect(Collectors.toCollection(ArrayList::new));
    }

    private boolean checkDefinedInBounds(){
        return this.currentSolution.stream().anyMatch(integer -> integer >= num_queens);
    }

}