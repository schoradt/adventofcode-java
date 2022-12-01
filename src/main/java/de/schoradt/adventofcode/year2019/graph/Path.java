/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.schoradt.adventofcode.year2019.graph;

import de.schoradt.adventofcode.year2019.data.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author schoradt
 */
public class Path {

    List<Point> points;

    Map<Point, Integer> checkMap;

    public Path(List<String> actions) {
        points = new ArrayList<>();

        checkMap = new HashMap<>();

        fillByActions(actions);
    }

    private void fillByActions(List<String> actions) {
        this.clear();

        Point point = new Point(0, 0);

        this.addPoint(point);

        for (String action : actions) {
            String direction = action.substring(0, 1);

            int length = Integer.parseInt(action.substring(1));

            for (int i = 0; i < length; i++) {
                point.move(direction);

                this.addPoint(point);
            }
        }
    }

    public void addPoint(Point p) {
        Point internal = new Point(p.getX(), p.getY());

        points.add(internal);
    }

    public List<Point> getPoints() {
        return points;
    }

    public boolean isOn(Point p) {
        prepareCheckMap();

        return checkMap.containsKey(p);
    }

    public Integer minSteps(Point p) {
        prepareCheckMap();

        if (checkMap.containsKey(p)) {
            return checkMap.get(p);
        }

        return null;
    }

    private void clear() {
        points.clear();
        checkMap.clear();
    }

    private void prepareCheckMap() {
        if (!checkMap.isEmpty()) {
            return;
        }

        int steps = 0;

        for (Point p : points) {
            if (!checkMap.containsKey(p)) {
                checkMap.put(p, steps);
            }

            steps++;
        }
    }

    public List<Point> crosses(Path p2) {
        List<Point> list = new ArrayList<>();

        Point ref = new Point(0,0);

        for (Point p: points) {
            if (p2.isOn(p) && !p.equals(ref)) {
                list.add(p);
            }
        }

        return list;
    }

    public List<Pair<Integer, Integer>> stepsToCrosses(Path path2) {
        List<Pair<Integer, Integer>> list = new ArrayList<>();

        Point ref = new Point(0,0);

        int steps1 = 0;

        for (Point p: points) {
            if (path2.isOn(p) && !p.equals(ref)) {
                Pair<Integer, Integer> res = new Pair<>(steps1, path2.minSteps(p));
                list.add(res);
            }

            steps1++;
        }

        return list;
    }



}
