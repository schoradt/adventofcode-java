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
    private class UnlimitedArrayList<T extends Object> extends ArrayList<T> {        
        private static final long serialVersionUID = 1L;
        
        T defaultValue;

        public UnlimitedArrayList(T defaultValue) {
            this.defaultValue = defaultValue;
        }
       
        @Override
        public T get(int index) {
            if (index >= this.size()) {
                for(int i = this.size(); i <= index; i++) {
                    this.add(defaultValue);
                }
            }
            
            return super.get(index);
        }
        
        @Override
        public T set(int index, T value) {
            if (index >= this.size()) {
                for(int i = this.size(); i <= index; i++) {
                    this.add(defaultValue);
                }
            }
            
            return super.set(index, value);
        }
    }
    
    private final List<Long> memory;
    
    int pc = 0;
    
    int relativeBase = 0;
    
    private boolean output = false;
    private boolean debug = false;
    
    private boolean run = false;
    
    private final LinkedList<Long> inputValues;
    private final LinkedList<Long> outputValues;
    
    private Long outputValue = null;
    
    public Processor() {
        memory = new UnlimitedArrayList<>(0L);
        
        inputValues = new LinkedList<>();
        outputValues = new LinkedList<>();
    }

    public void loadProgram(String program) {
        memory.clear();
        
        for(String command: program.split(",")) {
            memory.add(Long.parseLong(command));
        }
    }

    public void setOutput(boolean output) {
        this.output = output;
    }

    public LinkedList<Long> getOutputValues() {
        return outputValues;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    public void addInput(long input) {
        this.inputValues.add(input);
    }
    
    public void init(long noun, long verb) {
        memory.set(1, noun);
        memory.set(2, verb);
    }

    public boolean isRun() {
        return run;
    }
    
    public long process() {
        run = true;
        
        long value = 0;
        
        while (run) {
            value = processToNextOutput();
        }
        
        return value;
    }
    
    public long processToNextOutput() {
        run = true;
        
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
                    return output();
                    
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
                case 9:
                    setRelativeBase();
                    
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
        long command = memory.get(pc);
            
        Long cmd = command % 100;
        
        return cmd.intValue();
    }
    
    private long getValue(int number) {
        long mode = 0;
        
        long cmd = memory.get(pc);
        cmd = cmd / 100;
        
        long value;
        
        for (int i = number; i > 1 && cmd > 0; i--) {
            cmd = cmd / 10;
        }
        
        if (cmd > 0) {
            mode = cmd % 10;
        }
        
        if (mode == 1) {
            value = memory.get(pc + number);
        } else if (mode == 2) {
            int shift = memory.get(pc + number).intValue();
            
            value = memory.get(relativeBase + shift);
        } else {
            Long index = memory.get(pc + number);
            
            value = memory.get(index.intValue());
        }
        
        return value;
    }
    
    private int getIndex(int number) {
        long mode = 0;
        
        long cmd = memory.get(pc);
        cmd = cmd / 100;
        
        int value;
        
        for (int i = number; i > 1 && cmd > 0; i--) {
            cmd = cmd / 10;
        }
        
        if (cmd > 0) {
            mode = cmd % 10;
        }
        
        if (mode == 2) {
            int shift = memory.get(pc + number).intValue();
            
            value = relativeBase + shift;
        } else {
            value = memory.get(pc + number).intValue();
        }
        
        return value;
    }
    
    private void setValue(int index, long value) {
        memory.set(index, value);
    }
    
    private void add() {
        long value1 = getValue(1);
        long value2 = getValue(2);

        int outIndex = getIndex(3);

        long value = value1 + value2;

        setValue(outIndex, value);
        
        pc += 4;
    }
    
    private void mult() {
        long value1 = getValue(1);
        long value2 = getValue(2);

        int outIndex = getIndex(3);

        long value = value1 * value2;

        setValue(outIndex, value);
        
        pc += 4;
    }
    
    private void input() {
        int outIndex = getIndex(1);

        setValue(outIndex, inputValues.pollFirst());
        
        pc += 2;
    }
    
    private long output() {
        long value = getValue(1);

        if (output) {
            System.out.print(" " + value);
        }

        outputValues.add(value);
        
        outputValue = value;

        pc += 2;
        
        return value;
    }
    
    private void jumpIfTrue() {
        long value1 = getValue(1);
        long value2 = getValue(2);

        if (value1 != 0) {
            pc = Long.valueOf(value2).intValue();
        } else {
            pc += 3;
        }
    }
    
    private void jumpIfFalse() {
        long value1 = getValue(1);
        long value2 = getValue(2);

        if (value1 == 0) {
            pc = Long.valueOf(value2).intValue();
        } else {
            pc += 3;
        }
    }
    
    private void setIfLower() {
        long value1 = getValue(1);
        long value2 = getValue(2);

        int outIndex = getIndex(3);

        if (value1 < value2) {
            setValue(outIndex, 1);
        } else {
            setValue(outIndex, 0);
        }

        pc += 4;
    }
    
    private void setIfEqual() {
        long value1 = getValue(1);
        long value2 = getValue(2);

        int outIndex = getIndex(3);

        if (value1 == value2) {
            setValue(outIndex, 1);
        } else {
            setValue(outIndex, 0);
        }

        pc += 4;
    }
    
    private void setRelativeBase() {
        long value = getValue(1);
        
        this.relativeBase += Long.valueOf(value).intValue();
        
        pc += 2;
    }
    
    private long stop() {
        if (output) {
            System.out.println(" FINISH");
        }

        run = false;
        
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
        
        for (Long item: memory) {
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
