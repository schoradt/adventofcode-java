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
package de.schoradt.adventofcode2019;

import de.schoradt.adventofcode2019.intcode.Processor;

/**
 *
 * @author Sven Schoradt (s.schoradt@infotec-edv.de)
 */
public class Day09 extends Day00 {
    public long processTest(String input) {
        Processor processor = new Processor();
        
        processor.loadProgram(input);
        processor.addInput(1);
        
        return processor.process();
    }
    
    public long processBoost(String input) {
        Processor processor = new Processor();
        
        processor.loadProgram(input);
        processor.addInput(2);
        
        return processor.process();
    }
}
