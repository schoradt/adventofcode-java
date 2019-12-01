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
public class Day01 extends Day00 {
    
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
        float value = mass / 3;
        
        int rounded = (int)value;
        
        int result = rounded - 2;
        
        return result;
    }
    
    public int computeAllFuel(int mass) {
        int fuelSum = computeFuel(mass);
        
        int extra = 0;
        int fuel = fuelSum;
        
        while ((fuel = computeFuel(fuel)) > 0) {
            fuelSum += fuel;
        }
        
        return fuelSum;
    }
}
