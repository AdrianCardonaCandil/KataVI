import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String[] first_line = new Scanner(System.in).nextLine().split(" ");
        int num_queens = Integer.parseInt(first_line[0]);

        ArrayList<ArrayList<Integer>> solutions = Solve.solve(num_queens);
        for (ArrayList<Integer> solution : solutions){
            System.out.println(solution);
        }
    }
}
