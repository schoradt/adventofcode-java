/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.schoradt.adventofcode.year2019.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Sven Schoradt (s.schoradt@infotec-edv.de)
 */
public class Tree {
    public static class TreeNode {
        String name;

        List<TreeNode> children;

        TreeNode parent;

        public TreeNode(String name) {
            this.name = name;

            parent = null;
            children = new ArrayList<>();
        }

        public String getName() {
            return name;
        }

        public List<TreeNode> getChildren() {
            return children;
        }

        public void addChild(TreeNode child) {
            if (child.getParent() == null) {
                children.add(child);
                child.setParent(this);
            } else {
                System.out.println("node " + child.getName() + " already used");
            }
        }

        public TreeNode getParent() {
            return parent;
        }

        public void setParent(TreeNode parent) {
            this.parent = parent;
        }
    }

    private TreeNode root;

    Map<String, TreeNode> nodes;

    public Tree() {
        root = null;

        nodes = new HashMap<>();
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public TreeNode getNode(String name) {
        if (nodes.containsKey(name)) {
            return nodes.get(name);
        }

        TreeNode node = new TreeNode(name);

        nodes.put(name, node);

        return node;
    }

    public Set<String> nodes() {
        return nodes.keySet();
    }
}
