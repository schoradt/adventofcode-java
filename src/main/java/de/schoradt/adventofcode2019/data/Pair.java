/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.schoradt.adventofcode2019.data;

/**
 * Pair of elements.
 * 
 * @author schoradt
 * 
 * @param <T1> Type 1
 * @param <T2> Type 2
 */
public class Pair<T1, T2> {
    private T1 value1;
    private T2 value2;

    public Pair(T1 value1, T2 value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public T1 getValue1() {
        return value1;
    }

    public T2 getValue2() {
        return value2;
    }
    
    public T1 getLeft() {
        return value1;
    }

    public T2 getRight() {
        return value2;
    }
    
    public void setLeft(T1 value) {
        value1 = value;
    }
    
    public void setRight(T2 value) {
        value2 = value;
    }
    
}
