/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.schoradt.adventofcode.year2019;

import de.schoradt.adventofcode.BaseDay;
import de.schoradt.adventofcode.year2019.data.Pair;
import de.schoradt.adventofcode.year2019.graph.Tree;
import de.schoradt.adventofcode.year2019.graph.Tree.TreeNode;

import java.util.List;

/**
 *
 * @author Sven Schoradt (s.schoradt@infotec-edv.de)
 */
public class Day06 extends BaseDay {
    public Tree createTree(List<String> map) {
        Tree tree = new Tree();

        for(String orbit: map) {
            Pair<String, String> parsed = parseOrbit(orbit);

            //System.out.println("ADD " + parsed.getValue1() + " -> " + parsed.getValue2());

            TreeNode left = tree.getNode(parsed.getValue1());

            if (tree.getRoot() == null) {
                tree.setRoot(left);
            }

            TreeNode right = tree.getNode(parsed.getValue2());

            left.addChild(right);
        }

        return tree;
    }

    public int computeOrbitCountChecksums(Tree tree) {
        int count = 0;

        for (String name: tree.nodes()) {
            int orbits = 0;

            TreeNode node = tree.getNode(name);

            while (node.getParent() != null) {
                orbits++;

                node = node.getParent();
            }

            count += orbits;
        }

        return count;
    }

    public int moveToSanta(Tree tree) {
        int moves = 0;

        TreeNode node = tree.getNode("YOU");

        if (node == null) {
            return -1;
        }

        node = node.getParent();

        if (node == null) {
            return -1;
        }

        TreeNode lastChild = null;

        while (!santaOrbit(node)) {
            //System.out.println("MOVED TO " + node.getName());

            boolean found = false;

            // lock for santa in children
            for (TreeNode child: node.getChildren()) {
                if (lastChild == null || lastChild != child) {
                    if (searchSantaOrbit(child)) {
                        node = child;

                        moves++;

                        found = true;

                        break;
                    }
                }
            }

            // go to parent
            if (!found) {
                lastChild = node;

                node = node.getParent();

                moves++;

                if (node == null) {
                    return -1;
                }
            }
        }

        return moves;
    }

    private boolean santaOrbit(TreeNode node) {
        for (TreeNode child: node.getChildren()) {
            if (child.getName().equals("SAN")) {
                return true;
            }
        }

        return false;
    }

    private boolean searchSantaOrbit(TreeNode node) {
        if (santaOrbit(node)) {
            return true;
        }

        for (TreeNode child: node.getChildren()) {
            if (santaOrbit(child)) {
                return true;
            }

            if (searchSantaOrbit(child)) {
                return true;
            }
        }

        return false;
    }

    private Pair<String, String> parseOrbit(String orbit) {
        int index = orbit.indexOf(")");

        if (index > 0) {
            String left = orbit.substring(0, index);
            String right = orbit.substring(index + 1);

            return new Pair<>(left, right);
        }

        return new Pair<>("", "");
    }
}
