package de.schoradt.adventofcode.year2022;

import de.schoradt.adventofcode.BaseDay;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day01 extends BaseDay {

    public int mostCalories(List<Integer> calories) {
        int mostCalories = 0;

        int actualCalories = 0;

        for (Integer i: calories) {
            if (i == null) {
                mostCalories = Math.max(actualCalories, mostCalories);

                actualCalories = 0;
            } else {
                actualCalories += i;
            }
        }

        return Math.max(actualCalories, mostCalories);
    }

    public int threeMostCalories(List<Integer> calories) {
        int actualCalories = 0;

        List<Integer> elves = new ArrayList<>();

        for (Integer i: calories) {
            if (i == null) {
                elves.add(actualCalories);

                actualCalories = 0;
            } else {
                actualCalories += i;
            }
        }

        if (actualCalories > 0) {
            elves.add(actualCalories);
        }

        Collections.sort(elves);
        Collections.reverse(elves);

        return elves.get(0) + elves.get(1) + elves.get(2);
    }

}
