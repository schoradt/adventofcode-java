/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.schoradt.adventofcode2019;

import de.schoradt.adventofcode2019.intcode.Processor;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author schoradt
 */
public class Day07 extends Day00 {
    
    public int hackAmplifierChain(String input) {
        int max = Integer.MIN_VALUE;
        
        List<List<Integer>> settings = generateSettings();
        
        int value;
        
        for(List<Integer> setting: settings) {
            //ystem.out.print("hack " + setting.get(0) + " " + setting.get(1) + " " + setting.get(2) + " " + setting.get(3) + " " + setting.get(4));

            value = amplifierChain(input, setting);

            max = Math.max(max, value);

            //System.out.println("    => " + value + " (" + max + ")");
        }
         
        return max;
    }
    
    private List<List<Integer>> generateSettings() {
        List<List<Integer>> res;
        
        List<Integer> settings = new ArrayList<>();
        
        settings.add(0);
        settings.add(1);
        settings.add(2);
        settings.add(3);
        settings.add(4);
        
        res = createPermutations(settings);
    
        return res;
    }
    
    public int hackAmplifierChainFeedbackLoop(String input) {
        int max = Integer.MIN_VALUE;
        
        List<List<Integer>> settings = generateSettingsFeedbackLoop();
        
        int value;
        
        for(List<Integer> setting: settings) {
            //System.out.print("hack " + setting.get(0) + " " + setting.get(1) + " " + setting.get(2) + " " + setting.get(3) + " " + setting.get(4));

            value = amplifierChainFeedbackLoop(input, setting);

            max = Math.max(max, value);

            //System.out.println("    => " + value + " (" + max + ")");
        }
         
        return max;
    }
    
    private List<List<Integer>> generateSettingsFeedbackLoop() {
        List<List<Integer>> res;
        
        List<Integer> settings = new ArrayList<>();
        
        settings.add(5);
        settings.add(6);
        settings.add(7);
        settings.add(8);
        settings.add(9);
        
        res = createPermutations(settings);
    
        return res;
    }
    
    
    public int amplifierChain(String input, List<Integer> settings) {
        int res = 0;
        
        Processor processor;
        
        long value = 0;
        
        int i = 1;
        
        for (Integer setting: settings) {
            processor = new Processor();
            
            processor.loadProgram(input);
            
            processor.addInput(setting);
            processor.addInput(value);
                   
            value = processor.process();
            
            i++;
        }
        
        return Long.valueOf(value).intValue();
    }
    
    public int amplifierChainFeedbackLoop(String input, List<Integer> settings) {
        int res = 0;
        
        LinkedList<Processor> processors = new LinkedList<>();
        
        for (Integer setting: settings) {
            Processor processor = new Processor();
            
            processor.loadProgram(input);
            
            processor.addInput(setting);
            
            processors.addLast(processor);
        }
        
        boolean stopMode = false;
        
        long value = 0;
        
        int i = 0;
        
        while (true) {
            //System.out.println("round " + i + " processor " + ((i % settings.size())+1) + " value " + value + (stopMode?" stopping":""));
            
            Processor processor = processors.pollFirst();
            
            if (stopMode && !processor.isRun()) {
                return Long.valueOf(value).intValue();
            }
            
            processor.addInput(value);
            
            value = processor.processToNextOutput();
            
            if (!processor.isRun()) {
                stopMode = true;
            }
            
            processors.addLast(processor);
            
            i++;
        }
    }
    
    private List<List<Integer>> createPermutations(List<Integer> settings) {
        List<List<Integer>> res = new ArrayList<>();
        
        if (settings.size() == 1) {
            res.add(settings);
            
            return res;
        }
        
        for (int i = 0; i < settings.size(); i++) {
            List<Integer> copy = new ArrayList<>(settings);
            
            int value = copy.remove(i);
            
            List<List<Integer>> subs = createPermutations(copy);
            
            for (List<Integer> sub: subs) {
                sub.add(0, value);
                
                res.add(sub);
            }
        }
        
        return res;
    }
}
