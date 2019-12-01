/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.schoradt.adventofcode2019;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 *
 * @author schoradt
 */
public class Day01Test {
    
    public Day01Test() {
    }

    /**
     * Test of computeFuel method, of class Day01.
     */
    @ParameterizedTest
    @CsvSource({
        "12, 2",
        "14, 2",
        "1969, 654",
        "100756, 33583"
    })
    public void testComputeFuel(int mass, int fuel) {
        Day01 instance = new Day01();
        
        int res = instance.computeFuel(mass);
        
        assertEquals(fuel, res);
    }
    
    /**
     * Test of computeFuel method, of class Day01.
     */
    @ParameterizedTest
    @CsvSource({
        "14, 2",
        "1969, 966",
        "100756, 50346"
    })
    public void testComputeAllFuel(int mass, int fuel) {
        Day01 instance = new Day01();
        
        int res = instance.computeAllFuel(mass);
        
        assertEquals(fuel, res);
    }
}
