package proiectjava;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class EcPrincipalController {

    Baza baza;

    public void setBaza(Baza baza) {
        this.baza = baza;
    }

    Connection cnx;
    Statement stmt;
    int linia;
    ArrayList<String> lPoze;
    int pozaCurenta;

    @FXML
    private ImageView poza;


    @FXML
    private WebView harta;

    @FXML
    private TableView<OExcursie> tabel;

    @FXML
    private TableColumn<OExcursie, String> cDestinatie;

    @FXML
    private TableColumn<OExcursie, String> cData;

    @FXML
    private TableColumn<OExcursie, Integer> cDurata;

    @FXML
    private TextArea impresie;
    
    
    @FXML
    private WebView harta1;

    @FXML
    void iesire(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    public void inainte(ActionEvent event) {
        // Preiau urmatorul fisier din lista fisierelor cu imagini
        if (linia >= 0 && pozaCurenta >= 0) // Exista o excursie selectata
        {
            // Avansez o pozitie in lista lpoze
            pozaCurenta++;
            if (pozaCurenta >= lPoze.size()) {
                pozaCurenta = 0; // O iau de la inceput
            }
            afisarepoza();
        }
    }

    @FXML
    public void inapoi(ActionEvent event) {
        // Preiau fisierul precedent din listafisierelor
        if (linia >= 0 && pozaCurenta >= 0) // Exista o excursie selectata
        {
            // Vin pe poz. anterioara in lista lpoze
            pozaCurenta--;
            if (pozaCurenta < 0) {
                pozaCurenta = lPoze.size() - 1; // O iau de la capat
            }
            afisarepoza();
        }
    }

    private String apostrof(String s) {
        return "'" + s + "'";
    }

    @FXML
    void salveaza(ActionEvent event) {
        //  S-au modificat impresiile.
        //  Preiau cheia primara
        int id = tabel.getItems().get(linia).id;
        //  Pregatesc c-da update
        String cda = "UPDATE Excursii "
                + "SET impresie = " + apostrof(impresie.getText())
                + "WHERE id=" + id;
        //System.out.println("cda: " + cda); //  Pt. testare
        try {
            stmt.executeUpdate(cda);
        } catch (SQLException ex) {
            Logger.getLogger(EcPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
        //  Repopulez tabelul
        populez();
    }

    @FXML
    void initialize() {

        lPoze = new ArrayList();
        cDestinatie.setCellValueFactory(cellData -> cellData.getValue().destinatie);
        cData.setCellValueFactory(cellData -> cellData.getValue().data);
        cDurata.setCellValueFactory(cellData -> cellData.getValue().durata.asObject());
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cnx = DriverManager.getConnection("jdbc:mysql://localhost/Excubd?characterEncoding=utf8", "root", "");
            System.out.println("Conectare ok.");
            stmt = cnx.createStatement();
            //  Creez multimea de selectie continand datele din 
            //  tabelul Excursii
            populez();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(EcPrincipalController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        tabel.getSelectionModel().selectedIndexProperty().
                addListener((ov, valVeche, valNoua) -> {
                    // Se trateaza schimbarea starii. 
                    // valNoua da pozitia noii valori selectate în tabel
                    linia = (int) valNoua;
                    // Preiau informatiile din linia selectata
                    if (linia >= 0) {
                        OExcursie a = tabel.getItems().get(linia);
                        impresie.setText(a.impresie);
                        // Pentru linia selectata creez lista de imagini si afisez prima poza
                        pozaexc();
                        //  Idem, afisez o harta (Google Maps) cu un marcaj in pozitia
                        // avand coordonatele date
                        afiharta();
                    }
                });
    }

    private void validare(String nume, String parola) {

        String cda = "select * from utilizatori ";
//                + "where id = "
//                + categ + " order by nume";
        //System.out.println("cda: " + cda);
        ResultSet rs;
        try {
            Statement stm;
            stm = cnx.createStatement();
            rs = stm.executeQuery(cda);
            while (rs.next()) {
                if (nume.equals(rs.getString("Nume")) && parola.equals(rs.getString("Parola"))) {
                    initialize();
                    populez();
                    System.out.println(rs.getInt("id"));
                } else {
//                    eroare.setText("Utilizator sau parola incorecte");
//                    eroare.setTextFill(Color.web("red"));
                    //System.out.println("inexistent");
                }
                //System.out.println(rs.getString("Nume"));
            }
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(EcPrincipalController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void populez() {
        try {
            //  Golesc lista atasata tabelului
            tabel.getItems().clear();
            
            //  Citesc din baza de date
            String cda = "select * from Excursii order by destinatie";
            ResultSet rs = stmt.executeQuery(cda);
            
            while (rs.next()) {
                int id = rs.getInt("ID");
                String destinatie = rs.getString("DESTINATIE");
                String data = rs.getDate("DATA").toString();
                int durata = rs.getInt("DURATA");
                double latitudine = rs.getDouble("LATITUDINE");
                double longitudine = rs.getDouble("LONGITUDINE");
                String calepoze = rs.getString("CALEPOZE");
                String impresie = rs.getString("IMPRESIE");
                int utilizator = rs.getInt("utilizator");

                //  Creez un obiect din clasa OExcursie
                OExcursie e = new OExcursie(id, destinatie, data, durata,
                        latitudine, longitudine, calepoze, impresie);
                //  Adaug obiectul in tabel
                tabel.getItems().add(e);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EcPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void pozaexc() {
        String director = tabel.getItems().get(linia).calepoze;
        //  Caut toate pozele din director
        String fisier;
        File folder = new File(director);
        File[] listaFisierelor = folder.listFiles();
        lPoze.clear();
        //  Caut un fisier .jpg sau .png
        for (int i = 0; i < listaFisierelor.length; i++) {
            if (listaFisierelor[i].isFile()) {
                fisier = listaFisierelor[i].getName();
                if (fisier.endsWith(".jpg") || fisier.endsWith(".JPG") || fisier.endsWith(".png") || fisier.endsWith(".PNG")) //  Adaug calea in lista lPoze
                {
                    lPoze.add(director + fisier);
                }
            }
        }
        //  Afisez prima poza (daca exista)
        if (lPoze.size() > 0) {
            pozaCurenta = 0;  //  prima poza
            afisarepoza();
        } else {
            pozaCurenta = -1;
        }
    }

    public void interogare_date(int id) {
        String cda = "select * from Utilizatori ";
//                + "where id = "
//                + categ + " order by nume";
        //System.out.println("cda: " + cda);
        ResultSet rs;
        try {
            Statement stm;
            stm = cnx.createStatement();
            rs = stm.executeQuery(cda);
            while (rs.next()) {
                if (id == rs.getInt("Id_util")) {
                   
//                    //System.out.println(rs.getInt("id"));
//                } else {
////                    eroare.setText("Utilizator sau parola incorecte");
////                    eroare.setTextFill(Color.web("red"));
//                    //System.out.println("inexistent");
//                }
            //System.out.println(rs.getString("Nume"));
            
            System.out.println("utilizatorul este" + rs.getString("Nume"));}}
            
            
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(EcPrincipalController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void afisarepoza() {
        InputStream inputStream;
        try {
            String cale = lPoze.get(pozaCurenta);
            System.out.println("Cale: " + cale);
            inputStream = new FileInputStream(cale); //director + fisier;
            Image img = new Image(inputStream);
            poza.setImage(img);
            poza.fitWidthProperty().bind(img.widthProperty());

            poza.setPreserveRatio(true);
            poza.setSmooth(true);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EcPrincipalController.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }

    public void afiharta() {
        double latit = tabel.getItems().get(linia).latitudine;
        double longit = tabel.getItems().get(linia).longitudine;
        SimpleStringProperty nume = tabel.getItems().get(linia).destinatie;
        String cale = null;
        //  Generez fisierul harta.html
        String continutFisier = "<html>\n<head>\n";
        continutFisier += "<script type=\"text/javascript\" src=\"http://maps.google.com/maps/api/js?sensor=false\"></script>\n";
        continutFisier += "<script type=\"text/javascript\">\n";
        continutFisier += "function initialize(){";
        continutFisier += "var centruHarta = new google.maps.LatLng(" + latit + ", " + longit + ");\n";
        continutFisier += "var optiuniHarta = {zoom: 14,center: "
                + "centruHarta,mapTypeId: google.maps.MapTypeId.ROADMAP};\n";
        continutFisier += "var harta = new google.maps.Map(document.getElementById(\"map\"), optiuniHarta);\n";
        continutFisier += "var optMarker = {position: centruHarta,map: "
                + "harta,title: \"Aici\"};\n";
        continutFisier += "var marker = new google.maps.Marker(optMarker);\n}\n";
        continutFisier += "</script>\n</head>\n";
        continutFisier += "<body onload=\"initialize()\">\n";
        continutFisier += "<div id=\"map\" style=\"padding:0; margin: 0; "
                + "width:272px; height:190px\"></div>\n";
        continutFisier += "</body>\n</html>\n";
        try {
            // Creez pe disc fişierul locatie.html 
            File fo = new File("locatie.html");
            FileWriter fstream = new FileWriter(fo);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(continutFisier);
            // Inchid fisierul
            out.close();
            cale = fo.getAbsolutePath();
            //  Incarc harta
            WebEngine webEngine = harta.getEngine();
            System.out.println("numele e "+nume.getValue());
            webEngine.load("https://en.m.wikipedia.org/wiki/" + nume.getValue());
            WebEngine webEngine1 = harta1.getEngine();
            webEngine1.load("file:///" + cale);
        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
    }
}
