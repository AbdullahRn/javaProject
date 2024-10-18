package bd.edu.seu.studentmanagement.controller;

import bd.edu.seu.studentmanagement.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class WelcomeSceneController {

    @FXML
    private Label alertText;

    @FXML
    private Button browseButton;

    @FXML
    private PasswordField passwordField;

    @FXML
    private ImageView picture;

    @FXML
    private PasswordField referenceField;

    @FXML
    private ImageView signUp;

    @FXML
    private TextField usernameField;

    @FXML
    void browseButtonAction(ActionEvent event) {

    }

    @FXML
    void signupAction(MouseEvent event) {
        HelloApplication.changeScene("loginScene.fxml");
    }

}
