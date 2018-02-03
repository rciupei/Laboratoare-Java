/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proiectjava;

/**
 *
 * @author razvan
 */
import javafx.beans.property.SimpleIntegerProperty; 
import javafx.beans.property.SimpleStringProperty; 
public class OExcursie { 
    int id; 
    SimpleStringProperty destinatie; 
    SimpleStringProperty data; 
    SimpleIntegerProperty durata; 
    double latitudine; 
    double longitudine; 
    String calepoze; 
    String impresie; 

    public OExcursie(int id, String destinatie, String data, int durata, 
            double latitudine, double longitudine, String calepoze, String impresie) { 
        this.id = id; 
        this.destinatie = new SimpleStringProperty(destinatie); 
        this.data = new SimpleStringProperty(data); 
        this.durata = new SimpleIntegerProperty(durata); 
        this.latitudine = latitudine; 
        this.longitudine = longitudine; 
        this.calepoze = calepoze; this.impresie = impresie; 
    } 
}