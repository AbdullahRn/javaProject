package bd.edu.seu.studentmanagement.popupController;

import bd.edu.seu.studentmanagement.HelloApplication;
import bd.edu.seu.studentmanagement.service.CurrentSemesterDecider;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class SelectSemesterController implements Initializable {

    @FXML
    private ChoiceBox<String> semesterChoiceBox;

    @FXML
    void saveAction(ActionEvent event) {
        String semester = semesterChoiceBox.getSelectionModel().getSelectedItem();
        if(semester!=null){
            HelloApplication.currentSemester = semester;
            CurrentSemesterDecider c = new CurrentSemesterDecider();
            c.save();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<String> list = new ArrayList<>(List.of("Spring 24", "Summer 24", "Fall 24"));
        ObservableList<String> obsList = FXCollections.observableArrayList(list);
        semesterChoiceBox.setItems(obsList);
    }
}
