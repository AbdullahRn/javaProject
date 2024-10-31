package bd.edu.seu.studentmanagement.controller;

import bd.edu.seu.studentmanagement.service.FacultyReadWrite;
import bd.edu.seu.studentmanagement.service.StudentReadWrite;
import bd.edu.seu.studentmanagement.users.Faculty;
import bd.edu.seu.studentmanagement.users.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class DeleteFacultyController implements Initializable {

    @FXML
    private TextField deleteFacultyField;

    @FXML
    void deleteFacultyButton(ActionEvent event) {
        String initial = deleteFacultyField.getText();
        FacultyReadWrite facultyReadWrite = new FacultyReadWrite();
        List<Faculty> list = facultyReadWrite.read();
        List<Faculty> demoList =   list.stream().filter(c-> c.getInitial().equals(initial)).toList();
        if(demoList.size()==0){
            errorMessage.setVisible(true);
        }
        else{
            errorMessage.setVisible(false);
            facultyReadWrite.delete(initial);
            OfficerPortalController.stage.close();
        }
    }

    @FXML
    private Label errorMessage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        errorMessage.setVisible(false);
    }
}
