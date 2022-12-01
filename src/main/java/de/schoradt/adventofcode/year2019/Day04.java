/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.schoradt.adventofcode.year2019;

import de.schoradt.adventofcode.BaseDay;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author schoradt
 */
class Day04 extends BaseDay {

    public int countPasswords(int start, int end) {
        int res = 0;

        for (int i = start; i <= end; i++) {
            if (checkPassword(i)) {
                res++;
            }
        }

        return res;
    }

    public int countPasswordsSharpened(int start, int end) {
        int res = 0;

        for (int i = start; i <= end; i++) {
            if (checkPasswordSharpened(i)) {
                res++;
            }
        }

        return res;
    }

    public boolean checkPassword(int password) {
        if (password < 100000 || password > 999999) {
            return false;
        }

        List<Integer> digits = toDigits(password);

        boolean decrease = false;
        boolean following = false;

        int last = -1;

        for (Integer digit: digits) {
            if (last >= 0) {
                if (last == digit) {
                    following = true;
                }

                if (digit < last) {
                    decrease = true;
                }
            }

            last = digit;
        }

        return following && !decrease;
    }

    public boolean checkPasswordSharpened(int password) {
        if (password < 100000 || password > 999999) {
            return false;
        }

        List<Integer> digits = toDigits(password);

        boolean decrease = false;
        boolean following = false;
        boolean groupFollowing = false;
        boolean group = false;

        int last = -1;

        for (Integer digit: digits) {
            if (last >= 0) {
                if (last == digit) {
                    if (group) {
                        groupFollowing = false;
                    } else {
                        groupFollowing = true;
                        group = true;
                    }
                } else {
                    if (group && groupFollowing) {
                        following = true;
                    }

                    group = false;
                }

                if (digit < last) {
                    decrease = true;
                }
            }

            last = digit;
        }

        if (group && groupFollowing) {
            following = true;
        }

        return following && !decrease;
    }

    private List<Integer> toDigits(int number) {
        LinkedList<Integer> list = new LinkedList<>();

        while (number > 0) {
            list.push( number % 10 );

            number = number / 10;
        }

        return list;
    }
}
