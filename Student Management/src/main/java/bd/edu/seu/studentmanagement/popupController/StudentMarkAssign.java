package bd.edu.seu.studentmanagement.popupController;

import bd.edu.seu.studentmanagement.controller.FacultyPortalController;
import bd.edu.seu.studentmanagement.controller.OfficerPortalController;
import bd.edu.seu.studentmanagement.dependentOnSemester.StudentCourseInfo;
import bd.edu.seu.studentmanagement.service.StudentParticularCourseInfoReadWrite;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;


public class StudentMarkAssign implements Initializable {


    @FXML
    private Label cgpaLabel;

    @FXML
    private Label idHeadline;

    @FXML
    private Label idLabel;

    @FXML
    private Label markLabel;

    @FXML
    private Label gradeLabel;

    @FXML
    private ImageView imageView;


    @FXML
    private TextField quizMarksField;

    @FXML
    private TextField attendanceMarksField;

    @FXML
    private TextField midMarksField;

    @FXML
    private TextField assignmentMarksField;

    @FXML
    private TextField finalMarksField;


    @FXML
    private Label nameLabel;

    @FXML
    void updateButtonAction(ActionEvent event) {
        Double quizMarks = Double.parseDouble(quizMarksField.getText());
        Double attendanceMarks = Double.parseDouble(attendanceMarksField.getText());
        Double midMarks = Double.parseDouble(midMarksField.getText());
        Double assignmentMarks = Double.parseDouble(assignmentMarksField.getText());
        Double finalMarks = Double.parseDouble(finalMarksField.getText());
        totalMark = quizMarks + attendanceMarks + midMarks + assignmentMarks + finalMarks;
        Double grade =0.0;
        if(totalMark>100 || totalMark<0){
            markLabel.setText("Invalid");
            gradeLabel.setText("Invalid");
            grade =0.0;
        }
        else if(totalMark>79){
            markLabel.setText(totalMark+"");
            gradeLabel.setText("A+");
            grade =4.0;
        }
        else if(totalMark>74){
            markLabel.setText(totalMark+"");
            gradeLabel.setText("A");
            grade =3.75;
        }
        else if(totalMark>69){
            markLabel.setText(totalMark+"");
            gradeLabel.setText("A-");
            grade =3.50;
        }
        else if(totalMark>64){
            markLabel.setText(totalMark+"");
            gradeLabel.setText("B+");
            grade =3.25;
        }
        else if(totalMark>59){
            markLabel.setText(totalMark+"");
            gradeLabel.setText("B");
            grade =3.00;
        }
        else if(totalMark>54){
            markLabel.setText(totalMark+"");
            gradeLabel.setText("B-");
            grade =2.75;
        }
        else if(totalMark>49){
            markLabel.setText(totalMark+"");
            gradeLabel.setText("C+");
            grade =2.50;
        }
        else if(totalMark>44){
            markLabel.setText(totalMark+"");
            gradeLabel.setText("C");
            grade =2.25;
        }
        else if(totalMark>39){
            markLabel.setText(totalMark+"");
            gradeLabel.setText("D");
            grade =2.00;
        }else{
            markLabel.setText(totalMark+"");
            gradeLabel.setText("F");
            grade =0.00;
        }

        if(markLabel.getText().equals("Invalid")){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("Invalid Action");
            alert.showAndWait();
        }
        else{
            FacultyPortalController.studentCourseInfo.setMarks(totalMark);
            FacultyPortalController.studentCourseInfo.setGrade(grade);
        }

//        System.out.println("marks:");
//        System.out.println(FacultyPortalController.studentCourseInfo.getMarks());
//        System.out.println("grade:");
//        System.out.println(FacultyPortalController.studentCourseInfo.getGrade());

        String name = FacultyPortalController.studentCourseInfo.getName();
        String id = FacultyPortalController.studentCourseInfo.getId();
        Double cgpa =0.0;
        String courseCode = FacultyPortalController.studentCourseInfo.getCourseCode();
        String semester = FacultyPortalController.studentCourseInfo.getSemester();
        //totalMark;
        //grade;
        String imageURL = FacultyPortalController.studentCourseInfo.getImageURL();

        StudentCourseInfo studentCourseInfo1 = new StudentCourseInfo(name, id, cgpa, courseCode, semester, totalMark, grade, imageURL);

        StudentParticularCourseInfoReadWrite willSave = new StudentParticularCourseInfoReadWrite();

//        List<StudentCourseInfo> list = willSave.GetStudentWhoAreInThisCourse(courseCode);
//
//        List<StudentCourseInfo> search = list.stream().filter(c-> (c.getCourseCode().equals(courseCode) && c.getSemester().equals(semester))).toList();
//        if(search.size()>0){
//            willSave.update(studentCourseInfo1);
//            Alert alert = new Alert(Alert.AlertType.WARNING);
//            alert.setTitle("Updated");
//            alert.setHeaderText(null);
//            alert.setContentText("Student info Updated");
//            alert.showAndWait();
//        }
//        else{
//            willSave.save(studentCourseInfo1);
//            Alert alert = new Alert(Alert.AlertType.WARNING);
//            alert.setTitle("Saved");
//            alert.setHeaderText(null);
//            alert.setContentText("Student info Saved");
//            alert.showAndWait();
//        }
        willSave.deletePreviousInfo(FacultyPortalController.studentCourseInfo);
        willSave.save(FacultyPortalController.studentCourseInfo);


    }

    @FXML
    void textUpdate(KeyEvent event) {


    }
    Double totalMark = 0.0;
    Double grade = 0.0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameLabel.setText(FacultyPortalController.studentCourseInfo.getName());
        idLabel.setText(FacultyPortalController.studentCourseInfo.getId());
        String path = FacultyPortalController.studentCourseInfo.getImageURL();
        Image image = new Image(path);
        imageView.setImage(image);
        markLabel.setText("");
        gradeLabel.setText("");


    }
}
