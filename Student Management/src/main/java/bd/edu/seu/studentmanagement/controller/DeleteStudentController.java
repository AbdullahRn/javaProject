package bd.edu.seu.studentmanagement.controller;

import bd.edu.seu.studentmanagement.service.StudentReadWrite;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class DeleteStudentController {

    @FXML
    private TextField deleteStudentField;

    @FXML
    void deleteStudentButton(ActionEvent event) {
        String id = deleteStudentField.getText();
        StudentReadWrite studentReadWrite = new StudentReadWrite();
    }

}
