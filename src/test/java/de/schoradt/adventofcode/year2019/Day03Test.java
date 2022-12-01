/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.schoradt.adventofcode.year2019;

import de.schoradt.adventofcode.year2019.data.Pair;
import de.schoradt.adventofcode.year2019.graph.Path;
import de.schoradt.adventofcode.year2019.graph.Point;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 * @author schoradt
 */
public class Day03Test {

    public Day03Test() {
    }


    /**
     * Test of processProgramm method, of class Day02.
     */
    @Test
    public void testPath() {
        Day03 day = new Day03();

        List<String> pathDefinition = day.splitLine("R8,U5,L5,D3");

        Path path = day.createPath(pathDefinition);

        Point p = new Point(2, 0);

        assertTrue(path.isOn(p));

        assertEquals(2, p.manhattenDistance(new Point(0,0)));
    }

    @Test
    public void crosses() {
        Day03 day = new Day03();

        Path path1 = day.createPath(day.splitLine("R8,U5,L5,D3"));
        Path path2 = day.createPath(day.splitLine("U7,R6,D4,L4"));

        List<Point> crosses = path1.crosses(path2);

        assertEquals(2, crosses.size());

        assertEquals(6, day.shortestCrossDistance(path1, path2));
    }

    @Test
    public void crosses2() {
        Day03 day = new Day03();

        Path path1 = day.createPath(day.splitLine("R75,D30,R83,U83,L12,D49,R71,U7,L72"));
        Path path2 = day.createPath(day.splitLine("U62,R66,U55,R34,D71,R55,D58,R83"));

        assertEquals(159, day.shortestCrossDistance(path1, path2));
    }

    @Test
    public void crosses3() {
        Day03 day = new Day03();

        Path path1 = day.createPath(day.splitLine("R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51"));
        Path path2 = day.createPath(day.splitLine("U98,R91,D20,R16,D67,R40,U7,R15,U6,R7"));

        assertEquals(135, day.shortestCrossDistance(path1, path2));
    }

    @Test
    public void steps() {
        Day03 day = new Day03();

        Path path1 = day.createPath(day.splitLine("R8,U5,L5,D3"));
        Path path2 = day.createPath(day.splitLine("U7,R6,D4,L4"));

        List<Pair<Integer, Integer>> crosses = path1.stepsToCrosses(path2);

        assertEquals(2, crosses.size());

        assertEquals(30, day.shortestCrossSteps(path1, path2));
    }

    @Test
    public void steps2() {
        Day03 day = new Day03();

        Path path1 = day.createPath(day.splitLine("R75,D30,R83,U83,L12,D49,R71,U7,L72"));
        Path path2 = day.createPath(day.splitLine("U62,R66,U55,R34,D71,R55,D58,R83"));

        assertEquals(610, day.shortestCrossSteps(path1, path2));
    }

    @Test
    public void steps3() {
        Day03 day = new Day03();

        Path path1 = day.createPath(day.splitLine("R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51"));
        Path path2 = day.createPath(day.splitLine("U98,R91,D20,R16,D67,R40,U7,R15,U6,R7"));

        assertEquals(410, day.shortestCrossSteps(path1, path2));
    }
}
