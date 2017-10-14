/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laborator1;

import java.util.Scanner;

/**
 *
 * @author razvan
 */
public class Laborator1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner citire = new Scanner(System.in);
        String sir;
        System.out.println("Care este sirul dv?: ");
        sir = citire.nextLine();
        System.out.println("Sirul introdus este: " + sir);
        int nrintreg;
        double nrreal;
        boolean test;
        System.out.println("Cat este numarul intreg?: ");
        nrintreg = citire.nextInt();
        System.out.println("Numarul intreg este: " + nrintreg);
        System.out.println("Cat este numarul real?: ");
        nrreal = citire.nextDouble();
        System.out.println("Numarul real este: " + nrreal);

        System.out.println("Adevarat sau fals? (in english, please...): ");
        test = citire.nextBoolean();
        System.out.println("Varianta dv. este: " + test);

        //prelucrare sir de caractere
        int dela;
        System.out.println("De unde decupam?: (nr < " + sir.length() + ")");
        dela = citire.nextInt();
        String subsir = sir.substring(dela);
        System.out.println("Subsirul extras de la a " + dela + " litera este: " + subsir);

        //prelucrare contains
        String cauta;
        System.out.println("Introduceti cuvantul cautat: ");
        citire.nextLine();
        cauta = citire.nextLine();
        System.out.println("Metoda returneaza " + sir.contains(cauta));

        //prelucrare int
        double tva = (nrintreg * 24.) / 100.;
        System.out.println("Tva din " + nrintreg + " este: " + tva);
        //prelucrare boolean
        String rez = "ok";
        if (test) {
            System.out.println("E adevarat, deci e: " + rez);
        }
    }
}
