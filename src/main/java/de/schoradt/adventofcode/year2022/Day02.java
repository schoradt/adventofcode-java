package de.schoradt.adventofcode.year2022;

import de.schoradt.adventofcode.BaseDay;
import de.schoradt.adventofcode.util.Pair;

import java.util.List;

public class Day02 extends BaseDay {

    public int computeScoreByGame(List<Pair<String, String>> strategy) {
        return strategy.stream()
            .map(this::computeSingleGame)
            .reduce(0, Integer::sum);
    }

    private int computeSingleGame(Pair<String,String> game) {
        int res = (int)game.getRight().charAt(0) - (int)'W';

        if (
            game.getRight().equals("X") && game.getLeft().equals("C")
            || game.getRight().equals("Z") && game.getLeft().equals("B")
            || game.getRight().equals("Y") && game.getLeft().equals("A")
        ) {
            res += 6;
        }
        else if (
            game.getRight().equals("X") && game.getLeft().equals("A")
                || game.getRight().equals("Y") && game.getLeft().equals("B")
                || game.getRight().equals("Z") && game.getLeft().equals("C")
        ) {
            res += 3;
        }

        return res;
    }

    public int computeScore2(List<Pair<String, String>> strategy) {
        return strategy.stream()
            .map(this::computeSingleHint)
            .reduce(0, Integer::sum);
    }

    private int computeSingleHint(Pair<String,String> game) {
        int res = ((int)game.getRight().charAt(0) - (int)'X') * 3;

        if (
            game.getRight().equals("Y") && game.getLeft().equals("A")
                || game.getRight().equals("X") && game.getLeft().equals("B")
                || game.getRight().equals("Z") && game.getLeft().equals("C")
        ) {
            res += 1;
        }
        else if (
            game.getRight().equals("Y") && game.getLeft().equals("B")
                || game.getRight().equals("Z") && game.getLeft().equals("A")
                || game.getRight().equals("X") && game.getLeft().equals("C")
        ) {
            res += 2;
        } else if (
            game.getRight().equals("Y") && game.getLeft().equals("C")
                || game.getRight().equals("X") && game.getLeft().equals("A")
                || game.getRight().equals("Z") && game.getLeft().equals("B")
        ) {
            res += 3;
        }

        return res;
    }
}
