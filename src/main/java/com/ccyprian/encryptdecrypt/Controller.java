package com.ccyprian.encryptdecrypt;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Base64;

public class Controller {
    @FXML private Button encryptButton;
    @FXML private TextField decryptedText;
    @FXML private TextArea encryptedText;
    @FXML private VBox parent;

    Main main = new Main();

    @FXML
    public void initialize() {
        encryptButton.setOnAction(event ->{
            EncryptButton();
        });

        parent.setOnKeyPressed(event -> {
            if(event.getCode() == KeyCode.ENTER){
                PressedEnter();
            }
            if(event.getCode() == KeyCode.ESCAPE){
                Close();
            }
        });
    }

    @FXML
    private void EncryptButton(){
        if(!decryptedText.getText().isEmpty()){
            encryptedText.clear();
            Base64.Encoder encoder = Base64.getEncoder();
            String text = decryptedText.getText();
            String encodedString = encoder.encodeToString(text.getBytes());

            encryptedText.appendText("-> Encrypted Text: " + encodedString + "\n");
            Base64.Decoder decoder = Base64.getDecoder();
            byte[] bytes = decoder.decode(encodedString);

            encryptedText.appendText("-> Decrypted Text: " + new String(bytes));
        }else{
            encryptedText.clear();
            encryptedText.appendText("Error: The text field is empty.\n");
            encryptedText.appendText("\nPlease be sure to fill in the request fields.");
        }
    }

    @FXML
    private void PressedEnter(){
        EncryptButton();
    }

    @FXML
    private void Close(){
        Stage stage = (Stage) parent.getScene().getWindow();
        stage.close();
        System.exit(1);
    }
}