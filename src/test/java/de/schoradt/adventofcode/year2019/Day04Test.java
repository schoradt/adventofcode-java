/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.schoradt.adventofcode.year2019;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 *
 * @author schoradt
 */
public class Day04Test {

    public Day04Test() {
    }


    /**
     * Test of processProgramm method, of class Day02.
     */
    @Test
    public void testCheck() {
        Day04 day = new Day04();

        assertTrue(day.checkPassword(111111));
        assertFalse(day.checkPassword(223450));
        assertFalse(day.checkPassword(123789));
        assertFalse(day.checkPassword(787411));
    }

    @Test
    public void testCheckSharpened() {
        Day04 day = new Day04();

        assertTrue(day.checkPasswordSharpened(112233));
        assertFalse(day.checkPasswordSharpened(123444));
        assertTrue(day.checkPasswordSharpened(111122));
        assertTrue(day.checkPasswordSharpened(112222));
    }
}
