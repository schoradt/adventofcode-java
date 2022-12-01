/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.schoradt.adventofcode.year2019;

import de.schoradt.adventofcode.BaseDay;
import de.schoradt.adventofcode.year2019.intcode.Processor;


/**
 *
 * @author schoradt
 */
public class Day02 extends BaseDay {
    public int processProgramm(String input, int noun, int verb) {
        Processor processor = new Processor();

        processor.loadProgram(input);

        processor.init(noun, verb);

        return Long.valueOf(processor.process()).intValue();
    }

    public int hackNounVerb(String line, int result) {
        for (int i = 0; i <= 99; i++) {
            for (int j = 0; j <= 99; j++) {
                int testResult = this.processProgramm(line, i, j);

                if (testResult == result) {
                    return 100 * i + j;
                }
            }
        }

        return 0;
    }
}
