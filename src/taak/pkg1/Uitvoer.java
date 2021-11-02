/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taak.pkg1;

import java.util.Optional;

/**
 *
 * @author Bram
 */
public class Uitvoer {
    private Punt[] invoer;
    private Optional<Oplossing> kortstePunten;

    public Uitvoer(Punt[] invoer, Optional<Oplossing> kortstePunten) {
        this.invoer = invoer;
        this.kortstePunten = kortstePunten;
    }

    /**
     * @return the invoer
     */
    public Punt[] getInvoer() {
        return invoer;
    }

    /**
     * @param invoer the invoer to set
     */
    public void setInvoer(Punt[] invoer) {
        this.invoer = invoer;
    }

    /**
     * @return the kortstePunten
     */
    public Optional<Oplossing> getKortstePunten() {
        return kortstePunten;
    }

    /**
     * @param kortstePunten the kortstePunten to set
     */
    public void setKortstePunten(Optional<Oplossing> kortstePunten) {
        this.kortstePunten = kortstePunten;
    }
    
    
}
