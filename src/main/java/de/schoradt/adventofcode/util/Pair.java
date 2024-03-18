/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.schoradt.adventofcode.util;

import lombok.Builder;
import lombok.Data;

/**
 * Pair of elements.
 *
 * @author schoradt
 *
 * @param <T1> Type 1
 * @param <T2> Type 2
 */
@Data
@Builder
public class Pair<T1, T2> {
    private T1 left;
    private T2 right;

    public Pair(T1 left, T2 right) {
        this.left = left;
        this.right = right;
    }
}
