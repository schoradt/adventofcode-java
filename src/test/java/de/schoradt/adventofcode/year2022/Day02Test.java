package de.schoradt.adventofcode.year2022;

import static org.junit.jupiter.api.Assertions.assertEquals;

import de.schoradt.adventofcode.util.Pair;

import org.junit.jupiter.api.Test;

import java.util.List;

public class Day02Test {

    public Day02Test() {
    }

    @Test
    public void testComputeScore() {
        Day02 day = new Day02();

        String input = """
            A Y
            B X
            C Z""";

        assertEquals(3, day.loadLinesString(input).size());

        List<Pair<String, String>> parsed = day.loadLinesString(input).stream()
                .map(line -> line.split("\\s+"))
                    .map(array -> new Pair<>(array[0], array[1]))
                        .toList();

        assertEquals(15, day.computeScoreByGame(parsed));
    }

    @Test
    public void testComputeScore2() {
        Day02 day = new Day02();

        String input = """
            A Y
            B X
            C Z""";

        assertEquals(3, day.loadLinesString(input).size());

        List<Pair<String, String>> parsed = day.loadLinesString(input).stream()
            .map(line -> line.split("\\s+"))
            .map(array -> new Pair<>(array[0], array[1]))
            .toList();

        assertEquals(12, day.computeScore2(parsed));
    }


}
