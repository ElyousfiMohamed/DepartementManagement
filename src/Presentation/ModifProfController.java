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
    private AnchorPane rootPane;
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
            metier.delProfesseur(IMetierImpt.professeur.getId());
            Professeur p = new Professeur(this.nom.getText(), this.prenom.getText(), this.cin.getText(), this.adresse.getText(), this.email.getText(), this.tel.getText(),this.date.getText());
            if(!this.idDepart.getText().equals(""))
                p.setDepartement(metier.getDepartementById(Integer.parseInt(this.idDepart.getText())));
            metier.addProfesseur(p);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void cancel(ActionEvent event) {
        Stage stage = (Stage)rootPane.getScene().getWindow();
        stage.close();
    }
    
}
