module com.homework.javahomeworkout {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.homework.javahomeworkout2 to javafx.fxml;
    exports com.homework.javahomeworkout2;
}