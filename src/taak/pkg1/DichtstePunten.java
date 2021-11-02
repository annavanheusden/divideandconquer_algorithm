/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taak.pkg1;

import java.util.Arrays;
import java.util.Optional;

/**
 *
 * @author Bram
 */
public class DichtstePunten {
    public static Optional<Oplossing> bereken(Invoer invoer){
        Punt[] punten = invoer.getInvoer();
        Arrays.sort(punten);
        return Optional.of(kortsteAfstand(punten, 0, punten.length-1));
    }
    
    static Oplossing kortsteAfstand(Punt[] punten, int links, int rechts){
        Oplossing besteOplossing;
        // als er slechts 2 punten zijn, wordt van deze punten de afstand berekend
        if(links == rechts-1){
            besteOplossing = new Oplossing(afstand2punten(punten[links].getX(), punten[links].getY(), punten[rechts].getX(), punten[rechts].getY()),punten[links],punten[rechts]);
            return besteOplossing;
        }
        // als er slechts 1 punt is, wordt een zeer grote waarde gereturnd
        else if(links == rechts){
            besteOplossing = new Oplossing(Double.MAX_VALUE, punten[links], punten[rechts]);
            return besteOplossing;
        }
        else{
            int midden = (links+rechts)/2;
            Oplossing kortsteAfstandLinks = kortsteAfstand(punten, links, midden);
            Oplossing kortsteAfstandRechts = kortsteAfstand(punten, midden+1, rechts);
            
            if(kortsteAfstandLinks.getAfstand() <= kortsteAfstandRechts.getAfstand()){
                besteOplossing = new Oplossing(kortsteAfstandLinks.getAfstand(), kortsteAfstandLinks.getPunt1(), kortsteAfstandLinks.getPunt2());
            }
            else{
                besteOplossing = new Oplossing(kortsteAfstandRechts.getAfstand(), kortsteAfstandRechts.getPunt1(), kortsteAfstandRechts.getPunt2());
            }
            
            for(int i = kleinsteBinnenBand(punten, besteOplossing.getAfstand(), midden); i < rechts && punten[i].getX()<= besteOplossing.getAfstand()+punten[midden].getX(); i++){
                for(int j = i+1; j < rechts && punten[j].getX() <= besteOplossing.getAfstand()+punten[midden].getX(); j++){
                    Oplossing tussenOplossing = new Oplossing(afstand2punten(punten[i].getX(), punten[i].getY(), punten[j].getX(), punten[j].getY()),punten[i],punten[j]);
                    
                    if(besteOplossing.getAfstand() <= tussenOplossing.getAfstand()){
                        besteOplossing = new Oplossing(besteOplossing.getAfstand(), besteOplossing.getPunt1(), besteOplossing.getPunt2());
                    }
                    else{
                        besteOplossing = new Oplossing(tussenOplossing.getAfstand(), tussenOplossing.getPunt1(), tussenOplossing.getPunt2());
                    }
                }
            }
            return besteOplossing;
        }
    }
    static double afstand2punten(double x1, double y1, double x2, double y2){
        double dx=x2-x1;
        double dy=y2-y1;
           return Math.sqrt(dx*dx+dy*dy);
    
    }
    
    static int kleinsteBinnenBand(Punt[] punten, double maxAfstand, int bandMidden){
        return kleinsteVanLijst(punten, 0, punten.length-1, maxAfstand, punten[bandMidden].getX());
    }
    
    static int kleinsteVanLijst(Punt[] punten, int begin, int einde, double maxAfstand, double bandMidden){
        int midden = ((einde+begin)/2);
        //als de punten rechts groter of gelijk zijn aan de het midden-de maximale afstand  en de punten van het midden
        if(punten[midden+1].getX() >= bandMidden-maxAfstand && punten[midden].getX() >= bandMidden-maxAfstand && einde-begin>2){
            return kleinsteVanLijst(punten, begin, midden, maxAfstand, bandMidden);
        }
        else if(punten[midden+1].getX() < bandMidden-maxAfstand && punten[midden].getX() < bandMidden-maxAfstand){
            return kleinsteVanLijst(punten, midden, einde, maxAfstand, bandMidden);
        }
        else if(punten[midden+1].getX() >= bandMidden-maxAfstand && punten[midden].getX() < bandMidden-maxAfstand){
        return midden;
        }
        else if(einde-begin <= 2){
            return midden;
        }
        else return -1;
    }
    
}
