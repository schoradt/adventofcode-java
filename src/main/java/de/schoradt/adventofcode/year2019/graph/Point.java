/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.schoradt.adventofcode.year2019.graph;

import lombok.Getter;

/**
 *
 * @author schoradt
 */
@Getter
public class Point {

    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move(String direction) {
        switch (direction) {
            case "U":
                this.moveUp();

                break;
            case "L":
                this.moveLeft();

                break;
            case "D":
                this.moveDown();

                break;
            case "R":
                this.moveRight();

                break;

        }
    }

    private void moveUp() {
        this.y += 1;
    }

    private void moveLeft() {
        this.x -= 1;
    }

    private void moveDown() {
        this.y -= 1;
    }

    private void moveRight() {
        this.x += 1;
    }

    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }

    @Override
    public int hashCode() {
        return 10000 * this.x + this.y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Point other = (Point) obj;
        if (this.x != other.x) {
            return false;
        }
        return this.y == other.y;
    }

    public int manhattenDistance(Point p) {
        return Math.abs(this.getX() - p.getX()) + Math.abs(this.getY() - p.getY());
    }
}
