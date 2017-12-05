/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienti;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author razvan
 */
public class Client {
     SimpleStringProperty nume;
     SimpleStringProperty prenume;
     SimpleStringProperty email;

public Client(String nume, String prenume, String email) {
      this.nume = new SimpleStringProperty(nume);
      this.prenume = new SimpleStringProperty(prenume);
      this.email = new SimpleStringProperty(email);
   }
}
