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
public class Day05Test {
    @ParameterizedTest
    @CsvSource({
        "'1,0,0,0,99', 0, 2",
        "'2,3,0,3,99', 0, 2",
        "'2,4,4,0,99,0', 0, 9801",
        "'1,1,1,4,99,5,6,0,99', 0, 30",
        "'3,12,6,12,15,1,13,14,13,4,13,99,-1,0,1,9', 0, 0",
        "'3,12,6,12,15,1,13,14,13,4,13,99,-1,0,1,9', 1, 1",
        "'3,3,1105,-1,9,1101,0,0,12,4,12,99,1', 0, 0",
        "'3,3,1105,-1,9,1101,0,0,12,4,12,99,1', 1, 1",
        "'3,21,1008,21,8,20,1005,20,22,107,8,21,20,1006,20,31," +
            "1106,0,36,98,0,0,1002,21,125,20,4,20,1105,1,46,104," +
            "999,1105,1,46,1101,1000,1,20,4,20,1105,1,46,98,99', 1, 999",
        "'3,21,1008,21,8,20,1005,20,22,107,8,21,20,1006,20,31," +
            "1106,0,36,98,0,0,1002,21,125,20,4,20,1105,1,46,104," +
            "999,1105,1,46,1101,1000,1,20,4,20,1105,1,46,98,99', 8, 1000",
        "'3,21,1008,21,8,20,1005,20,22,107,8,21,20,1006,20,31," +
            "1106,0,36,98,0,0,1002,21,125,20,4,20,1105,1,46,104," +
            "999,1105,1,46,1101,1000,1,20,4,20,1105,1,46,98,99', 12, 1001"
    })
    public void testProcessProgramm(String line, int inputValue, int should) {
        Day05 day = new Day05();
        
        assertEquals(should, day.processProgramm(line, inputValue, false, false));
    }
}
