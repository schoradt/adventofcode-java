/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.schoradt.adventofcode.year2019;

import de.schoradt.adventofcode.BaseDay;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author schoradt
 */
public class Day08 extends BaseDay {
    public static class Image {
        private final int x;
        private final int y;

        private final List<List<Integer>> layers;

        List<Integer> decoded;

        public Image(int x, int y) {
            this.x = x;

            this.y = y;

            this.layers = new ArrayList<>();
            this.decoded = new ArrayList<>();
        }

        public void load(String encodedImage) {
            int layerSize = x * y;

            List<Integer> actual = new ArrayList<>();

            int position = 0;

            for (char c :encodedImage.toCharArray()) {
                if (position == layerSize) {
                    layers.add(actual);

                    actual = new ArrayList<>();

                    position = 0;
                }

                actual.add(Integer.parseInt("" + c));

                position++;
            }

            // store last layer
            layers.add(actual);
        }

        public List<List<Integer>> getLayers() {
            return layers;
        }

        public void decode() {
            decoded.clear();

            int layerSize = x * y;

            for (int i = 0; i < layerSize; i++) {
                decoded.add(2);

                for (List<Integer> layer: layers) {
                    if (layer.get(i) < 2) {
                        decoded.set(i, layer.get(i));

                        break;
                    }
                }
            }
        }

        public void print() {
            for (int i = 0; i < y; i++) {
                for (int j = 0; j < x; j++) {
                    int value = decoded.get((i * x) + j);

                    if (value == 0) {
                        System.out.print(" ");
                    } else if (value == 1) {
                        System.out.print("█");
                    }
                }

                System.out.println();
            }
        }
    }

    public int processImageChecksum(int x, int y, String encodedImage) {
        Image image = new Image(x, y);

        image.load(encodedImage);

        int index = 0;

        int minIndex = 0;
        int min = Integer.MAX_VALUE;

        for (List<Integer> layer: image.getLayers()) {
            int count = count(layer, 0);

            if (count < min) {
                min = count;

                minIndex = index;
            }

            index++;
        }

        List<Integer> minLayer = image.getLayers().get(minIndex);

        return count(minLayer, 1) * count(minLayer, 2);
    }

    public void printImage(int x, int y, String encodedImage) {
        Image image = new Image(x, y);

        image.load(encodedImage);

        image.decode();

        image.print();
    }


    private int count(List<Integer> layer, int digit) {
        int count = 0;

        for (int number: layer) {
            if (number == digit) {
                count++;
            }
        }

        return count;
    }

}
