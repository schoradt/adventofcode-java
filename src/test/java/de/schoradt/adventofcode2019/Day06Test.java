/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.schoradt.adventofcode2019;


import de.schoradt.adventofcode2019.graph.Tree;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.List;

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
        
        String mapString = "COM)B\n" +
            "B)C\n" +
            "C)D\n" +
            "D)E\n" +
            "E)F\n" +
            "B)G\n" +
            "G)H\n" +
            "D)I\n" +
            "E)J\n" +
            "J)K\n" +
            "K)L";
        
        List<String> map = day.loadLinesString(mapString);
        
        Tree tree = day.createTree(map);
        
        Assert.assertEquals(42, day.computeOrbitCountChecksums(tree));
    }
    
    @Test
    public void testmoveToSanta() {
        Day06 day = new Day06();
        
        String mapString = "COM)B\n" +
            "B)C\n" +
            "C)D\n" +
            "D)E\n" +
            "E)F\n" +
            "B)G\n" +
            "G)H\n" +
            "D)I\n" +
            "E)J\n" +
            "J)K\n" +
            "K)L\n" +
            "K)YOU\n" +
            "I)SAN";
        
        List<String> map = day.loadLinesString(mapString);
        
        Tree tree = day.createTree(map);
        
        Assert.assertEquals(4, day.moveToSanta(tree));
    }
    
}
