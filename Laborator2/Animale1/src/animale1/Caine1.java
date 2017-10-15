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
public class Caine1 {

    String nume;
    String rasa;
    int varsta;

    public Caine1(String nume, String rasa, int varsta) {
        this.nume = nume;
        this.rasa = rasa;
        this.varsta = varsta;
    }

    public void latra() {

        System.out.println(nume + " latra, face ham ham :)");

    }
}
