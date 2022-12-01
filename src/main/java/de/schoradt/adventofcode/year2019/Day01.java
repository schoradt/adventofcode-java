/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.schoradt.adventofcode.year2019;

import de.schoradt.adventofcode.BaseDay;

import java.util.List;

/**
 *
 * @author schoradt
 */
public class Day01 extends BaseDay {

    public int sumFuels(List<Integer> masses) {
        int sum = 0;

        for (Integer mass: masses) {
            sum += computeFuel(mass);
        }

        return sum;
    }

    public int sumAllFuels(List<Integer> masses) {
        int sum = 0;

        for (Integer mass: masses) {
            sum += computeAllFuel(mass);
        }

        return sum;
    }

    public int computeFuel(int mass) {
        float value = (float)mass / 3;

        int rounded = (int)value;

        return rounded - 2;
    }

    public int computeAllFuel(int mass) {
        int fuelSum = computeFuel(mass);

        int fuel = fuelSum;

        while ((fuel = computeFuel(fuel)) > 0) {
            fuelSum += fuel;
        }

        return fuelSum;
    }
}
