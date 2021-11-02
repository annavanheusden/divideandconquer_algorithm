/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taak.pkg1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bram Claessen
 */
public class Taak1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){        
        FileReader bestand = null;
        FileWriter bestandUit = null;
        try {
            //lees invoer in uit JSON
            GsonBuilder builder = new GsonBuilder();
            builder.setPrettyPrinting();
            Gson gsonner = builder.create();
            bestand = new FileReader(args[0]);
            Invoer[] alleGevallen = gsonner.fromJson(bestand, Invoer[].class);

            Uitvoer[] uitkomsten = new Uitvoer[alleGevallen.length];
            for (int i = 0; i<alleGevallen.length; i++){
                Optional<Oplossing> opl = DichtstePunten.bereken(alleGevallen[i]);
                uitkomsten[i] = new Uitvoer(alleGevallen[i].getInvoer(), opl);
            }
            // schrijf uitvoer weg in JSON
            bestandUit = new FileWriter(args[0]+".uit.txt");
            String jsonUit = gsonner.toJson(uitkomsten);
            bestandUit.write(jsonUit);
        } catch (IOException ex) {
            Logger.getLogger(Taak1.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                bestand.close();
                bestandUit.close();
            } catch (IOException ex) {
                Logger.getLogger(Taak1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    } 
}
