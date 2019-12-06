/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.schoradt.adventofcode2019;

import static org.junit.Assert.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 *
 * @author schoradt
 */
public class Day02Test {
    
    public Day02Test() {
    }

    @ParameterizedTest
    @CsvSource({
        "'1,0,0,0,99', 0, 0, 2",
        "'2,3,0,3,99', 3, 0, 2",
        "'2,4,4,0,99,0', 4, 4, 9801",
        "'1,1,1,4,99,5,6,0,99', 1, 1, 30"
    })
    public void testProcessProgramm(String line, int noun, int verb, int should) {
        Day02 day = new Day02();
        
        assertEquals(should, day.processProgramm(line, noun, verb));
    }
}
