package bd.edu.seu.studentmanagement.controller;

import bd.edu.seu.studentmanagement.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class StudentPortalController implements Initializable {


    @FXML
    private Tab gradeTab;

    @FXML
    private ImageView homeButton;

    @FXML
    private Tab homeTab;

    @FXML
    private Label labelasd;

    @FXML
    private ImageView ledgerButton;

    @FXML
    private Tab ledgerTab;

    @FXML
    private ImageView paymentButton;

    @FXML
    private Tab paymentTab;

    @FXML
    private TabPane tab;

    @FXML
    private ImageView waiverButton;

    @FXML
    private Tab waiverTab;

    @FXML
    private Tab admitCardTab;;

    @FXML
    void admitCardButtonAction(MouseEvent event) {
        tab.getSelectionModel().select(admitCardTab);
    }

    @FXML
    void gradeButtonAction(MouseEvent event) {
        tab.getSelectionModel().select(gradeTab);
    }

    @FXML
    void homeButtonAction(MouseEvent event) {
        tab.getSelectionModel().select(homeTab);
    }

    @FXML
    void ledgerButtonAction(MouseEvent event) {
        tab.getSelectionModel().select(ledgerTab);
    }

    @FXML
    void paymentButtonAction(MouseEvent event) {
        tab.getSelectionModel().select(paymentTab);
    }

    @FXML
    void waiverButtonAction(MouseEvent event) {
        tab.getSelectionModel().select(waiverTab);
    }


    @FXML
    void exitPortal(MouseEvent event) {
        HelloApplication.changeScene("loginScene.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        tab.getTabs().remove(tab2);
//        tab.getTabs().remove(tab1);
        tab.getSelectionModel().select(homeTab);
        //tab1.


    }
}
