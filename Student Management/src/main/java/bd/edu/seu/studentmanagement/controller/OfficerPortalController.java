package bd.edu.seu.studentmanagement.controller;

import bd.edu.seu.studentmanagement.HelloApplication;
import bd.edu.seu.studentmanagement.service.FacultyReadWrite;
import bd.edu.seu.studentmanagement.service.StudentReadWrite;
import bd.edu.seu.studentmanagement.users.Faculty;
import bd.edu.seu.studentmanagement.users.Student;
import javafx.beans.Observable;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class OfficerPortalController implements Initializable {


    @FXML
    private ImageView admitCardButton;

    @FXML
    private Tab admitCardTab;

    @FXML
    private Label assignStudentGpa;

    @FXML
    private TextField assignStudentHscField;

    @FXML
    private Label assignStudentID;

    @FXML
    private TextField assignStudentIdField;

    @FXML
    private Label assignStudentName;

    @FXML
    private TextField assignStudentNameField;

    @FXML
    private ImageView assignStudentPicture;

    @FXML
    private Button assignStudentPictureButton;

    @FXML
    private Button confirmButton;

    @FXML
    private TextField assignStudentSemesterField;

    @FXML
    private Label assignWaiverAmount;

    @FXML
    private ImageView gradeButton;

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
    private PasswordField assignStudentPasswordField;

    //@FXML
    //private Label assignFacultyCredits;

    @FXML
    private TextField assignFacultyField;

    @FXML
    private Label assignFacultyInitial;

    @FXML
    private Label assignFacultyName;

    @FXML
    private TextField assignFacultyNameField;

    @FXML
    private PasswordField assignFacultyPasswordField;

    @FXML
    private ImageView assignFacultyPicture;

    @FXML
    private Button assignFacultyPictureButton;

    @FXML
    private TextField assignFacultySemesterField;

    @FXML
    private TextField facultySearchBar;

    @FXML
    private Label assignFacultyCreditsText;

    @FXML
    private Button confirmButtonFaculty;



    //////////////////////////////////////////////////////////////////////////////////

    @FXML
    private Tab waiverTab;

    private String facultyImageUrl;

    @FXML
    void uploadFacultyPicture(ActionEvent event) {
        try {
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showOpenDialog(new Stage());
            Image image = new Image(new FileInputStream(file));
            assignFacultyPicture.setImage(image);
            facultyImageUrl = file.toURI().toString();;
            System.out.println(imageUrl);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void searchFaculty(KeyEvent event) {
        String search = facultySearchBar.getText().toLowerCase();
        FacultyReadWrite facultyReadWrite = new FacultyReadWrite();
        List<Faculty> list = facultyReadWrite.read();
        List<Faculty> searchList = list.stream().filter(c-> (c.getName()+c.getInitial()+c.getCredits()).toLowerCase().contains(search)).toList();

        ObservableList<Faculty> obsList = FXCollections.observableArrayList(searchList);
        facultyTable.setItems(obsList);

    }

    @FXML
    private TextField studentSearchBar;

    @FXML
    void searchStudent(KeyEvent event) {
        String search = studentSearchBar.getText().toLowerCase();
        StudentReadWrite studentReadWrite = new StudentReadWrite();
        List<Student> list = studentReadWrite.read();
        List<Student> searchList = list.stream().filter(c-> (c.getName()+c.getId()+ c.getCgpa().toString()+ c.getWaiver().toString()).toLowerCase().contains(search)).toList();

        ObservableList<Student> obsList = FXCollections.observableArrayList(searchList);
        studentTable.setItems(obsList);

    }


    @FXML
    private TableColumn<Faculty, Number> facultyCreditColumn;

    @FXML
    private TableColumn<Faculty, String> facultyInitialColumn;

    @FXML
    private TableColumn<Faculty, String> facultyNameColumn;

    @FXML
    private TableView<Faculty> facultyTable;

    @FXML
    private TableColumn<Student, Number> studentCgpaColumn;

//    @FXML
//    private TableColumn<Student, Number> studentDueColumn;

    @FXML
    private TableColumn<Student, String > studentIdColumn;

    @FXML
    private TableColumn<Student, String> studentNameColumn;

    @FXML
    private TableView<Student> studentTable;

    @FXML
    private TableColumn<Student, Number> studentWaiverColumn;


    void counterForStudentAssignSlotsClearMethod(){
        assignStudentNameField.setText("");
        assignStudentIdField.setText("");
        assignStudentHscField.setText("");
        assignStudentPasswordField.setText("");
        String path = "file:/I:/Github Repo/Student Management/src/main/resources/bd/edu/seu/studentmanagement/WelcomeScenePictures/ezgif-2-63d3b7c290.jpg" ;
        Image image = new Image(path);
        assignStudentPicture.setImage(image);
        assignStudentName.setText("");
        assignStudentID.setText("");
        assignStudentNameField.setText("");
        assignWaiverAmount.setText("");
        assignStudentGpa.setText("");



    }

    void counterForFacultyAssignSlotsClearMethod(){
        assignFacultyNameField.setText("");
        assignFacultyField.setText("");
        assignFacultyCredits.setText("");
        assignFacultyPasswordField.setText("");
        String path = "file:/I:/Github Repo/Student Management/src/main/resources/bd/edu/seu/studentmanagement/WelcomeScenePictures/ezgif-2-63d3b7c290.jpg" ;
        Image image = new Image(path);
        assignFacultyPicture.setImage(image);

        assignFacultyName.setText("");
        assignFacultyInitial.setText("");
        assignFacultyCreditsText.setText("");


    }


    @FXML
    void admitCardButtonAction(MouseEvent event) {
        tab.getSelectionModel().select(admitCardTab);
        counterForStudentAssignSlotsClearMethod();
        counterForFacultyAssignSlotsClearMethod();
        studentEditInitiateSolve();
        facultyEditInitiateSolve();
    }

    @FXML
    void gradeButtonAction(MouseEvent event) {
        tab.getSelectionModel().select(gradeTab);
        counterForStudentAssignSlotsClearMethod();
        counterForFacultyAssignSlotsClearMethod();
        studentEditInitiateSolve();
        facultyEditInitiateSolve();
    }

    @FXML
    void homeButtonAction(MouseEvent event) {
        tab.getSelectionModel().select(homeTab);
        counterForStudentAssignSlotsClearMethod();
        counterForFacultyAssignSlotsClearMethod();
        studentEditInitiateSolve();
        facultyEditInitiateSolve();
        refreshDashBoardTables();
    }

    @FXML
    void ledgerButtonAction(MouseEvent event) {
        tab.getSelectionModel().select(ledgerTab);
        counterForStudentAssignSlotsClearMethod();
        counterForFacultyAssignSlotsClearMethod();
        studentEditInitiateSolve();
        facultyEditInitiateSolve();
    }

    @FXML
    void paymentButtonAction(MouseEvent event) {
        tab.getSelectionModel().select(paymentTab);
        counterForStudentAssignSlotsClearMethod();
        counterForFacultyAssignSlotsClearMethod();
        studentEditInitiateSolve();
        facultyEditInitiateSolve();
    }


    @FXML
    void waiverButtonAction(MouseEvent event) {
        tab.getSelectionModel().select(waiverTab);
        counterForStudentAssignSlotsClearMethod();
        counterForFacultyAssignSlotsClearMethod();
        studentEditInitiateSolve();
        facultyEditInitiateSolve();
    }

////////////////////////////////////////////////////////////////////////////////////////


    @FXML
    void assignFacultyNameInitiate(KeyEvent event) {
        assignFacultyName.setText(assignFacultyNameField.getText());
    }

    @FXML
    void assignFacultyIntlInitiate(KeyEvent event) {
        assignFacultyInitial.setText(assignFacultyField.getText());
    }
    @FXML
    private TextField assignFacultyCredits;

    @FXML
    void assignFacultyCreditInitiate(KeyEvent event) {
        assignFacultyCreditsText.setText(assignFacultyCredits.getText());
    }



    private Double finalWaiver = 0.0;


    @FXML
    void assignStudentGpaInitiate(KeyEvent event) {
        String gp = assignStudentHscField.getText();
        assignStudentGpa.setText(gp);
        Double gpa = Double.parseDouble(gp);
        if (gpa == 5) {
            assignWaiverAmount.setText("100%");
            finalWaiver = 1.0;
        } else if (gpa > 4.9) {
            assignWaiverAmount.setText("80%");
            finalWaiver = .8;

        } else if (gpa > 4.8) {
            assignWaiverAmount.setText("60%");
            finalWaiver = .6;
        } else if (gpa > 4.7) {
            assignWaiverAmount.setText("40%");
            finalWaiver = .4;
        } else if (gpa > 4.6) {
            assignWaiverAmount.setText("30%");
            finalWaiver = .3;
        } else if (gpa > 4.5) {
            assignWaiverAmount.setText("20%");
            finalWaiver = .2;
        } else {
            assignWaiverAmount.setText("Not Eligible to get \nHSC based waiver.");
            finalWaiver = 0.0;
        }
    }

    @FXML
    void assignStudentIdInitiate(KeyEvent event) {
        String id = assignStudentIdField.getText();
        assignStudentID.setText(id);
    }

    @FXML
    void assignStudentNameInitiate(KeyEvent event) {
        String name = assignStudentNameField.getText();
        assignStudentName.setText(name);
    }

    String imageUrl = "";
    @FXML
    public void uploadStudentPicture(ActionEvent actionEvent) {
        try {
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showOpenDialog(new Stage());
            Image image = new Image(new FileInputStream(file));
            assignStudentPicture.setImage(image);
            imageUrl = file.toURI().toString();;
            System.out.println(imageUrl);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void studentAssignConfirm(ActionEvent actionEvent) {
        String name= assignStudentNameField.getText();
        String id = assignStudentIdField.getText();
        Double hscGpa = Double.parseDouble(assignStudentHscField.getText());
        Double waiver = finalWaiver;
        String semester = assignStudentSemesterField.getText();
        System.out.println(semester);
        String image = imageUrl;
        String password = assignStudentPasswordField.getText();

        //"I:\Github Repo\Student Management\src\main\resources\bd\edu\seu\studentmanagement\WelcomeScenePictures\ezgif-2-63d3b7c290.jpg"

         //public Student(String name, String id, String password, Double hscGpa, Double waiver, Double cgpa, String imageURL)
//        System.out.println(name);
//        System.out.println(id);
//        System.out.println(hscGpa);
//        System.out.println(waiver);
//        System.out.println(semester);
//        System.out.println(image);
//        System.out.println(password);
        if(name.isEmpty()){
            name = "null";
        }
        if(id.isEmpty()){
            id = "null";
        }
        if(semester.isEmpty()){
            semester = "null";
        }
        if(image.isEmpty()){
            image = "null";
        }

        Student student = new Student(name, id, password, hscGpa, waiver, 0.0,  image);

        StudentReadWrite studentReadWrite = new StudentReadWrite();
        studentReadWrite.save(student);



        StudentReadWrite readWriteObj = new StudentReadWrite();
        List<Student>  list = readWriteObj.read();

        ObservableList<Student> obsList = FXCollections.observableArrayList(list);

        studentTable.setItems(obsList);



    }

    @FXML
    public void facultyAssignConfirm(ActionEvent actionEvent) {
        String name= assignFacultyNameField.getText();
        String initial = assignFacultyInitial.getText();
        int credits = Integer.parseInt(assignFacultyCreditsText.getText());
        String semester = assignStudentSemesterField.getText();
        String password = assignStudentPasswordField.getText();
        System.out.println(semester);
        String image = facultyImageUrl;
        System.out.println(name);
        Faculty faculty = new Faculty(name,initial, password, credits, semester, image );
        System.out.println(image);
        FacultyReadWrite facultyReadWrite = new FacultyReadWrite();
        facultyReadWrite.save(faculty);

        List<Faculty>  list2 = facultyReadWrite.read();
        ObservableList<Faculty> obsList2 = FXCollections.observableArrayList(list2);
        facultyTable.setItems(obsList2);
    }

    @FXML
    Button editStudentSearchButton;

    @FXML
    Button editButtonStudent;

    @FXML
    Button editButtonFaculty;

    @FXML
    Button editFacultySearchButton;


    @FXML
    void editStudentSearch(ActionEvent event) {
        String search = assignStudentIdField.getText().toLowerCase();

        StudentReadWrite studentReadWrite = new StudentReadWrite();
        List<Student> list = studentReadWrite.read();
        List<Student> searchList = list.stream().filter(c-> c.getId().equals(search)).toList();
        if(searchList.size()==0){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("Student ID does not match");
            alert.showAndWait();
        }
        else{
            assignStudentNameField.setDisable(false);
            assignStudentHscField.setDisable(false);
            assignStudentPasswordField.setDisable(false);
            editStudentSearchButton.setVisible(false);
            assignStudentIdField.setDisable(true);
            assignStudentPictureButton.setDisable(false);

        }
    }


    @FXML
    void editFacultySearch(ActionEvent event) {
        String search = assignFacultyField.getText().toLowerCase();

        FacultyReadWrite facultyReadWrite = new FacultyReadWrite();
        List<Faculty> list = facultyReadWrite.read();
        List<Faculty> searchList = list.stream().filter(c-> c.getInitial().equals(search)).toList();
        if(searchList.size()==0){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("Faculty Initial does not match");
            alert.showAndWait();
        }
        else{
            assignFacultyNameField.setDisable(false);
            assignFacultyCredits.setDisable(false);
            assignFacultyPasswordField.setDisable(false);
            editFacultySearchButton.setVisible(false);
            assignStudentIdField.setDisable(true);
            assignFacultyPicture.setDisable(false);

        }
    }

    static Stage stage = new Stage();
    @FXML
    void studentDeleteInitiate(MouseEvent event) {
        try{

            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("deleteStudent.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 400, 400);
            stage.setTitle("Delete Student");
            stage.setScene(scene);
            stage.show();
        }catch(IOException e){
            e.printStackTrace();
        }
    }




    @FXML
    void studentEdit(ActionEvent event) {
        String name = assignStudentNameField.getText();
        String id = assignStudentIdField.getText();
        Double hscGpa = Double.parseDouble(assignStudentHscField.getText());
        Double waiver = finalWaiver;
        String semester = assignStudentSemesterField.getText();
        String image = facultyImageUrl;

    }



    @FXML
    void facultyEditInitiate(MouseEvent event) {
        confirmButtonFaculty.setVisible(false);
        editButtonFaculty.setVisible(true);
        assignFacultyNameField.setDisable(true);
        assignFacultyCredits.setDisable(true);
        assignFacultyPasswordField.setDisable(true);
        assignFacultyName.setText("");
        assignFacultyInitial.setText("");
        assignStudentID.setText("");
        assignFacultyCreditsText.setVisible(true);
        assignFacultyPictureButton.setDisable(true);
        editFacultySearchButton.setVisible(true);
    }



    void facultyEditInitiateSolve(){
        confirmButton.setVisible(true);
        editButtonStudent.setVisible(false);
        assignStudentNameField.setDisable(false);
        assignStudentHscField.setDisable(false);
        assignStudentPasswordField.setDisable(false);
        assignStudentName.setText("");
        assignStudentGpa.setText("");
        assignStudentID.setText("");
        editStudentSearchButton.setVisible(false);
        assignStudentPictureButton.setDisable(false);
    }


    @FXML
    void studentEditInitiate(MouseEvent event) {
        confirmButton.setVisible(false);
        editButtonStudent.setVisible(true);
        assignStudentNameField.setDisable(true);
        assignStudentHscField.setDisable(true);
        assignStudentPasswordField.setDisable(true);
        assignStudentName.setText("");
        assignStudentGpa.setText("");
        assignStudentID.setText("");
        editStudentSearchButton.setVisible(true);
        assignStudentPictureButton.setDisable(true);
        editStudentSearchButton.setVisible(true);
    }


    void studentEditInitiateSolve(){
        confirmButton.setVisible(true);
        editButtonStudent.setVisible(false);
        assignStudentNameField.setDisable(false);
        assignStudentHscField.setDisable(false);
        assignStudentPasswordField.setDisable(false);
        assignStudentName.setText("");
        assignStudentGpa.setText("");
        assignStudentID.setText("");
        editStudentSearchButton.setVisible(false);
        assignStudentPictureButton.setDisable(false);
    }

    @FXML
    void facultyDeleteInitiate(MouseEvent event) {
        try{
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("deleteFaculty.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 400, 400);
            stage.setTitle("Delete Faculty");
            stage.setScene(scene);
            stage.show();
        }catch(IOException e){
            e.printStackTrace();
        }
    }






    public static int facultyOrStudentInfo = 0;
    public static String name = "";
    public static String idOrInitial = "";
    public static String CgOrNothing = "";
    public static Student popUpStudent  = new Student();
    public static Faculty popUpFaculty = new Faculty();



    void refreshDashBoardTables(){
        StudentReadWrite readWriteObj = new StudentReadWrite();
        List<Student>  list = readWriteObj.read();

        ObservableList<Student> obsList = FXCollections.observableArrayList(list);

        studentTable.setItems(obsList);

        FacultyReadWrite facultyReadWrite = new FacultyReadWrite();
        List<Faculty>  list2 = facultyReadWrite.read();
        ObservableList<Faculty> obsList2 = FXCollections.observableArrayList(list2);
        facultyTable.setItems(obsList2);

    }

    @FXML
    void assignCourse(ActionEvent event) {

    }

    @FXML
    void saveNewCourse(ActionEvent event) {

    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        tab.getSelectionModel().select(homeTab);
        assignStudentName.setText("");
        assignStudentGpa.setText("");
        assignStudentID.setText("");
        assignStudentSemesterField.setDisable(true);

        assignFacultyName.setText("");
        assignFacultyInitial.setText("");
        assignFacultyCreditsText.setText("");
        assignFacultySemesterField.setDisable(true);

        editStudentSearchButton.setVisible(false);
        editButtonStudent.setVisible(false);



        //nameColumn.setCellValueFactory(c-> new SimpleStringProperty(c.getValue().getName()));
        studentNameColumn.setCellValueFactory(c-> new SimpleStringProperty(c.getValue().getName()));
        studentIdColumn.setCellValueFactory(c-> new SimpleStringProperty(c.getValue().getId()));
        studentCgpaColumn.setCellValueFactory(c-> new SimpleDoubleProperty(c.getValue().getCgpa()));
        //studentDueColumn.setCellValueFactory(c-> new SimpleDoubleProperty(c.getValue().getDue));  student class e attribute add kre database eo table e add krte hbe
        studentWaiverColumn.setCellValueFactory(c-> new SimpleDoubleProperty(c.getValue().getWaiver()));



        facultyInitialColumn.setCellValueFactory(c-> new SimpleStringProperty(c.getValue().getInitial()));
        facultyNameColumn.setCellValueFactory(c-> new SimpleStringProperty(c.getValue().getName()));
        facultyCreditColumn.setCellValueFactory(c-> new SimpleIntegerProperty(c.getValue().getCredits()));


        refreshDashBoardTables();
        editFacultySearchButton.setVisible(false);



        studentTable.setOnMouseClicked(event -> {
            if (event.getClickCount() == 1) {
                Student selectedStudent = studentTable.getSelectionModel().getSelectedItem();
                facultyOrStudentInfo = 0;
                if(selectedStudent != null){
                    popUpStudent = selectedStudent;
                    try{
                        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("infoPortal.fxml"));
                        Scene scene = new Scene(fxmlLoader.load(), 400, 500);
                        stage.setTitle("Student Info");
                        tab.getSelectionModel().select(gradeTab);
                        stage.setScene(scene);
                        stage.show();
                    }catch(IOException e){
                        e.printStackTrace();
                    }
                }

            }
        });

        facultyTable.setOnMouseClicked(event -> {
            if (event.getClickCount() == 1) {
                Faculty selectedFaculty = facultyTable.getSelectionModel().getSelectedItem();
                facultyOrStudentInfo = 0;
                if(selectedFaculty != null){
                    popUpFaculty = selectedFaculty;
                    facultyOrStudentInfo = 1;
                    try{
                        Stage stage = new Stage();
                        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("infoPortal.fxml"));
                        Scene scene = new Scene(fxmlLoader.load(), 400, 500);
                        stage.setTitle("Student Info");
                        tab.getSelectionModel().select(gradeTab);
                        stage.setScene(scene);
                        stage.show();
                    }catch(IOException e){
                        e.printStackTrace();
                    }
                }

            }
        });

    }
}

