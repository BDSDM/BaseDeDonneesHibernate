package com.destin.demoorm;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {





        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Fenetre.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Base de données");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}