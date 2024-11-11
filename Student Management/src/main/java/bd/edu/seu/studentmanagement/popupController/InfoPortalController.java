package bd.edu.seu.studentmanagement.popupController;

import bd.edu.seu.studentmanagement.controller.OfficerPortalController;
import bd.edu.seu.studentmanagement.service.CourseListSave;
import bd.edu.seu.studentmanagement.service.FacultyReadWrite;
import bd.edu.seu.studentmanagement.service.StudentReadWrite;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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

    @FXML
    private Button deleteButton;

    @FXML
    void deleteButtonAction(ActionEvent event) {
        if(OfficerPortalController.facultyOrStudentInfo ==0){
            StudentReadWrite studentReadWrite = new StudentReadWrite();
            studentReadWrite.delete(OfficerPortalController.popUpStudent.getId());
            OfficerPortalController.stage.close();
        }else{
            FacultyReadWrite facultyReadWrite = new FacultyReadWrite();
            facultyReadWrite.delete(OfficerPortalController.popUpFaculty.getInitial());
            OfficerPortalController.stage.close();

        }
    }

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
        deleteButton.setVisible(false);


    }
}

