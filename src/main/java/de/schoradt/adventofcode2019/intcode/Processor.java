/*
 * Copyright 2019 Sven Schoradt (s.schoradt@infotec-edv.de).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.schoradt.adventofcode2019.intcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Sven Schoradt (s.schoradt@infotec-edv.de)
 */
public class Processor {
    private final List<Integer> memory;
    
    int pc = 0;
    
    private boolean output = false;
    private boolean debug = false;
    
    private LinkedList<Integer> inputValues;
    private Integer outputValue = null;
    
    public Processor() {
        memory = new ArrayList<>();
        
        inputValues = new LinkedList<>();
    }

    public void loadProgram(String program) {
        memory.clear();
        
        for(String command: program.split(",")) {
            memory.add(Integer.parseInt(command));
        }
    }

    public void setOutput(boolean output) {
        this.output = output;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    public void addInput(int input) {
        this.inputValues.add(input);
    }
    
    public void init(int noun, int verb) {
        memory.set(1, noun);
        memory.set(2, verb);
    }
    
    public int process() {
        while(true) {
            
            debug();
            
            switch(getCommand()) {
                case 1:
                    add();
                    
                    break;

                case 2:
                    mult();
                            
                    break;

                case 3:
                    input();
                    
                    break;

                case 4:
                    output();
                    
                    break;

                case 5:
                    jumpIfTrue();
                    
                    break;
                case 6:
                    jumpIfFalse();
                    
                    break;
                case 7:
                    setIfLower();
                    
                    break;
                case 8:
                    setIfEqual();
                    
                    break;
                case 99:
                    return stop();
                    
                default:
                    System.out.println("unknown action " + getCommand());
                    
                    debug();
                    
                    return 0;
            }
        }        
    }
    
    private int getCommand() {
        int command = memory.get(pc);
            
        int cmd = command % 100;
        
        return cmd;
    }
    
    private int getValue(int number) {
        int mode = 0;
        
        int cmd = memory.get(pc);
        cmd = cmd / 100;
        
        int value;
        
        for (int i = number; i > 1 && cmd > 0; i--) {
            cmd = cmd / 10;
        }
        
        if (cmd > 0) {
            mode = cmd % 10;
        }
        
        if (mode == 0) {
            int index = memory.get(pc + number);
            
            value = memory.get(index);
        } else {
            value = memory.get(pc + number);
        }
        
        return value;
    }
    
    private int getIndex(int number) {
        return memory.get(pc + number);
    }
    
    private void setValue(int index, int value) {
        memory.set(index, value);
    }
    
    private void add() {
        int value1 = getValue(1);
        int value2 = getValue(2);

        int outIndex = getIndex(3);

        int value = value1 + value2;

        setValue(outIndex, value);
        
        pc += 4;
    }
    
    private void mult() {
        int value1 = getValue(1);
        int value2 = getValue(2);

        int outIndex = getIndex(3);

        int value = value1 * value2;

        setValue(outIndex, value);
        
        pc += 4;
    }
    
    private void input() {
        int outIndex = getIndex(1);

        setValue(outIndex, inputValues.pollFirst());
        
        pc += 2;
    }
    
    private void output() {
        int value = getValue(1);

        if (output) {
            System.out.print(" " + value);
        }

        outputValue = value;

        pc += 2;
    }
    
    private void jumpIfTrue() {
        int value1 = getValue(1);
        int value2 = getValue(2);

        if (value1 != 0) {
            pc = value2;
        } else {
            pc += 3;
        }
    }
    
    private void jumpIfFalse() {
        int value1 = getValue(1);
        int value2 = getValue(2);

        if (value1 == 0) {
            pc = value2;
        } else {
            pc += 3;
        }
    }
    
    private void setIfLower() {
        int value1 = getValue(1);
        int value2 = getValue(2);

        int outIndex = getIndex(3);

        if (value1 < value2) {
            setValue(outIndex, 1);
        } else {
            setValue(outIndex, 0);
        }

        pc += 4;
    }
    
    private void setIfEqual() {
        int value1 = getValue(1);
        int value2 = getValue(2);

        int outIndex = getIndex(3);

        if (value1 == value2) {
            setValue(outIndex, 1);
        } else {
            setValue(outIndex, 0);
        }

        pc += 4;
    }
    
    private int stop() {
        if (output) {
            System.out.println(" FINISH");
        }

        if (outputValue == null) {
            return memory.get(0);
        }

        return outputValue;
    }
    
    private void debug() {
        if (!debug) {
            return;
        }
        
        System.out.print("[");
        
        int index = 0;
        
        for (Integer item: memory) {
            if (index > 0) {
                System.out.print(",");
            }
            
            if (index == pc) {
                System.out.print("_");
            }
            
            System.out.print(item);
            
            if (index == pc) {
                System.out.print("_");
            }
            
            index++;
        }
        
        System.out.println("]");
    }
}
