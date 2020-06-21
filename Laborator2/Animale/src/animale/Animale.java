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
        // se creeaza 3 obiecte din clasa Caine, folosind 3 constructori diferiti
        Caine Max = new Caine();
        Caine Dora = new Caine("Dora", "Lup", 3);
        Caine Rex = new Caine("Rex");

        Max.nume = "Max";
        Max.rasa = "Lup";
        Max.varsta = 10;

        Max.latra();
    }
}

