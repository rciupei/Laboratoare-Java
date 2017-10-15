/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animale1;

/**
 *
 * @author razvan
 */
public class Animale1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Caine1 Theo = new Caine1("Theo", "bichon", 4);
        Theo.latra();
        Theo.varsta = 3;
        Theo.rasa = "Saint Bernard";
        System.out.println(Theo.rasa);
    }

}
