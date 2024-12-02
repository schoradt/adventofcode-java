/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.schoradt.adventofcode.year2019;

import de.schoradt.adventofcode.year2019.graph.Tree;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author Sven Schoradt (s.schoradt@infotec-edv.de)
 */
public class Day06Test {


    /**
     * Test of computeOrbitCountChecksums method, of class Day06.
     */
    @Test
    public void testComputeOrbitCountChecksums() {
        Day06 day = new Day06();

        String mapString = """
            COM)B
            B)C
            C)D
            D)E
            E)F
            B)G
            G)H
            D)I
            E)J
            J)K
            K)L""";

        List<String> map = day.loadLinesString(mapString);

        Tree tree = day.createTree(map);

        assertEquals(42, day.computeOrbitCountChecksums(tree));
    }

    @Test
    public void testmoveToSanta() {
        Day06 day = new Day06();

        String mapString = """
            COM)B
            B)C
            C)D
            D)E
            E)F
            B)G
            G)H
            D)I
            E)J
            J)K
            K)L
            K)YOU
            I)SAN""";

        List<String> map = day.loadLinesString(mapString);

        Tree tree = day.createTree(map);

        assertEquals(4, day.moveToSanta(tree));
    }

}
