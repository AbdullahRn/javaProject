package bd.edu.seu.studentmanagement;

import bd.edu.seu.studentmanagement.service.CurrentSemesterDecider;
import bd.edu.seu.studentmanagement.users.Faculty;
import bd.edu.seu.studentmanagement.users.Officer;
import bd.edu.seu.studentmanagement.users.Student;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.w3c.dom.ls.LSOutput;

import java.io.IOException;

public class HelloApplication extends Application {
    public static Stage stage;
    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("loginScene.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setTitle("Student Management System");
        stage.setScene(scene);
        stage.show();
    }

    static CurrentSemesterDecider currentSemesterDecider = new CurrentSemesterDecider();

    public static String currentSemester ;

    ////////////////////////////////////
    //loggedInFaculty ke then null diye initialize krte hbe, testing purpose e value assign krtesi
    /////////////////////////////////
    public static Faculty loggedInFaculty;

    public static Student loggedInStudent;

    public static Officer loggedInOfficer;



    public static void main(String[] args) {
        String demo = currentSemesterDecider.read();
        if(demo.equals("null")){
            currentSemester = "Spring 24";
        }
        else{
            currentSemester = demo;
        }
        System.out.println(currentSemester);
        launch();
    }

    public static void changeScene(String line) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(line));
            Scene scene = new Scene(fxmlLoader.load(),1280,720);
            stage.setScene(scene);
        }catch(IOException ex){
            ex.printStackTrace();
        }

    }
}