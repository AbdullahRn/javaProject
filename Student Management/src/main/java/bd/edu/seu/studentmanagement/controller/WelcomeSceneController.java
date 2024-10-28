package bd.edu.seu.studentmanagement.controller;

import bd.edu.seu.studentmanagement.HelloApplication;
import bd.edu.seu.studentmanagement.service.OfficerReadWrite;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

public class WelcomeSceneController implements Initializable {

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
    private TextField nameField;

    @FXML
    void browseButtonAction(ActionEvent event) {

    }

    String imageURL = "";
    @FXML
    public void uploadPicture(ActionEvent actionEvent) {
        try {
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showOpenDialog(new Stage());
            Image image = new Image(new FileInputStream(file));
            picture.setImage(image);
            imageURL = file.toURI().toString();;
            System.out.println(imageURL);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void signupAction(MouseEvent event) {
        String id = usernameField.getText();
        String password = passwordField.getText();
        String reference = referenceField.getText();
        String name = nameField.getText();

        if(id.isEmpty() || password.isEmpty() || reference.isEmpty() || imageURL.isEmpty() || name.isEmpty()) {
            alertText.setVisible(true);
        }
        else {
            Officer officer = new Officer(name, id, password, imageURL, reference);
            OfficerReadWrite officerReadWrite = new OfficerReadWrite();
            officerReadWrite.save(officer);
            HelloApplication.changeScene("loginScene.fxml");
        }


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        alertText.setVisible(false);
    }
}
