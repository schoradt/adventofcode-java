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
package de.schoradt.adventofcode.year2019.intcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 *
 * @author Sven Schoradt (s.schoradt@infotec-edv.de)
 */
public class ProcessorTest {

    @ParameterizedTest
    @CsvSource({
        "'1,0,0,0,99', 0, 2",
        "'2,3,0,3,99', 0, 2",
        "'2,4,4,0,99,0', 0, 9801",
        "'1,1,1,4,99,5,6,0,99', 0, 30",
        "'3,12,6,12,15,1,13,14,13,4,13,99,-1,0,1,9', 0, 0",
        "'3,12,6,12,15,1,13,14,13,4,13,99,-1,0,1,9', 1, 1",
        "'3,3,1105,-1,9,1101,0,0,12,4,12,99,1', 0, 0",
        "'3,3,1105,-1,9,1101,0,0,12,4,12,99,1', 1, 1",
        "'3,21,1008,21,8,20,1005,20,22,107,8,21,20,1006,20,31," +
            "1106,0,36,98,0,0,1002,21,125,20,4,20,1105,1,46,104," +
            "999,1105,1,46,1101,1000,1,20,4,20,1105,1,46,98,99', 1, 999",
        "'3,21,1008,21,8,20,1005,20,22,107,8,21,20,1006,20,31," +
            "1106,0,36,98,0,0,1002,21,125,20,4,20,1105,1,46,104," +
            "999,1105,1,46,1101,1000,1,20,4,20,1105,1,46,98,99', 8, 1000",
        "'3,21,1008,21,8,20,1005,20,22,107,8,21,20,1006,20,31," +
            "1106,0,36,98,0,0,1002,21,125,20,4,20,1105,1,46,104," +
            "999,1105,1,46,1101,1000,1,20,4,20,1105,1,46,98,99', 12, 1001",
        "'104,1125899906842624,99', 0, 1125899906842624",
        "'1102,34915192,34915192,7,4,7,99,0', 0, 1219070632396864"
    })
    public void testProcessProgramm(String line, long inputValue, long should) {
        Processor processor = new Processor();

        processor.loadProgram(line);
        processor.addInput(inputValue);

        assertEquals(should, processor.process());
    }

    @Test
    public void testAmplifierChainFeedbackLoop() {
        Processor processor = new Processor();

        String programm = "109,1,204,-1,1001,100,1,100,1008,100,16,101,1006,101,0,99";

        processor.loadProgram(programm);

        processor.process();

        String numberString = processor.getOutputValues().stream().map(String::valueOf).collect(Collectors.joining(","));

        assertEquals(programm, numberString);
    }

}
