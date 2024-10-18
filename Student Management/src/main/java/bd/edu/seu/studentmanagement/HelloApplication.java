package bd.edu.seu.studentmanagement;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    public static Stage stage;
    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("welcomeScene.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setTitle("Student Management System");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
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