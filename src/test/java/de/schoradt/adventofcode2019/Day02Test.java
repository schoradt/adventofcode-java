/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.schoradt.adventofcode2019;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 *
 * @author schoradt
 */
public class Day02Test {
    
    public Day02Test() {
    }

    
    /**
     * Test of processProgramm method, of class Day02.
     */
    @ParameterizedTest
    @CsvSource({
        "'1,0,0,0,99', 2",
        "'2,3,0,3,99', 2",
        "'2,4,4,0,99,0', 9801",
        "'1,1,1,4,99,5,6,0,99', 30"
    })
    public void testProcessProgramm(String line, int should) {
        Day02 day = new Day02();
        
        List<Integer> input = day.parseIntegerLine(line);
        
        assertEquals(should, day.processProgramm(input));
    }
}
