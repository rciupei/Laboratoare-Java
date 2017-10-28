/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package situatiinou;

/**
 *
 * @author razvan
 */
public class Nota {

    private long CNP;
    private double nota;
    private String materia;
    SituatiiNou sit;

    public Nota(long CNP, double nota, String materia) {
        this.CNP = CNP;
        this.nota = nota;
        this.materia = materia;
        
    }

    public long getCNP() {
        return CNP;
    }

    public double getNota() {
        return nota;
    }

    public String getMateria() {
        return materia;
    }

    public void afisezNota() {
        if (materia.equals(sit.getDenMaterie())) {
            System.out.println(" " + nota + " la " + materia);
        }
    }
}
