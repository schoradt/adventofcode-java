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
package de.schoradt.adventofcode.year2019;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author Sven Schoradt (s.schoradt@infotec-edv.de)
 */
public class Day10Test {

    public Day10Test() {
    }

    @Test
    public void testBestAstroidViewCount1() {
        Day10 day = new Day10();

        String rasterString = ".#..#\n" +
            ".....\n" +
            "#####\n" +
            "....#\n" +
            "...##";

        List<String> lines = day.loadLinesString(rasterString);

        assertEquals(8, day.bestAstroidViewCount(lines));
    }

    @Test
    public void testBestAstroidViewCount2() {
        Day10 day = new Day10();

        String rasterString = "......#.#.\n" +
            "#..#.#....\n" +
            "..#######.\n" +
            ".#.#.###..\n" +
            ".#..#.....\n" +
            "..#....#.#\n" +
            "#..#....#.\n" +
            ".##.#..###\n" +
            "##...#..#.\n" +
            ".#....####";

        List<String> lines = day.loadLinesString(rasterString);

        assertEquals(33, day.bestAstroidViewCount(lines));
    }

    @Test
    public void testBestAstroidViewCount3() {
        Day10 day = new Day10();

        String rasterString = "#.#...#.#.\n" +
            ".###....#.\n" +
            ".#....#...\n" +
            "##.#.#.#.#\n" +
            "....#.#.#.\n" +
            ".##..###.#\n" +
            "..#...##..\n" +
            "..##....##\n" +
            "......#...\n" +
            ".####.###.";

        List<String> lines = day.loadLinesString(rasterString);

        assertEquals(35, day.bestAstroidViewCount(lines));
    }

    @Test
    public void testBestAstroidViewCount4() {
        Day10 day = new Day10();

        String rasterString = ".#..#..###\n" +
"####.###.#\n" +
"....###.#.\n" +
"..###.##.#\n" +
"##.##.#.#.\n" +
"....###..#\n" +
"..#.#..#.#\n" +
"#..#.#.###\n" +
".##...##.#\n" +
".....#.#..";

        List<String> lines = day.loadLinesString(rasterString);

        assertEquals(41, day.bestAstroidViewCount(lines));
    }

    @Test
    public void testBestAstroidViewCount5() {
        Day10 day = new Day10();

        String rasterString = ".#..##.###...#######\n" +
"##.############..##.\n" +
".#.######.########.#\n" +
".###.#######.####.#.\n" +
"#####.##.#.##.###.##\n" +
"..#####..#.#########\n" +
"####################\n" +
"#.####....###.#.#.##\n" +
"##.#################\n" +
"#####.##.###..####..\n" +
"..######..##.#######\n" +
"####.##.####...##..#\n" +
".#####..#.######.###\n" +
"##...#.##########...\n" +
"#.##########.#######\n" +
".####.#.###.###.#.##\n" +
"....##.##.###..#####\n" +
".#.#.###########.###\n" +
"#.#.#.#####.####.###\n" +
"###.##.####.##.#..##";

        List<String> lines = day.loadLinesString(rasterString);

        assertEquals(210, day.bestAstroidViewCount(lines));
    }


}
