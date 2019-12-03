/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.schoradt.adventofcode2019;

import de.schoradt.adventofcode2019.data.Pair;
import de.schoradt.adventofcode2019.graph.Path;
import de.schoradt.adventofcode2019.graph.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author schoradt
 */
class Day03 extends Day00 {
    
    public Path createPath(List<String> description) {
        return new Path(description);
    }
    
    public int shortestCrossDistance(Path p1, Path p2) {
        List<Point> crosses = p1.crosses(p2);
        
        int distance = Integer.MAX_VALUE;
        Point reference = new Point(0,0);
        
        for (Point p: crosses) {
            distance = Math.min(distance, reference.manhattenDistance(p));
        }
        
        return distance;
    }
    
    public int shortestCrossSteps(Path p1, Path p2) {
        List<Pair<Integer, Integer>> crosses = p1.stepsToCrosses(p2);
        
        int distance = Integer.MAX_VALUE;
        
        for (Pair<Integer, Integer> p: crosses) {
            distance = Math.min(distance, p.getValue1()+ p.getValue2());
        }
        
        return distance;
    }
}
