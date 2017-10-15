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
public class Situatii {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // Generez sirul cursantilor
        Cursant c[];
        c = new Cursant[3];
        c[0] = new Cursant("Maniu", "Laura", 2670812123234L);
        c[1] = new Cursant("Ionescu", "Vitalie", 1670812123234L);
        c[2] = new Cursant("Faur", "Ionel", 1690812123222L);

// Generez notele
        Nota n[] = new Nota[6];
        n[0] = new Nota(2670812123234L, 10, "Matematica");
        n[1] = new Nota(1690812123222L, 7, "Matematica");
        n[2] = new Nota(1670812123234L, 8, "Matematica");
        n[3] = new Nota(1690812123222L, 10, "Engleza");
        n[4] = new Nota(2670812123234L, 10, "Engleza");
        n[5] = new Nota(1670812123234L, 9, "Engleza");
        // Afisez notele cursantilor
        for (Cursant crsnt : c) {
            crsnt.afisezCursant();
            for (Nota nt : n) {
                if (crsnt.CNP == nt.CNP) {
                    nt.afisezNota();
                }
            }
            System.out.println(""); // O linie goala
        }
    }

}
