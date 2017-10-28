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
public class Cursant { 
 
    private String nume; 
    private String prenume; 
    private long CNP; 
 
    public Cursant(String nume, String prenume, long CNP) { 
        this.nume = nume; 
        this.prenume = prenume; 
        this.CNP = CNP; 
    } 

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public long getCNP() {
        return CNP;
    }
 
    public void afisezCursant() { 
        System.out.println(nume + " " + prenume); 
    } 
} 
