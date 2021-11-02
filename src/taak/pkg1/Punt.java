/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taak.pkg1;

import java.util.Random;

/**
 *
 * @author u0002531
 */
public class Punt implements Comparable<Punt> {
    private int x, y;
    
    public Punt(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    @Override
    /** vergelijk twee punten
     *  -1 als dit punt links of boven ligt tov parameter
     * 1 als dit punt rechts of onder ligt tov parameter
     * 0 als ze gelijk zijn
     */
    public int compareTo(Punt p) {
        if (x < p.x) return -1;
        if (x > p.x) return 1;
        if (y < p.y) return -1;
        if (y > p.y) return 1;
        return 0;
    }

    @Override
    public String toString() {
        return "Punt {" + "x=" + x + ", y=" + y + '}';
    }
    
    
}
