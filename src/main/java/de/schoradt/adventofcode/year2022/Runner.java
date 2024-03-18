/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.schoradt.adventofcode.year2022;

import de.schoradt.adventofcode.util.Pair;

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
        runner.day02();

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

    public void day02() {
        Day02 day = new Day02();

        List<Pair<String, String>> parsed = day.loadLines("data/2022/day02.txt").stream()
            .map(line -> line.split("\\s+"))
            .map(array -> Pair.<String, String>builder().left(array[0]).right(array[1]).build())
            .toList();

        int result1 = day.computeScoreByGame(parsed);

        System.out.println("day02 result 1 " + result1);

        int result2 = day.computeScore2(parsed);

        System.out.println("day02 result 2 " + result2);
    }

}
