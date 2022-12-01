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
public class Day05 extends BaseDay {
    public int processProgramm(String input, int inValue, boolean output, boolean debug) {
        Processor processor = new Processor();

        processor.loadProgram(input);
        processor.addInput(inValue);

        processor.setOutput(output);
        processor.setDebug(debug);

        return Long.valueOf(processor.process()).intValue();
    }
}
