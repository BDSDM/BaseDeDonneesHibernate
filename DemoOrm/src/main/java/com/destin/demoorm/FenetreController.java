package com.destin.demoorm;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.*;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class FenetreController implements Initializable {

    @FXML
    private Button ajouter;

    @FXML
    private TextField nom;

    @FXML
    private TextField prenom;

    @FXML
    private Button supprimer;

    @FXML
    private TableColumn<Etudiant, Integer> idb;
    @FXML
    private TableColumn<Etudiant, String> prenomb;

    @FXML
    private TableColumn<Etudiant, String> nomb;

    @FXML
    private TableView<Etudiant> table;

    public ObservableList<Etudiant> data = FXCollections.observableArrayList();

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("toto");


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        idb.setCellValueFactory(new PropertyValueFactory<Etudiant,Integer>("id"));
        prenomb.setCellValueFactory(new PropertyValueFactory<Etudiant,String>("prenom"));
        nomb.setCellValueFactory(new PropertyValueFactory<Etudiant,String>("nom"));
        table.setItems(data);

    }






    public void ajouter(ActionEvent actionEvent) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("toto");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Etudiant jean = new Etudiant();
        jean.setNom(nom.getText());
        jean.setPrenom(prenom.getText());




        entityManager.persist(
                jean);



        entityManager.getTransaction().commit();

        JOptionPane.showMessageDialog(null,"Elément ajouté");
        prenom.setText("");
        nom.setText("");


    }

    public void supprimer(ActionEvent actionEvent) {


        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("toto");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();



        Query query = entityManager.createNamedQuery("rqt");
        query.setParameter("prenom", prenom.getText());
        query.executeUpdate();

        entityManager.getTransaction().commit();

        JOptionPane.showMessageDialog(null,"Elément supprimé");
        prenom.setText("");

    }

    public void afficher(ActionEvent actionEvent) {




        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();



        Query query = entityManager.createNamedQuery("aff",Etudiant.class);

        List<Etudiant> resultList = query.getResultList();

        entityManager.getTransaction().commit();




//        System.out.println(resultList.get(0).getId()+" "+resultList.get(0).getPrenom()+" "+resultList.get(0).getNom());
//
//        System.out.println(resultList.get(1).getId()+" "+resultList.get(1).getPrenom()+" "+resultList.get(1).getNom());
//
//        System.out.println(resultList.get(2).getId()+" "+resultList.get(2).getPrenom()+" "+resultList.get(2).getNom());
//
//        System.out.println(resultList.get(3).getId()+" "+resultList.get(3).getPrenom()+" "+resultList.get(3).getNom());

        data.clear();

        data.addAll(resultList);




    }


}
