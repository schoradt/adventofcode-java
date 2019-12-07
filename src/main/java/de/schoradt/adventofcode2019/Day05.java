/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.schoradt.adventofcode2019;

import de.schoradt.adventofcode2019.intcode.Processor;


/**
 *
 * @author schoradt
 */
public class Day05 extends Day00 {
    public int processProgramm(String input, int inValue, boolean output, boolean debug) {
        Processor processor = new Processor();
        
        processor.loadProgram(input);
        processor.addInput(inValue);
        
        processor.setOutput(output);
        processor.setDebug(debug);
        
        return processor.process();
    }
}
