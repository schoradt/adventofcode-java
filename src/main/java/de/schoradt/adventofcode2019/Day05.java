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
public class Day05 extends Day00 {
    public int processProgramm(List<Integer> input, int inValue, boolean output, boolean debug) {
        int pos = 0;
        
        int lastValue = 0;
        
        while(true) {
            int value1;
            int value2;
            int outIndex;
            
            int value;
            
            if (debug) {
                debug(input, pos);
            }
            
            int command = input.get(pos);
            
            int cmd = command % 100;
            command = command / 100;
            
            switch(cmd) {
                case 1:
                    value1 = getValue(input, pos, command, 1);
                    value2 = getValue(input, pos, command, 2);
                    
                    outIndex = input.get(pos + 3);
                    
                    value = value1 + value2;
                    
                    input.set(outIndex, value);
                    
                    pos += 4;
                    
                    break;

                case 2:
                    value1 = getValue(input, pos, command, 1);
                    value2 = getValue(input, pos, command, 2);
                    
                    outIndex = input.get(pos + 3);
                    
                    value = value1 * value2;
                    
                    input.set(outIndex, value);
                    
                    pos += 4;
                    
                    break;

                case 3:
                    outIndex = input.get(pos + 1);
                    
                    value = inValue;
                    
                    input.set(outIndex, value);
                    
                    pos += 2;
                    
                    break;

                case 4:
                    value1 = getValue(input, pos, command, 1);
                    
                    if (output) {
                        System.out.print(" " + value1);
                    }
                    
                    lastValue = value1;
                    
                    pos += 2;
                    
                    break;

                case 5:
                    value1 = getValue(input, pos, command, 1);
                    value2 = getValue(input, pos, command, 2);
                    
                    if (value1 != 0) {
                        pos = value2;
                    } else {
                        pos += 3;
                    }
                    
                    break;
                case 6:
                    value1 = getValue(input, pos, command, 1);
                    value2 = getValue(input, pos, command, 2);
                    
                    if (value1 == 0) {
                        pos = value2;
                    } else {
                        pos += 3;
                    }
                    
                    break;
                case 7:
                    value1 = getValue(input, pos, command, 1);
                    value2 = getValue(input, pos, command, 2);
                    
                    outIndex = input.get(pos + 3);
                    
                    if (value1 < value2) {
                        input.set(outIndex, 1);
                    } else {
                        input.set(outIndex, 0);
                    }
                    
                    pos += 4;
                    
                    break;
                case 8:
                    value1 = getValue(input, pos, command, 1);
                    value2 = getValue(input, pos, command, 2);
                    
                    outIndex = input.get(pos + 3);
                    
                    if (value1 == value2) {
                        input.set(outIndex, 1);
                    } else {
                        input.set(outIndex, 0);
                    }
                    
                    pos += 4;
                    
                    break;
                case 99:
                    if (output) {
                        System.out.println(" FINISH");
                    }
                    
                    return lastValue;

                default:
                    System.out.println("unknown action " + cmd);
                    
                    debug(input, pos);
                    
                    return 0;
            }
        }        
    }
    
    private int getValue(List<Integer> input, int pos, int cmd, int number) {
        int mode = 0;
        
        int value;
        
        for (int i = number; i > 1 && cmd > 0; i--) {
            cmd = cmd / 10;
        }
        
        if (cmd > 0) {
            mode = cmd % 10;
        }
        
        if (mode == 0) {
            int index = input.get(pos + number);
            
            value = input.get(index);
        } else {
            value = input.get(pos + number);
        }
        
        return value;
    } 
    
    public void debug(List<Integer> input, int pos) {
        System.out.print("[");
        
        int index = 0;
        
        for(Integer item: input) {
            if (index > 0) {
                System.out.print(",");
            }
            
            if (index == pos) {
                System.out.print("_");
            }
            
            System.out.print(item);
            
            if (index == pos) {
                System.out.print("_");
            }
            
            index++;
        }
        
        System.out.println("]");
    }
    
}
