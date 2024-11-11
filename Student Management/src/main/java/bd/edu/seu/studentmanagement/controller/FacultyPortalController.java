package bd.edu.seu.studentmanagement.controller;

import bd.edu.seu.studentmanagement.HelloApplication;
import bd.edu.seu.studentmanagement.dependentOnSemester.StudentCourseInfo;
import bd.edu.seu.studentmanagement.dependentOnSemester.StudentSemesterInfo;
import bd.edu.seu.studentmanagement.otherClasses.Course;
import bd.edu.seu.studentmanagement.service.CourseListSave;
import bd.edu.seu.studentmanagement.service.StudentParticularCourseInfoReadWrite;
import bd.edu.seu.studentmanagement.service.StudentReadWrite;
import bd.edu.seu.studentmanagement.users.Faculty;
import bd.edu.seu.studentmanagement.users.Student;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;

public class FacultyPortalController implements Initializable {


    @FXML
    private Tab admitCardTab;

    @FXML
    private Label assignDueAmount;

    @FXML
    private Label assignInitial;

    @FXML
    private Label assignName;

    @FXML
    private TextField studentSearchBar;

    @FXML
    private TextField courseSearchBar;


    @FXML
    private ImageView admitCardButton;


    @FXML
    private TableColumn<Course, String> codeCourseDetailsTable;

    @FXML
    private TableView<Course> courseDetailsTable;

    @FXML
    private TableView<StudentCourseInfo> courseStudentInfo;

    @FXML
    private ImageView gradeButton;

    @FXML
    private Tab gradeTab;

    @FXML
    private ImageView homeButton;

    @FXML
    private Tab homeTab;

    @FXML
    private TableColumn<StudentCourseInfo, String> idCourseStudentInfo;

    @FXML
    private Label labelasd;

    @FXML
    private ImageView ledgerButton;

    @FXML
    private Tab ledgerTab;

    @FXML
    private TableColumn<StudentCourseInfo, Number> marksCourseStudentInfo;

    @FXML
    private TableColumn<StudentCourseInfo, String> nameCourseStudentInfo;

    @FXML
    private ImageView paymentButton;

    @FXML
    private Tab paymentTab;

    @FXML
    private TableColumn<Course, Number> slotCourseDetailsTable;

    @FXML
    private TableColumn<Course, String> nameCourseDetailsTable;

    @FXML
    private TabPane tab;

    @FXML
    private TableColumn<Course, Number> totalStudentCourseDetailsTable;

    @FXML
    private ImageView waiverButton;

    @FXML
    private Tab waiverTab;

    @FXML
    private Label welcomeInitial;

    @FXML
    private Label welcomeName;

    @FXML
    private ImageView welcomePicture;

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
    private Label slot1;

    @FXML
    private Label slot2;

    @FXML
    private Label slot3;

    @FXML
    private Label slot4;

    @FXML
    private Label slot5;

    @FXML
    private Label slot6;

    @FXML
    private Label slot7;

    @FXML
    private Label slot8;

    @FXML
    private Label slot11;

    @FXML
    private Label slot12;

    @FXML
    private Label slot13;

    @FXML
    private Label slot14;

    @FXML
    private Label slot15;

    @FXML
    private Label slot16;

    @FXML
    private Label slot17;

    @FXML
    private Label slot18;


    Student popUpStudent = null;
    Course popUpCourse = null;


    List<Course> courseListFromSQL(){
        CourseListSave courseListSave = new CourseListSave();
        return courseListSave.getCourseList();
    }

    private Stage stage = new Stage();

    public static StudentCourseInfo studentCourseInfo = null;



    @FXML
    void searchCourse(KeyEvent event) {
        CourseListSave courseListSave = new CourseListSave();
        List<Course> lllist = courseListSave.GetFacultyCourseList(faculty1);
        String search = courseSearchBar.getText().toLowerCase();
        List<Course> list = lllist.stream().filter(c-> (c.getSlot()+ c.getName() + c.getCode() + c.getTotalStudent() + "").toLowerCase().contains(search)).toList();
        ObservableList<Course> obsList = FXCollections.observableArrayList(list);
        courseDetailsTable.setItems(obsList);
    }

    @FXML
    void searchStudent(KeyEvent event) {
        if(listForStudentTable!= null){
            String search = studentSearchBar.getText();
            List<StudentCourseInfo> list = listForStudentTable.stream().filter(c-> (c.getId() + c.getName() + c.getMarks() + "").toLowerCase().contains(search)).toList();
            ObservableList<StudentCourseInfo> obsList = FXCollections.observableArrayList(list);
            courseStudentInfo.setItems(obsList);
        }

    }


    @FXML
    void exitPortal(MouseEvent event) {
        HelloApplication.changeScene("loginScene.fxml");
    }


    Faculty faculty1 = null;


    List<StudentCourseInfo> listForStudentTable = null;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Image image = new Image(LoginSceneController.LOGGEDINFACULTY.getImage());
        welcomePicture.setImage(image);


        welcomeInitial.setText(LoginSceneController.LOGGEDINFACULTY.getInitial());
        welcomeName.setText(LoginSceneController.LOGGEDINFACULTY.getName());





//        studentNameColumn.setCellValueFactory(c-> new SimpleStringProperty(c.getValue().getName()));
//        studentIdColumn.setCellValueFactory(c-> new SimpleStringProperty(c.getValue().getId()));
        slotCourseDetailsTable.setCellValueFactory(c-> new SimpleIntegerProperty(c.getValue().getSlot()));
        codeCourseDetailsTable.setCellValueFactory(c-> new SimpleStringProperty(c.getValue().getCode()));
        totalStudentCourseDetailsTable.setCellValueFactory(c-> new SimpleIntegerProperty(c.getValue().getTotalStudent()));
        nameCourseDetailsTable.setCellValueFactory(c-> new SimpleStringProperty(c.getValue().getName()));


        studentCourseInfo = null;

        String name = LoginSceneController.LOGGEDINFACULTY.getName();
        String initial = LoginSceneController.LOGGEDINFACULTY.getInitial();
        String password = LoginSceneController.LOGGEDINFACULTY.getPassword();
        int credits = LoginSceneController.LOGGEDINFACULTY.getCredits();
        String semester = LoginSceneController.LOGGEDINFACULTY.getSemester();
        String urL = LoginSceneController.LOGGEDINFACULTY.getImage();

        //ekhane login krar pore jate oi faculty er info pass hoy oita ensure krte hbe
//        String name = "NOOR";
//        String initial = "NOOR";
//        String password = "";
//        int credits = 15;
//        String semester = "Fall 24";
//        String urL = " file:/C:/Users/Abdullah/Downloads/311020241910002980581_462565661_8523294754452206_3328519660646849292_n%20(1).jpg";

        Faculty faculty = new Faculty(name, initial, password, credits, semester, urL);
        faculty1 = faculty;
        CourseListSave courseListSave = new CourseListSave();
        List<Course> lllist = courseListSave.GetFacultyCourseList(faculty);
        ObservableList<Course> observableList = FXCollections.observableList(lllist);
        courseDetailsTable.setItems(observableList);

        idCourseStudentInfo.setCellValueFactory(c-> new SimpleStringProperty(c.getValue().getId()));
        nameCourseStudentInfo.setCellValueFactory(c-> new SimpleStringProperty(c.getValue().getName()));
        marksCourseStudentInfo.setCellValueFactory(c-> new SimpleDoubleProperty(c.getValue().getMarks()));

        StudentReadWrite studentReadWrite = new StudentReadWrite();
        List<Student> list = studentReadWrite.read();
        //List<Student> tempList = list.stream().filter(c-> c.getId());

        tab.getSelectionModel().select(homeTab);

        courseDetailsTable.setOnMouseClicked(event -> {
            if (event.getClickCount() == 1) {
                Course selectedCOurse  = courseDetailsTable.getSelectionModel().getSelectedItem();
                if(selectedCOurse != null){
                    StudentParticularCourseInfoReadWrite studentParticularCourseInfoReadWrite = new StudentParticularCourseInfoReadWrite();
                    List<StudentCourseInfo> studentCourseInfos =  studentParticularCourseInfoReadWrite.GetStudentWhoAreInThisCourse(selectedCOurse.getCode());
                    listForStudentTable = studentCourseInfos;
                    ObservableList<StudentCourseInfo> obslist = FXCollections.observableList(studentCourseInfos);
                    courseStudentInfo.setItems(obslist);

                }
                else{
                    listForStudentTable= null;
                }

            }
        });

        courseStudentInfo.setOnMouseClicked(event -> {
            if (event.getClickCount() == 1) {
                StudentCourseInfo selectedStudent = courseStudentInfo.getSelectionModel().getSelectedItem();
                //facultyOrStudentInfo = 0;
                if(selectedStudent != null){
                    studentCourseInfo = selectedStudent;
                    try{
                        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("studentMarkAssign.fxml"));
                        Scene scene = new Scene(fxmlLoader.load(), 800, 700);
                        stage.setTitle("Assign Marks");
                        stage.setScene(scene);
                        stage.show();
                    }catch(IOException e){
                        e.printStackTrace();
                    }

                }
            }
        });

        slot1.setText("");
        slot2.setText("");
        slot3.setText("");
        slot4.setText("");
        slot5.setText("");
        slot6.setText("");
        slot7.setText("");
        slot8.setText("");
        slot11.setText("");
        slot12.setText("");
        slot13.setText("");
        slot14.setText("");
        slot15.setText("");
        slot16.setText("");
        slot17.setText("");
        slot18.setText("");




        List<Course> routineList  = lllist.stream().filter(c->c.getSlot()>0).toList();
//        for(Course i: routineList){
//            System.out.println(i.getSlot());
//        }
        //routineList.sort(Comparator.comparingInt(Course::getSlot));

        for(Course i : routineList){
            if(i.getSlot()==1){
                slot1.setText(i.getCode());
                slot11.setText(i.getCode());
            }


            if(i.getSlot()==2){
                slot2.setText(i.getCode());
                slot12.setText(i.getCode());
            }


            if(i.getSlot()==3){
                slot3.setText(i.getCode());
                slot13.setText(i.getCode());
            }

            if(i.getSlot()==4){
                slot4.setText(i.getCode());
                slot14.setText(i.getCode());
            }

            if(i.getSlot()==5){
                slot5.setText(i.getCode());
                slot15.setText(i.getCode());
            }

            if(i.getSlot()==6){
                slot6.setText(i.getCode());
                slot16.setText(i.getCode());
            }

            if(i.getSlot()==7){
                slot7.setText(i.getCode());
                slot17.setText(i.getCode());
            }

            if(i.getSlot()==8){
                slot8.setText(i.getCode());
                slot18.setText(i.getCode());
            }

        }
//        for(int i =1; i<=8; i++){
//            if(i>=routineList.size()){
//                break;
//            }
//            if(routineList.get(i).getSlot() ==1){
//                slot1.setText(routineList.get(i).getCode());
//                slot11.setText(routineList.get(i).getCode());
//            }
//            else{
//                slot1.setText("");
//                slot11.setText("");
//            }
//
//            if(routineList.get(i).getSlot() ==2){
//                slot2.setText(routineList.get(i).getCode());
//                slot12.setText(routineList.get(i).getCode());
//            }
//            else{
//                slot2.setText("");
//                slot12.setText("");
//            }
//
//            if(routineList.get(i).getSlot() ==3){
//                slot3.setText(routineList.get(i).getCode());
//                slot13.setText(routineList.get(i).getCode());
//            }
//            else{
//                slot3.setText("");
//                slot13.setText("");
//            }
//            if(routineList.get(i).getSlot() ==4){
//                slot4.setText(routineList.get(i).getCode());
//                slot14.setText(routineList.get(i).getCode());
//                System.out.println(routineList.get(i).getCode());
//            }
//            else{
//                slot4.setText("");
//                slot14.setText("");
//            }
//            if(routineList.get(i).getSlot() ==5){
//                slot5.setText(routineList.get(i).getCode());
//                slot15.setText(routineList.get(i).getCode());
//            }
//            else{
//                slot5.setText("");
//                slot15.setText("");
//            }
//            if(routineList.get(i).getSlot() ==6){
//                slot6.setText(routineList.get(i).getCode());
//                slot16.setText(routineList.get(i).getCode());
//            }
//            else{
//                slot6.setText("");
//                slot16.setText("");
//            }
//            if(routineList.get(i).getSlot() ==7){
//                slot7.setText(routineList.get(i).getCode());
//                slot17.setText(routineList.get(i).getCode());
//            }
//            else{
//                slot7.setText("");
//                slot17.setText("");
//            }
//            if(routineList.get(i).getSlot() ==8){
//                slot8.setText(routineList.get(i).getCode());
//                slot18.setText(routineList.get(i).getCode());
//            }
//            else{
//                slot8.setText("");
//                slot18.setText("");
//            }
//
//        }

    }
}
