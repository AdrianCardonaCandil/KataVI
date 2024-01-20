package Tests;
import org.junit.Test;
import source.NQueenBoard;

import java.util.List;

public class TestBundle {

    private final NQueenBoard board = new NQueenBoard();

    @Test
    public void shouldReturn1SolutionGiven1x1Board() {
        assert board.solve(List.of(-1)).equals(List.of(List.of(0)));
    }

    @Test
    public void shouldReturn0SolutionGiven2x2Board() {
        assert board.solve(List.of(-1, -1)).equals(List.of());
    }

    @Test
    public void shouldReturn0SolutionGiven3x3Board() {
        assert board.solve(List.of(-1, -1, -1)).equals(List.of());
    }

    @Test
    public void shouldReturn1SolutionGiven1x1BoardWithInBoundInitDistribution() {
        assert board.solve(List.of(0)).equals(List.of(List.of(0)));
    }

    @Test
    public void shouldReturn0SolutionGiven2x2BoardWithInBoundInitDistribution() {
        assert board.solve(List.of(0, -1)).equals(List.of());
    }

    @Test
    public void shouldReturn0SolutionGiven3x3BoardWithInBoundInitDistribution() {
        assert board.solve(List.of(0, -1, -1)).equals(List.of());
    }

    @Test
    public void shouldReturn0SolutionsGiven1x1BoardWithOutOfBoundsInitDistribution() {
        assert board.solve(List.of(1)).equals(List.of());
    }

    @Test
    public void shouldReturn0SolutionsGiven2x2BoardWithOutOfBoundsInitDistribution() {
        assert board.solve(List.of(2, -1)).equals(List.of());
    }

    @Test
    public void shouldReturn0SolutionsGiven3x3BoardWithOutOfBoundsInitDistribution() {
        assert board.solve(List.of(2, -1, -1)).equals(List.of());
    }

    @Test
    public void shouldReturn2SolutionsGiven4x4Board(){
        assert board.solve(List.of(-1, -1, -1, -1)).equals(List.of(
                List.of(1, 3, 0, 2), List.of(2, 0, 3, 1)
        ));
    }

    @Test
    public void shouldReturn1SolutionGiven4x4BoardWithInBoundDistribution() {
        assert board.solve(List.of(2, -1, -1, -1)).equals(List.of(
                List.of(2, 0, 3, 1)
        ));
    }

    @Test
    public void shouldReturn4SolutionsGiven6x6Board() {
        assert board.solve(List.of(-1, -1, -1, -1, -1, -1)).equals(List.of(
           List.of(1, 3, 5, 0, 2, 4), List.of(2, 5, 1, 4, 0, 3), List.of(3, 0, 4, 1, 5, 2), List.of(4, 2, 0, 5, 3, 1)
        ));
    }

    @Test
    public void shouldReturn3SolutionsGiven7x7BoardWithInBoundDistribution() {
        assert board.solve(List.of(5, 2, -1, -1, -1, -1, -1)).equals(List.of(
                List.of(5, 2, 0, 3, 6, 4, 1), List.of(5, 2, 4, 6, 0, 3, 1), List.of(5, 2, 6, 3, 0, 4, 1)
        ));
    }

}