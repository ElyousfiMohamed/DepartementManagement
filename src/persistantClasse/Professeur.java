/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistantClasse;

import java.util.Date;

/**
 *
 * @author ELYOUSFI
 */
public class Professeur {
    private int id;
    private String nome;
    private String prenom;
    private String cin;
    private String adresse;
    private String email;
    private String telephone;
    private Date date_recrutement;
    private Departement departement;

    public Professeur(int id, String nome, String prenom, String cin, String adresse, String email, String telephone, Date date_recrutement, Departement departement) {
        this.id = id;
        this.nome = nome;
        this.prenom = prenom;
        this.cin = cin;
        this.adresse = adresse;
        this.email = email;
        this.telephone = telephone;
        this.date_recrutement = date_recrutement;
        this.departement = departement;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getCin() {
        return cin;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    public Date getDate_recrutement() {
        return date_recrutement;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setDate_recrutement(Date date_recrutement) {
        this.date_recrutement = date_recrutement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    @Override
    public String toString() {
        return "Proffeseur{" + "id=" + id + ", nome=" + nome + ", prenom=" + prenom + ", cin=" + cin + ", adresse=" + adresse + ", email=" + email + ", telephone=" + telephone + ", date_recrutement=" + date_recrutement + "}";
    }
    
    
}
