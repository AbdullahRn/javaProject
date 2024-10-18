package bd.edu.seu.studentmanagement.controller;

import bd.edu.seu.studentmanagement.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginSceneController implements Initializable {

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label signUpText;

    @FXML
    private TextField userNameField;

    @FXML
    void facultyClick(MouseEvent event) {
        facultyChoice = true;
        studentChoice = false;
        officerChoice = false;
        System.out.println(studentChoice);
    }

    @FXML
    void officerClick(MouseEvent event) {
        officerChoice = true;
        studentChoice = false;
        facultyChoice = false;
        System.out.println(studentChoice);
    }

    @FXML
    void studentClick(MouseEvent event) {
        studentChoice = true;
        officerChoice = false;
        facultyChoice = false;
        System.out.println(studentChoice);
    }

    @FXML
    void loginButtonActon(ActionEvent event) {
       // HelloApplication.changeScene("officerLoginScene.fxml");
    }

    @FXML
    void signUpAction(MouseEvent event) {

        HelloApplication.changeScene("officerSignUpScene.fxml");
    }

    boolean studentChoice;
    boolean officerChoice;
    boolean facultyChoice;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        studentChoice = true;
        officerChoice = false;
        facultyChoice = false;
    }
}
