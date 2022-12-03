/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.schoradt.adventofcode.year2022;

import java.util.List;

/**
 *
 * @author schoradt
 */
public class Runner {
    public static void runDays() {
        System.out.println("################################");
        System.out.println("#                              #");
        System.out.println("# Advent of code 2022          #");
        System.out.println("#                              #");
        System.out.println("################################");
        System.out.println();
        System.out.println();

        Runner runner = new Runner();

        runner.day01();

        System.out.println();
        System.out.println();
    }

    public void day01() {
        Day01 day = new Day01();

        List<Integer> calories = day.parseIntergerLines(day.loadLines("data/2022/day01.txt"));

        int result1 = day.mostCalories(calories);

        System.out.println("day01 result 1 " + result1);

        int result2 = day.threeMostCalories(calories);

        System.out.println("day01 result 2 " + result2);
    }

}
