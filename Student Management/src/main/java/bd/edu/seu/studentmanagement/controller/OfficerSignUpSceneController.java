package bd.edu.seu.studentmanagement.controller;

import bd.edu.seu.studentmanagement.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class OfficerSignUpSceneController {

    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField referenceCodeField;

    @FXML
    private TextField userNameField;

    @FXML
    void exit(ActionEvent event) {
        HelloApplication.changeScene("loginScene.fxml");
    }

    @FXML
    void signUpButtonAction(ActionEvent event) {
        HelloApplication.changeScene("loginScene.fxml");
    }


}
