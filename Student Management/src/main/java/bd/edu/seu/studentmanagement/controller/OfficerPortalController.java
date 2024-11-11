package bd.edu.seu.studentmanagement.controller;

import bd.edu.seu.studentmanagement.HelloApplication;
import bd.edu.seu.studentmanagement.otherClasses.Course;
import bd.edu.seu.studentmanagement.otherClasses.Log;
import bd.edu.seu.studentmanagement.service.*;
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
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class OfficerPortalController implements Initializable {


    @FXML
    private Label welcomeInitial;

    @FXML
    private Label welcomeName;

    @FXML
    private ImageView welcomePicture;


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

    @FXML
    private TableView<Log> adminLogTable;

    @FXML
    private TableColumn<Log, String> tableAdminColumn;

    @FXML
    private TableColumn<Log, String> tableDateColumn;

    @FXML
    private TableColumn<Log, String> tableTaskColumn;




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
        courseName.setValue(null);
        assignCourseIdOrInitialField.setText("");
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
        courseNameField.setText("");
        courseCodeField.setText("");
        courseSlotChoiceBox.setValue(null);
        assignCourseTabRefresh();
        tab.getSelectionModel().select(ledgerTab);
        counterForStudentAssignSlotsClearMethod();
        counterForFacultyAssignSlotsClearMethod();
        studentEditInitiateSolve();
        facultyEditInitiateSolve();
    }

    @FXML
    void paymentButtonAction(MouseEvent event) {
        refreshLogTable();
        tab.getSelectionModel().select(paymentTab);
        counterForStudentAssignSlotsClearMethod();
        counterForFacultyAssignSlotsClearMethod();
        studentEditInitiateSolve();
        facultyEditInitiateSolve();
    }


    @FXML
    void waiverButtonAction(MouseEvent event) {
        confirmButtonFaculty.setVisible(true);
        editButtonFaculty.setVisible(false);
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
    void exitPortal(MouseEvent event) {
        HelloApplication.changeScene("loginScene.fxml");
    }

    @FXML
    public void studentAssignConfirm(ActionEvent actionEvent) {
        String name= assignStudentNameField.getText();
        String id = assignStudentIdField.getText();
        Double hscGpa = Double.parseDouble(assignStudentHscField.getText());
        Double waiver = finalWaiver;
        String semester = HelloApplication.currentSemester;
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
        String semester = HelloApplication.currentSemester;
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

    public static Stage stage = new Stage();
    @FXML
    void studentDeleteInitiate(MouseEvent event) {
        try{

            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("deleteStudent.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 500);
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


    void refreshLogTable(){
        LogEditor logEditor = new LogEditor();
        List<Log> list = logEditor.read();
        ObservableList<Log> obsList = FXCollections.observableArrayList(list);

        adminLogTable.setItems(obsList);
    }
    @FXML
    TextField assignCourseIdOrInitialField;

    @FXML
    void assignCourse(ActionEvent event) {
        SearchForCourseSlot searchForCourseSlot = new SearchForCourseSlot();
        if(assignCourseTo.getValue().equals("Faculty")){
            String code = courseName.getValue();
            String initial = facultySelectToAssignCourse.getValue();
            int slot =  courseSlotChoiceBox.getValue();
            Course course= new Course(code, initial, slot, 0);


            CourseListSave courseListSave = new CourseListSave();

            Alert alert = new Alert(Alert.AlertType.WARNING);
            List<Integer> list = searchForCourseSlot.searchFromFaculty(facultySelectToAssignCourse.getValue(), courseSlotChoiceBox.getValue());
            if(list.size()>0){
                alert.setTitle("Warning");
                alert.setHeaderText(null);
                alert.setContentText("Slot conflicts, try other course");
                alert.showAndWait();
            }
            else{
                courseListSave.assignFacultyToExistingCourse(course);
                alert.setTitle("Assign Course");
                alert.setHeaderText(null);
                alert.setContentText("Successull");
                alert.showAndWait();

            }

            for(Integer i: list){
                System.out.println(i);
            }



        }
        else{
            String code = courseName.getValue();
            String id = assignCourseIdOrInitialField.getText();
            int slot =  methodToGetCourseSlot(code);

            CourseListSave courseListSave = new CourseListSave();


            List<Integer> list = searchForCourseSlot.searchFromStudent(assignCourseIdOrInitialField.getText());

            Alert alert = new Alert(Alert.AlertType.WARNING);
            if(list.size()>0){
                alert.setTitle("Warning");
                alert.setHeaderText(null);
                alert.setContentText("Slot conflicts, try other slot");
                alert.showAndWait();
            }
            else{
                Course course1 = new Course(code, slot );
                CourseListSave courseListSave2 = new CourseListSave();;
                courseListSave2.studentCountIncrement(course1);
                courseListSave.addStudentsToCourse(code, id, HelloApplication.currentSemester, slot);
                alert.setTitle("Assign Course");
                alert.setHeaderText(null);
                alert.setContentText("Successull");
                alert.showAndWait();
            }
            for(Integer i: list){
                System.out.println(i);
            }

        }



        /**
         * eikhane existing course er moddhe faculty add krtesilam, semester change e issue hoy, tai ei part apadoto baad
         */
       // courseListSave.assignFacultyToExistingCourse(course);

    }

    int methodToGetCourseSlot(String code){
        int slot = 0;
        try{
            Connection connection = Singleton.getConnection();
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM course WHERE code = '" + code + "';";
            ResultSet resultset = statement.executeQuery(query);
            while(resultset.next()){
                String name = resultset.getString("name");
                slot = resultset.getInt("slot");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return slot;
    }


    @FXML
    TextField courseNameField;

    @FXML
    TextField courseCodeField;

    @FXML
    ChoiceBox<Integer> courseSlotChoiceBox;

    @FXML
    void saveNewCourse(ActionEvent event) {
      String name = courseNameField.getText();
      String code = courseCodeField.getText();
      Integer totalSeat = Integer.parseInt(totalSeatField.getText());
     // int slot = courseSlotChoiceBox.getValue();
        Course course = new Course(name, code, totalSeat);
        CourseListSave courseListSave = new CourseListSave();
        courseListSave.save(course);
        LocalTime time = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String timeString = time.format(formatter);
        Log log = new Log("Kashem", "Added new course", timeString );
        LogEditor logEditor = new LogEditor();
        logEditor.save(log);

    }

    @FXML
    void fixSemester(ActionEvent event) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("selectSemester.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            stage.setTitle("Select Semester ");
            tab.getSelectionModel().select(gradeTab);
            stage.setScene(scene);
            stage.show();
        }catch(IOException e){
            e.printStackTrace();
        }
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
        assignFacultySemesterField.setText(HelloApplication.currentSemester);
        assignStudentSemesterField.setDisable(true);
        assignStudentSemesterField.setText(HelloApplication.currentSemester);

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


        tableAdminColumn.setCellValueFactory(c-> new SimpleStringProperty(c.getValue().getAdminName()));
        tableTaskColumn.setCellValueFactory(c-> new SimpleStringProperty(c.getValue().getTask()));
        tableDateColumn.setCellValueFactory(c-> new SimpleStringProperty(c.getValue().getTime()));

        refreshLogTable();


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
                     //   tab.getSelectionModel().select(gradeTab);
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
                       // tab.getSelectionModel().select(gradeTab);
                        stage.setScene(scene);
                        stage.show();
                    }catch(IOException e){
                        e.printStackTrace();
                    }
                }

            }
        });


        List<Integer> liist = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8));

        ObservableList<Integer> obsLiist = FXCollections.observableArrayList(liist);
        courseSlotChoiceBox.setItems(obsLiist);
        courseSlotChoiceBox.setValue(0);
        courseSlotChoiceBox.setDisable(true);
        List<String> assignList = new ArrayList<>(Arrays.asList("Faculty", "Student"));
        ObservableList<String> obsAssignList  = FXCollections.observableArrayList(assignList);
        assignCourseTo.setItems(obsAssignList);

        //course list assign er combo box upload hoy ekhane, eta method e shift krte hbe

        CourseListSave courseListSave = new CourseListSave();
        List<Course> liiist = courseListSave.getCourseList();
        List<String> tempList = new ArrayList<>();
        for(Course i: liiist){
            tempList.add(i.getCode());
        }

        //if(assignCourseTo!= null)
        ObservableList<String> obsList2 = FXCollections.observableArrayList(tempList);
        courseName.setItems(obsList2);

        courseSlotChoiceBox.setDisable(true);
        assignCourseIdOrInitialField.setVisible(false);

        assignCourseTabRefresh();

        assignCourseTo.setOnAction(event -> {
            if(assignCourseTo.getValue().equals("Faculty")){
                courseSlotChoiceBox.setDisable(false);
                assignCourseIdOrInitialField.setVisible(false);
                facultySelectToAssignCourse.setVisible(true);
            }
            else{
                courseSlotChoiceBox.setDisable(true);
                assignCourseIdOrInitialField.setVisible(true);
                facultySelectToAssignCourse.setVisible(false);
            } // Call the method with the selected item
        });

        Image image = new Image(LoginSceneController.LOGGEDOFFICER.getImage());
        welcomePicture.setImage(image);


        welcomeInitial.setText(LoginSceneController.LOGGEDOFFICER.getId());
        welcomeName.setText(LoginSceneController.LOGGEDOFFICER.getName());

//        System.out.println(LoginSceneController.LOGGEDOFFICER.getName());
//        System.out.println(LoginSceneController.LOGGEDOFFICER.getImage());



    }

    void assignCourseTabRefresh(){
        FacultyReadWrite f = new FacultyReadWrite();
        List<Faculty> l = f.read();
        List<String> ll = l.stream().map(Faculty::getInitial).collect(Collectors.toList());
        ObservableList<String> obs = FXCollections.observableArrayList(ll);
        facultySelectToAssignCourse.setItems(obs);
    }



    @FXML
    ChoiceBox<String> courseName;

    @FXML
    ChoiceBox<String> assignCourseTo;

    @FXML
    private TextField totalSeatField;

    @FXML
    ChoiceBox<String> facultySelectToAssignCourse;


}

