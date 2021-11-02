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
public class Invoer {
    private Punt[] invoer;

    public Invoer(Punt[] invoer) {
        this.invoer = invoer;
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
    
    
}
