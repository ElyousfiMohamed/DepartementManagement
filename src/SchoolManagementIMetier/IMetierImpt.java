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
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ELYOUSFI
 */
public class IMetierImpt implements IMetier {

    @Override
    public void addProfesseur(Professeur p) {
        Connection conn = SingletonConnexionDB.getConnection();
        try {
            PreparedStatement pstn = conn.prepareStatement("INSERT INTO professeur(ID_DEPART,NOM_PROF,PRENOM_PROF,CIN,ADRESSE,EMAIL,TELEPHONE,DATE_RECRUTEMENT) VALUES (?,?,?,?,?,?,?,?)");
            pstn.setInt(1, p.getDepartement().getId());
            pstn.setString(2, p.getNom());
            pstn.setString(3, p.getPrenom());
            pstn.setString(4, p.getCin());
            pstn.setString(5, p.getAdresse());
            pstn.setString(6, p.getEmail());
            pstn.setString(7, p.getTelephone());
            pstn.setString(8, p.getDate_recrutement());
            pstn.executeUpdate();
        } catch (SQLException e) {
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
                Professeur p = new Professeur(rs.getInt(0), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
                p.setDepartement(getDepartementById(rs.getInt(1)));
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
        } catch (Exception e) {
            e.printStackTrace();
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
                Departement d = new Departement(rs.getInt(0), rs.getString(1));
                for(Professeur p : getAllProfesseurs()) {
                    if(p.getDepartement().getId() == d.getId()) 
                        d.getProfesseurs().add(p);
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
            PreparedStatement pstn = conn.prepareStatement("SELECT * FROM departement WHERE ID_DEPART="+id);
            ResultSet rs = pstn.executeQuery();
            rs.next();
            d.setId(rs.getInt(0));
            d.setNom(rs.getString(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return d;
    }

}
