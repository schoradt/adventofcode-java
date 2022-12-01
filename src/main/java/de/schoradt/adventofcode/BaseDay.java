/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.schoradt.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author schoradt
 */
public class BaseDay {
    public List<String> loadLines(String filename) {
        List<String> list = new ArrayList<>();

        try (Scanner s = new Scanner(new File(filename))) {
            while (s.hasNext()){
                list.add(s.next());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BaseDay.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public List<String> loadLinesString(String content) {
        List<String> list = new ArrayList<>();

        try (Scanner s = new Scanner(content)) {
            while (s.hasNext()){
                list.add(s.next());
            }
        }

        return list;
    }

    public List<Integer> parseIntergerLines(List<String> integers) {
        List<Integer> list = new ArrayList<>();

        for(String integer: integers) {
            list.add(Integer.parseInt(integer));
        }

        return list;
    }

    public List<String> splitLine(String line) {
        List<String> list = new ArrayList<>();

        String[] items = line.split(",");

        Collections.addAll(list, items);

        return list;
    }
}
