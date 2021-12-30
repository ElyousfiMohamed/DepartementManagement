/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SchoolManagementIMetier;

import java.util.List;
import persistantClasse.Departement;
import persistantClasse.Professeur;
import DataBase.SingletonConnexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author ELYOUSFI
 */
public class IMetierImpt implements IMetier {

    public static Professeur professeur;
    
    @Override
    public void addProfesseur(Professeur p) {
        Connection conn = SingletonConnexionDB.getConnection();
        try {
            Statement pstn = conn.createStatement();
            int id;
            if(p.getDepartement() == null) 
                id=0;
            else
                id = p.getDepartement().getId();
            pstn.executeUpdate("INSERT INTO professeur(ID_DEPART,NOM_PROF,PRENOM_PROF,CIN,ADRESSE,EMAIL,TELEPHONE,DATE_RECRUTEMENT) VALUES "
                    + "(" + id + ",'"
                    + p.getNom() + "','"
                    + p.getPrenom() + "','"
                    + p.getCin() + "','"
                    + p.getAdresse() + "','"
                    + p.getEmail() + "','"
                    + p.getTelephone() + "','"
                    + p.getDate_recrutement() + "')");
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Professeur ajouté avec succés");
            alert.show();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.show();
        }
    }

    @Override
    public List<Professeur> getAllProfesseurs() {
        List<Professeur> professeurs = new ArrayList<>();
        try {
            Connection conn = SingletonConnexionDB.getConnection();
            PreparedStatement pstn = conn.prepareStatement("SELECT * FROM professeur");
            ResultSet rs = pstn.executeQuery();
            while (rs.next()) {
                Professeur p = new Professeur(rs.getInt("ID_PROF"), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
                p.setDepartement(getDepartementById(rs.getInt("ID_DEPART")));
                professeurs.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return professeurs;
    }

    @Override
    public void addDepartement(Departement d) {
        Connection conn = SingletonConnexionDB.getConnection();
        try {
            PreparedStatement pstn = conn.prepareStatement("INSERT INTO departement (NOM_DEPART) VALUES (?)");
            pstn.setString(1, d.getNom());
            pstn.executeUpdate();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Departement ajouté avec succés");
            alert.show();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.show();
        }
    }

    @Override
    public List<Departement> getAllDepartements() {
        List<Departement> departements = new ArrayList<>();
        try {
            Connection conn = SingletonConnexionDB.getConnection();
            PreparedStatement pstn = conn.prepareStatement("SELECT * FROM departement");
            ResultSet rs = pstn.executeQuery();
            while (rs.next()) {
                Departement d = new Departement(rs.getInt(1), rs.getString(2));
                for (Professeur p : getAllProfesseurs()) {
                    if (p.getDepartement().getId() == d.getId()) {
                        d.getProfesseurs().add(p);
                    }
                }
                departements.add(d);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return departements;
    }

    @Override
    public Departement getDepartementById(int id) {
        Departement d = new Departement();
        try {
            Connection conn = SingletonConnexionDB.getConnection();
            Statement pstn = conn.createStatement();
            ResultSet rs = pstn.executeQuery("SELECT * FROM departement WHERE ID_DEPART='" + id + "'");
            if (rs.next()) {
                d.setId(rs.getInt("ID_DEPART"));
                d.setNom(rs.getString("NOM_DEPART"));
            } /*else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Pas de departement avec id = " + id);
                alert.show();
            }*/

        } catch (Exception e) {
            e.printStackTrace();
        }
        return d;
    }

    @Override
    public void delProfesseur(int id) {
        try {
            Connection conn = SingletonConnexionDB.getConnection();
            Statement st = conn.createStatement();
            st.executeUpdate("DELETE FROM Professeur WHERE ID_PROF="+id);
        } catch (Exception e) {
        }
    }
    
    @Override
    public void delDepartement(int id) {
        try {
            Connection conn = SingletonConnexionDB.getConnection();
            Statement st = conn.createStatement();
            st.executeUpdate("DELETE FROM Departement WHERE ID_DEPART="+id);
        } catch (Exception e) {
        }
    }
    @Override
    public List<Professeur> searchProf(String keyWord) {
        List<Professeur> professeurs = new ArrayList<>();
        try {
            Connection connx = SingletonConnexionDB.getConnection();
            Statement stm = connx.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM professeur WHERE NOM_PROF LIKE '%"+keyWord+"%'");
            while (rs.next()) {
                Professeur p = new Professeur(rs.getInt("ID_PROF"), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
                p.setDepartement(getDepartementById(rs.getInt("ID_DEPART")));
                professeurs.add(p);
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return professeurs;
    }
    
    @Override
    public List<Departement> searchDep(String keyWord) {
        List<Departement> departements = new ArrayList<>();
        try {
            Connection connx = SingletonConnexionDB.getConnection();
            Statement stm = connx.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM departement WHERE NOM_DEPART LIKE '%"+keyWord+"%'");
            while (rs.next()) {
                Departement d = new Departement(rs.getInt(1), rs.getString(2));
                for (Professeur p : getAllProfesseurs()) {
                    if (p.getDepartement().getId() == d.getId()) {
                        d.getProfesseurs().add(p);
                    }
                }
                departements.add(d);
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return departements;
    }

}
