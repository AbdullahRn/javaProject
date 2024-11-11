package bd.edu.seu.studentmanagement.popupController;

import bd.edu.seu.studentmanagement.controller.OfficerPortalController;
import bd.edu.seu.studentmanagement.service.StudentReadWrite;
import bd.edu.seu.studentmanagement.users.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class DeleteStudentController implements Initializable {

    @FXML
    private TextField deleteStudentField;

    @FXML
    void deleteStudentButton(ActionEvent event) {
        String id = deleteStudentField.getText();
        StudentReadWrite studentReadWrite = new StudentReadWrite();
        List<Student> list = studentReadWrite.read();
        List<Student> demoList =   list.stream().filter(c-> c.getId().equals(id)).toList();
        if(demoList.size()==0){
            errorMessage.setVisible(true);
        }
        else{
            errorMessage.setVisible(false);
            studentReadWrite.delete(id);
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
