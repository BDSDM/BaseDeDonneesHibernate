module com.destin.demoorm {
    requires javafx.controls;
    requires javafx.fxml;


    requires java.sql;
    requires java.desktop;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;



    opens com.destin.demoorm ;
    exports com.destin.demoorm;
}