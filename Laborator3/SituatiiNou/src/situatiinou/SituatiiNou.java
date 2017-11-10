/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package situatiinou;

import java.util.Scanner;

/**
 *
 * @author razvan
 */
public class SituatiiNou {

    /**
     * @param args the command line arguments
     */
    private Cursant c[];
    private Nota n[];
    private  String denMaterie;

    public Cursant[] getC() {
        return c;
    }

    public Nota[] getN() {
        return n;
    }

    public String getDenMaterie() {
        return denMaterie;
    }
    Scanner citire = new Scanner(System.in);

    public SituatiiNou() {

        c = new Cursant[3];
        c[0] = new Cursant("Maniu", "Laura", 2670812123234L);
        c[1] = new Cursant("Ionescu", "Vitalie", 1670812123234L);
        c[2] = new Cursant("Faur", "Ionel", 1690812123222L);

        n = new Nota[6];
        n[0] = new Nota(2670812123234L, 10, "Matematica");
        n[1] = new Nota(2670812123234L, 10, "Engleza");
        n[2] = new Nota(1670812123234L, 8, "Matematica");
        n[3] = new Nota(1670812123234L, 9, "Engleza");
        n[4] = new Nota(1690812123222L, 7, "Matematica");
        n[5] = new Nota(1690812123222L, 10, "Engleza");
        // Afisez notele cursantilor
        

        denMaterie = "Matematica";
        for (Nota nt : n) {
            nt.sit = this;
        }
        System.out.println("Materia: ");
        denMaterie = citire.nextLine();
        System.out.println("\nNotele la " + denMaterie + ":");


        for (Cursant crsnt : c) {
            crsnt.afisezCursant();
            for (Nota nt : n) {
                if (crsnt.getCNP() == nt.getCNP()) {
                    nt.afisezNota();
                }
            }
            System.out.println(""); // O linie goala 

        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        SituatiiNou sit;
        sit = new SituatiiNou();

    }

}
