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
package de.schoradt.adventofcode2019.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Sven Schoradt (s.schoradt@infotec-edv.de)
 * @param <T>
 */
public class Raster <T> {
    int width;
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

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    
    public void print() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (this.get(j, i) != null) {
                    System.out.println("(" + j + ", " + i + ") #");
                }
            }
        }
        
        System.out.println();
        
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (this.get(j, i) != null) {
                    System.out.print('#');
                } else {
                    System.out.print('.');
                }
            }
            
            System.out.println();
        }
        
        System.out.println();
    }
    
    public boolean isViewable(int x1, int y1, int x2, int y2) {
        //System.out.println("test (" + x1 + ", " + y1 + ") (" + x2 + ", " + y2 + ")"  );
        
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (!((x1 == i && y1 == j) || (x2 == i && y2 == j))) {
                    if (this.get(i, j) != null) {
                        float fx1 = x1;
                        float fx2 = x2;
                        float fy1 = y1;
                        float fy2 = y2;

                        Float t1 = (i - fx1) / (fx2 - fx1);
                        Float t2 = (j - fy1) / (fy2 - fy1);
                        
                        if (Objects.equals(t1, Float.NaN)) {
                            t1 = t2;
                        }
                        
                        if (Objects.equals(t2, Float.NaN)) {
                            t2 = t1;
                        }
                        
                        if (Objects.equals(t1, t2) && t1 > 0 && t1 < 1) {
                            //System.out.println("    blocked by (" + i + ", " + j + ") "  + t1 + " <> " + t2);
                            
                            return false;
                        } else {
                            //System.out.println("    not blocked by (" + i + ", " + j + ") "  + t1 + " <> " + t2);
                        }
                    }
                }
            }
        }
        
        return true;
    }
    
    private double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public boolean empty() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (this.get(i, j) != null) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
