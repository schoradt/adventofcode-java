/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.schoradt.adventofcode2019;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author schoradt
 */
public class Day00 {
    public List<Integer> loadFile(String filename) {
        List<Integer> list = new ArrayList<>();
        
        try (Scanner s = new Scanner(new File(filename))) {
            while (s.hasNext()){
                list.add(Integer.parseInt(s.next()));
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Day00.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }
}
