package com.destin.demoorm;

import jakarta.persistence.*;
@Entity

@NamedQueries({@NamedQuery(name="rqt",query ="DELETE FROM Etudiant etudiant WHERE etudiant.prenom=:prenom"),
        @NamedQuery(name="aff",query ="SELECT x FROM Etudiant x")})


public class Etudiant {


    @Id
    @Column(name = "IdEtudiant")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "PrenomEtudiant")

    private String prenom;

    @Column(name = "NomEtudiant")

    private String nom;

    public Etudiant() {
    }

    public Etudiant(Integer id, String prenom, String nom) {
        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}

