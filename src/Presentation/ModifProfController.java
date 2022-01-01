/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Presentation;

import SchoolManagementIMetier.IMetier;
import SchoolManagementIMetier.IMetierImpt;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import persistantClasse.Professeur;

/**
 * FXML Controller class
 *
 * @author ELYOUSFI
 */
public class ModifProfController implements Initializable {

    @FXML
    private AnchorPane rootPane2;
    @FXML
    private Button save;
    @FXML
    private Button cancel;
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField cin;
    @FXML
    private TextField adresse;
    @FXML
    private TextField email;
    @FXML
    private TextField tel;
    @FXML
    private TextField date;
    @FXML
    private TextField idDepart;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.nom.setText(IMetierImpt.professeur.getNom());
        this.prenom.setText(IMetierImpt.professeur.getPrenom());
        this.cin.setText(IMetierImpt.professeur.getCin());
        this.adresse.setText(IMetierImpt.professeur.getAdresse());
        this.email.setText(IMetierImpt.professeur.getEmail());
        this.tel.setText(IMetierImpt.professeur.getTelephone());
        this.date.setText(IMetierImpt.professeur.getDate_recrutement());
        this.idDepart.setText(String.valueOf(IMetierImpt.professeur.getDepartement().getId()));
    }

    @FXML
    private void save(ActionEvent event) {
        try {
            IMetier metier = new IMetierImpt();
            IMetierImpt.professeur.setNom(this.nom.getText());
            IMetierImpt.professeur.setPrenom(this.prenom.getText());
            IMetierImpt.professeur.setCin(this.cin.getText());
            IMetierImpt.professeur.setAdresse(this.adresse.getText());
            IMetierImpt.professeur.setEmail(this.email.getText());
            IMetierImpt.professeur.setTelephone(this.tel.getText());
            IMetierImpt.professeur.setDate_recrutement(this.date.getText());
            if (!this.idDepart.getText().equals("")) {
                IMetierImpt.professeur.setDepartement(metier.getDepartementById(Integer.parseInt(this.idDepart.getText())));
            }
            IMetierImpt.updateProfesseur();
        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText(ex.getMessage());
            alert.show();
        }
    }

    @FXML
    private void cancel(ActionEvent event) {
        Stage stage = (Stage) rootPane2.getScene().getWindow();
        stage.close();
    }

}
