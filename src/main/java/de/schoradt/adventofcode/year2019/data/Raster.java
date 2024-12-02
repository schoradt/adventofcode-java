/*
 * Copyright 2019 Sven Schoradt (s.schoradt@infotec-edv.de).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.schoradt.adventofcode.year2019.data;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Sven Schoradt (s.schoradt@infotec-edv.de)
 * @param <T>
 */
public class Raster <T> {
    @Getter
    int width;
    @Getter
    int height;

    private final List<List<T>> data;

    public Raster(int x, int y) {
        width = x;
        height = y;

        data = new ArrayList<>(x);

        for (int i = 0; i < x; i++) {
            data.add(new ArrayList<>(y));

            for (int j = 0; j < y; j++) {
                data.get(i).add(null);
            }
        }
    }

    public T get(int x, int y) {
        return data.get(x).get(y);
    }

    public void set (int x, int y, T value) {
        data.get(x).set(y, value);
    }

    public boolean isViewable(int x1, int y1, int x2, int y2) {
        //System.out.println("test (" + x1 + ", " + y1 + ") (" + x2 + ", " + y2 + ")"  );

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (!((x1 == i && y1 == j) || (x2 == i && y2 == j))) {
                    if (this.get(i, j) != null) {
                        float t1 = (i - (float) x1) / ((float) x2 - (float) x1);
                        float t2 = (j - (float) y1) / ((float) y2 - (float) y1);

                        if (Objects.equals(t1, Float.NaN)) {
                            t1 = t2;
                        }

                        if (Objects.equals(t2, Float.NaN)) {
                            t2 = t1;
                        }

                        if (Objects.equals(t1, t2) && t1 > 0 && t1 < 1) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}
