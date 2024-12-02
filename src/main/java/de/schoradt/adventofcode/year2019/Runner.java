/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.schoradt.adventofcode.year2019;

import de.schoradt.adventofcode.year2019.graph.Path;
import de.schoradt.adventofcode.year2019.graph.Tree;

import java.util.List;

/**
 *
 * @author schoradt
 */
public class Runner {
    public static void runDays() {
        System.out.println("################################");
        System.out.println("#                              #");
        System.out.println("# Advent of code 2019          #");
        System.out.println("#                              #");
        System.out.println("################################");
        System.out.println();
        System.out.println();

        Runner runner = new Runner();

        runner.day01();
        runner.day02();
        runner.day03();
        runner.day04();
        runner.day05();
        runner.day06();
        runner.day07();
        runner.day08();
        runner.day09();
        runner.day10();

        System.out.println();
        System.out.println();
    }

    public void day01() {
        Day01 day = new Day01();

        List<Integer> masses = day.parseIntergerLines(day.loadLines("data/2019/day01.txt"));

        int result1 = day.sumFuels(masses);

        System.out.println("day01 result 1 " + result1);

        int result2 = day.sumAllFuels(masses);

        System.out.println("day01 result 2 " + result2);
    }

    public void day02() {
        Day02 day = new Day02();

        String line = day.loadLines("data/2019/day02.txt").get(0);

        int result1 = day.processProgramm(line, 12, 2);

        System.out.println("day02 result 1 " + result1);

        int result2 = day.hackNounVerb(line, 19690720);

        System.out.println("day02 result 2 " + result2);
    }

    public void day03() {
        Day03 day = new Day03();

        List<String> lines = day.loadLines("data/2019/day03.txt");

        Path p1 = new Path(day.splitLine(lines.get(0)));
        Path p2 = new Path(day.splitLine(lines.get(1)));


        int result1 = day.shortestCrossDistance(p1, p2);

        System.out.println("day03 result 1 " + result1);

        int result2 = day.shortestCrossSteps(p1, p2);

        System.out.println("day03 result 2 " + result2);
    }

    public void day04() {
        Day04 day = new Day04();

        int result1 = day.countPasswords(246540, 787419);

        System.out.println("day04 result 1 " + result1);

        int result2 = day.countPasswordsSharpened(246540, 787419);

        System.out.println("day04 result 2 " + result2);
    }

    public void day05() {
        Day05 day = new Day05();

        String line = day.loadLines("data/2019/day05.txt").get(0);

        int result1 = day.processProgramm(line, 1, false, false);

        System.out.println("day05 result 1 " + result1);

        int result2 = day.processProgramm(line, 5, false, false);

        System.out.println("day05 result 2 " + result2);
    }

    public void day06() {
        Day06 day = new Day06();

        List<String> map = day.loadLines("data/2019/day06.txt");

        Tree tree = day.createTree(map);

        int result1 = day.computeOrbitCountChecksums(tree);

        System.out.println("day06 result 1 " + result1);

        int result2 = day.moveToSanta(tree);

        System.out.println("day06 result 2 " + result2);
    }

    public void day07() {
        Day07 day = new Day07();

        String line = day.loadLines("data/2019/day07.txt").get(0);

        int result1 = day.hackAmplifierChain(line);

        System.out.println("day07 result 1 " + result1);

        int result2 = day.hackAmplifierChainFeedbackLoop(line);

        System.out.println("day07 result 2 " + result2);
    }

    private void day08() {
        Day08 day = new Day08();

        String line = day.loadLines("data/2019/day08.txt").get(0);

        int result1 = day.processImageChecksum(25, 6, line);

        System.out.println("day08 result 1 " + result1);

        System.out.println("day07 result 2 ");

        day.printImage(25, 6, line);
    }

    private void day09() {
        Day09 day = new Day09();

        String line = day.loadLines("data/2019/day09.txt").get(0);

        long result1 = day.processTest(line);

        System.out.println("day09 result 1 " + result1);

        long result2 = day.processBoost(line);

        System.out.println("day09 result 2 " + result2);
    }

    private void day10() {
        Day10 day = new Day10();

        List<String> lines = day.loadLines("data/2019/day10.txt");

        int result1 = day.bestAsteroidViewCount(lines);

        System.out.println("day09 result 1 " + result1);
    }

}
