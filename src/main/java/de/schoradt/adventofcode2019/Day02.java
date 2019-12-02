/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.schoradt.adventofcode2019;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author schoradt
 */
public class Day02 extends Day00 {
    public int processProgramm(List<Integer> input) {
        int pos = 0;
        
        while(true) {
            int index1;
            int index2;
            int index3;
            int value;
            
            switch(input.get(pos)) {
                case 1:
                    index1 = input.get(pos + 1);
                    index2 = input.get(pos + 2);
                    
                    index3 = input.get(pos + 3);
                    
                    value = input.get(index1) + input.get(index2);;
                    
                    
                    
                    input.set(index3, value);
                    
                    pos += 4;
                    
                    break;

                case 2:
                    index1 = input.get(pos + 1);
                    index2 = input.get(pos + 2);
                    
                    index3 = input.get(pos + 3);
                    
                    value = input.get(index1) * input.get(index2);
                    
                    input.set(index3, value);
                    
                    pos += 4;
                    
                    break;

                case 99:
                    return input.get(0);

                default:
                    System.out.println("unknown action " + input.get(pos));
                    
                    return 0;
            }
        }        
    }
    
    public int hackNounVerb(List<Integer> line, int result) {
        for (int i = 0; i <= 99; i++) {
            for (int j = 0; j <= 99; j++) {
                List<Integer> input = new ArrayList<>(line);
                
                input.set(1, i);
                input.set(2, j);
                
                int testResult = this.processProgramm(input);
                
                if (testResult == result) {
                    return 100 * i + j;
                }
            }
        }
        
        return 0;
    }
}
