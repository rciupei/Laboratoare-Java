/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animale;

public class Caine {

    //variabile
    String nume;
    String rasa;
    int varsta;
    //constructor fara parametri

    public Caine() { //se poate adauga si aici o metoda sau un print
    }

    ;
    // constructor cu un parametru
    public Caine(String nume) {
        this.nume = nume;
        System.out.println("Numele este " + nume);
    }

    ;
    // constructor cu 3 parametri
    public Caine(String numele, String rasa, int varsta) {
        nume = numele;
        this.rasa = rasa;
        this.varsta = varsta;
        System.out.println("Numele cainelui este " + nume + " rasa este " + rasa
                + " si are " + varsta + " ani.");

    }

    public void latra() {

        System.out.println(nume + " latra, face ham ham :)");

    }
}
