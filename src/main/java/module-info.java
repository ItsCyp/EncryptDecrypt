module com.ccyprian.encryptdecrypt {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.ccyprian.encryptdecrypt to javafx.fxml;
    exports com.ccyprian.encryptdecrypt;
}