package bd.edu.seu.studentmanagement.controller;

import bd.edu.seu.studentmanagement.HelloApplication;
import bd.edu.seu.studentmanagement.service.OfficerReadWrite;
import bd.edu.seu.studentmanagement.users.Faculty;
import bd.edu.seu.studentmanagement.users.Officer;
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
import java.util.ArrayList;
import java.util.List;
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
    Label warningMessage;

    @FXML
    void method1(KeyEvent event) {
        warningMessage.setVisible(false);
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
        warningMessage.setVisible(false);
        if(forPicture){
            if(passwordTextField.getText().length()>3){
                pass = true;
            }
            else{
                pass = false;
            }
            passs = passwordTextField.getText();
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



    String whichUser;
    @FXML
    void facultyClick(MouseEvent event) {
        facultyChoice = true;
        studentChoice = false;
        officerChoice = false;
        whichUser = "Faculty";
        System.out.println(studentChoice);
        usernameFieldText.setText("Faculty Initial:");
        warningMessage.setText("Wrong Faculty Initial or Password!!");
    }

    @FXML
    void officerClick(MouseEvent event) {
        officerChoice = true;
        studentChoice = false;
        facultyChoice = false;
        whichUser = "Officer";
        System.out.println(studentChoice);
        usernameFieldText.setText("Officer ID:");
        warningMessage.setText("Wrong Officer ID or Password!!");
    }

    @FXML
    void studentClick(MouseEvent event) {
        studentChoice = true;
        officerChoice = false;
        facultyChoice = false;
        whichUser = "Student";
        System.out.println(studentChoice);
        usernameFieldText.setText("Student ID:");
        warningMessage.setText("Wrong Student ID or Password!!");
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
   Label usernameFieldText;

    @FXML
    void loginButtonActon(ActionEvent event) {
       String id = userNameField.getText();

       if(passs.isEmpty()){
           passs = passwordField.getText();
       }


       if(officerChoice){
           List<Officer> tempList=  officerList.stream().filter(c->(c.getId().equals(id) && c.getPassword().equals(passs))).toList();
           if(tempList.size()>0){
               HelloApplication.changeScene("officerPortal.fxml");
           }
           else{
               warningMessage.setVisible(true);
           }
       }


        boolean haveMatched=false;
       //database theke data fetch kre compare krte hbe info thikase naki,
        //faculty hoile faculty database, student hoile student database, officer hoile officer database theke data ene compare kre dekhbe
        //info thik thakle ei boolean true hbe, or else false;
        if(haveMatched){
            HelloApplication.changeScene("officerLoginScene.fxml");
        }


       // HelloApplication.changeScene("officerLoginScene.fxml");
    }

    OfficerReadWrite officerReadWrite = new OfficerReadWrite();
   List<Officer> officerList = officerReadWrite.read();

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

        whichUser = "Student";
        usernameFieldText.setText("Student ID:");
        warningMessage.setText("Wrong ID or Password!!");
        warningMessage.setVisible(false);

    }
}
