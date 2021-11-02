/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taak.pkg1;

/**
 *
 * @author Bram
 */
public class Oplossing {
    private double afstand;
    private Punt punt1;
    private Punt punt2;

    public Oplossing(double afstand, Punt punt1, Punt punt2) {
        this.afstand = afstand;
        this.punt1 = punt1;
        this.punt2 = punt2;
    }

    /**
     * @return the afstand
     */
    public double getAfstand() {
        return afstand;
    }

    /**
     * @param afstand the afstand to set
     */
    public void setAfstand(double afstand) {
        this.afstand = afstand;
    }

    /**
     * @return the punt1
     */
    public Punt getPunt1() {
        return punt1;
    }

    /**
     * @param punt1 the punt1 to set
     */
    public void setPunt1(Punt punt1) {
        this.punt1 = punt1;
    }

    /**
     * @return the punt2
     */
    public Punt getPunt2() {
        return punt2;
    }

    /**
     * @param punt2 the punt2 to set
     */
    public void setPunt2(Punt punt2) {
        this.punt2 = punt2;
    }
    
}
