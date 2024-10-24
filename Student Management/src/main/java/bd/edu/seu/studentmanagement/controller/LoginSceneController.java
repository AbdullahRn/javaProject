package bd.edu.seu.studentmanagement.controller;

import bd.edu.seu.studentmanagement.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;


import java.awt.*;
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
    private Button loginButton;

    @FXML
    private ImageView eye;

    @FXML
    private ImageView eye1;

    @FXML
    private TextField passwordTextField;

    boolean user;
    boolean pass ;


    @FXML
    void method1(KeyEvent event) {
        if(userNameField.getText().length()>3){
            user = true;
        }
        else{
            user = false;
        }

        if(user && pass){
            loginButton.setDisable(false);
        }
        else{
            loginButton.setDisable(true);
        }
    }

    @FXML
    void method2(KeyEvent event) {
        if(forPicture){
            if(passwordTextField.getText().length()>3){
                pass = true;
            }
            else{
                pass = false;
            }
        }
        else{
            if(passwordField.getText().length()>3){
                pass = true;
            }
            else{
                pass = false;
            }
        }

        if(user && pass){
            loginButton.setDisable(false);
        }
        else{
            loginButton.setDisable(true);
        }
        if(user && pass){
            loginButton.setDisable(false);
        }
        else{
            loginButton.setDisable(true);
        }


    }



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


   private String picture = "";
   boolean forPicture;
   String passs ="";
   @FXML
   void imageChange(MouseEvent event) {
       eye.setVisible(forPicture);
       eye1.setVisible(!forPicture);
       if(!forPicture){
           passs = passwordField.getText();
           passwordField.setVisible(false);
           passwordTextField.setText(passs);
           passwordTextField.setVisible(true);
       }
       else{
           passs = passwordTextField.getText();
           passwordTextField.setVisible(false);
           passwordField.setText(passs);
           passwordField.setVisible(true);
       }

       forPicture = !forPicture;
       System.out.println(forPicture);
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
        loginButton.setDisable(true);

        user = false;
        pass = false;
       // forPicture = false;
//        String picName="closed-eye.png";
//        Image image = new Image(getClass().getResourceAsStream(picName));
//        eye.setImage(image);

        eye.setVisible(true);
        eye1.setVisible(false);
        forPicture = false;

        passwordTextField.setVisible(false);

    }
}
