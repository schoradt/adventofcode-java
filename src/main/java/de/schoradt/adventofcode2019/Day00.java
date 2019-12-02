/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.schoradt.adventofcode2019;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
    public List<Integer> loadIntegerListFromFile(String filename) {
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
    
    public List<Integer> parseIntegerLine(String line) {
        List<Integer> result = new ArrayList<>();
        
        String[] items = line.split(",");
        
        for(String item: items) {
            result.add(Integer.parseInt(item));
        }
        
        return result;
    }
    
    public String loadLine(String filename) {
        try {
            BufferedReader brTest = new BufferedReader(new FileReader(filename));
            
            return brTest.readLine();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Day00.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Day00.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "";
    }
    
}
