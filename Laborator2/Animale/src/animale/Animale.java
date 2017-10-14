/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animale;

/**
 *
 * @author razvan
 */
public class Animale {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Caine Max = new Caine();

        Max.nume = "Max";
        Max.rasa = "Lup";
        Max.varsta = 10;

        Max.latra();
    }
}

