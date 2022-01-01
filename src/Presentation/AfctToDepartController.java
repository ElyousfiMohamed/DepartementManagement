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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ELYOUSFI
 */
public class AfctToDepartController implements Initializable {

    @FXML
    private TextField idDepart;
    @FXML
    private AnchorPane rt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void affecter(ActionEvent event) {
        IMetier metier = new IMetierImpt();
         if(!this.idDepart.getText().equals(""))
            IMetierImpt.professeur.setDepartement(metier.getDepartementById(Integer.parseInt(this.idDepart.getText())));
        IMetierImpt.updateProfesseur();
    }

    @FXML
    private void cancel(ActionEvent event) {
        Stage stage = (Stage)rt.getScene().getWindow();
        stage.close();
    }
    
}
