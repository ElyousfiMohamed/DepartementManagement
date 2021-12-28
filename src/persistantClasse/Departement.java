/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistantClasse;

import java.util.List;

/**
 *
 * @author ELYOUSFI
 */
public class Departement {
    private int id;
    private String nom;
    private List<Professeur> professeurs;

    public Departement(int id, String nom, List<Professeur> professeurs) {
        this.id = id;
        this.nom = nom;
        this.professeurs = professeurs;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public List<Professeur> getProfesseurs() {
        return professeurs;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setProfesseurs(List<Professeur> professeurs) {
        this.professeurs = professeurs;
    }

    @Override
    public String toString() {
        return "Departement{" + "id=" + id + ", nom=" + nom + "}";
    }
}
