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
public class Nota {

    long CNP;
    double nota;
    String materia;

    public Nota(long CNP, double nota, String materia) {
        this.CNP = CNP;
        this.nota = nota;
        this.materia = materia;
    }

    public void afisezNota() {
        System.out.println(" " + nota + " la " + materia);
    }

}
