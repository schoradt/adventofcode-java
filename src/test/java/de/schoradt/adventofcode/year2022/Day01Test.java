package de.schoradt.adventofcode.year2022;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Day01Test {

    public Day01Test() {
    }

    @Test
    public void testMostCalories() {
        Day01 day = new Day01();

        String list = """
            1000
            2000
            3000

            4000

            5000
            6000

            7000
            8000
            9000

            10000""";

        assertEquals(14, day.loadLinesString(list).size());

        assertEquals(24000, day.mostCalories(day.parseIntergerLines(day.loadLinesString(list))));
    }

    @Test
    public void testThreeMostCalories() {
        Day01 day = new Day01();

        String list = """
            1000
            2000
            3000

            4000

            5000
            6000

            7000
            8000
            9000

            10000""";

        assertEquals(45000, day.threeMostCalories(day.parseIntergerLines(day.loadLinesString(list))));
    }

}
