package bd.edu.seu.studentmanagement.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class InfoPortalController implements Initializable {

    @FXML
    private Label cgpaHeadline;

    @FXML
    private Label cgpaLabel;

    @FXML
    private Label idHeadline;

    @FXML
    private Label idLabel;

    @FXML
    private ImageView imageView;

    @FXML
    private Label nameHeadLine;

    @FXML
    private Label nameLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(OfficerPortalController.facultyOrStudentInfo ==0){
            nameLabel.setText(OfficerPortalController.popUpStudent.getName());
            idLabel.setText(OfficerPortalController.popUpStudent.getId());
            cgpaLabel.setText(OfficerPortalController.popUpStudent.getCgpa().toString());
            cgpaHeadline.setVisible(true);
            cgpaLabel.setVisible(true);
            String path = OfficerPortalController.popUpStudent.getImageURL();
            Image image = new Image(path);
            imageView.setImage(image);
        }
        else{
            nameLabel.setText(OfficerPortalController.popUpFaculty.getName());
            idLabel.setText(OfficerPortalController.popUpFaculty.getInitial());
            idHeadline.setText("Initial:");
            cgpaHeadline.setVisible(false);
            cgpaLabel.setVisible(false);
            String path = OfficerPortalController.popUpFaculty.getImage();
            Image image = new Image(path);
            imageView.setImage(image);
        }
    }
}
