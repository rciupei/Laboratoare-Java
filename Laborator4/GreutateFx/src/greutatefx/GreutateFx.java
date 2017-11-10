/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greutatefx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author razvan
 */
public class GreutateFx extends Application {

    private TextField h;
    private TextField v;
    private CheckBox s;
    private TextField g;

    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Label inaltimea = new Label("Inaltimea (cm) :");
        grid.add(inaltimea, 0, 0); // coloana 0 randul 0
        h = new TextField();
        grid.add(h, 1, 0); // Coloana 1 randul 0
        Label varsta = new Label("Varsta (ani) :");
        grid.add(varsta, 0, 1); // coloana 0 randul 1
        v = new TextField();
        grid.add(v, 1, 1); // Coloana 1 randul 1
        s = new CheckBox();
        s.setText("Barbat");
        s.setSelected(true);
        GridPane.setHalignment(s, HPos.CENTER); // afisare in centrul celulei
        grid.add(s, 0, 2, 2, 1); // col. 0 randul 2, pe doua coloane unite
        Label greutatea = new Label("Greutatea ideala (Kg) :");
        grid.add(greutatea, 0, 3); // coloana 0 randul 3
        g = new TextField();
        grid.add(g, 1, 3); // Coloana 1 randul 3
        Button calcul = new Button();
        calcul.setText("Calcul");
        GridPane.setHalignment(calcul, HPos.CENTER); // afisare in centrul celulei
        grid.add(calcul, 0, 4); // Coloana 0 randul 4
        Button gata = new Button();
        gata.setText("Iesire");
        GridPane.setHalignment(gata, HPos.CENTER); // afisare in centrul celulei
        grid.add(gata, 1, 4); // Coloana 0 randul 4

        calcul.setOnAction(
                new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                calculGreutate();
            }
        });
        gata.setOnAction(
                new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });

        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(btn);

        Scene scene = new Scene(grid, 350, 230);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Greutate");
        primaryStage.show();
    }

    public void calculGreutate() {
        double hh = Double.parseDouble(h.getText());
        double vv = Double.parseDouble(v.getText());
        double gg = 50. + 0.75 * (hh - 150.) + 0.25 * (vv - 20.);
        if (!s.isSelected()) {
            gg = gg * 0.9;
        }
        g.setText(String.valueOf(gg));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
