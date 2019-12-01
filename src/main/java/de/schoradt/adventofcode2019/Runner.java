/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.schoradt.adventofcode2019;

import java.util.List;

/**
 *
 * @author schoradt
 */
public class Runner {
    public static void main(String [] args) {
        Runner.runDays();
    }
    
    public static void runDays() {
        Runner runner = new Runner();
        
        runner.day01();
    }
    
    public void day01() {
        Day01 day = new Day01();
        
        List<Integer> masses = day.loadFile("data/day01.txt");
        
        int result1 = day.sumFuels(masses);
        
        System.out.println("day01 result 1 " + result1);
        
        int result2 = day.sumAllFuels(masses);
        
        System.out.println("day01 result 2 " + result2);
    }
    
}
