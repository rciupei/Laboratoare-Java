/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package situatii;

/**
 *
 * @author razvan
 */
public class Cursant {

    String nume;
    String prenume;
    long CNP;

    public Cursant(String nume, String prenume, long CNP) {
        this.nume = nume;
        this.prenume = prenume;
        this.CNP = CNP;
    }

    public void afisezCursant() {
        System.out.println(nume + " " + prenume);
    }
}
