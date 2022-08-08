module com.example.producttest {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.producttest to javafx.fxml;
    exports com.example.producttest;
}