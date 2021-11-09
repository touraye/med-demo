module com.example.meddemo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.meddemo to javafx.fxml;
    exports com.example.meddemo;
}