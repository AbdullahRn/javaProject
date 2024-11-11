package bd.edu.seu.studentmanagement.service;

import bd.edu.seu.studentmanagement.HelloApplication;
import bd.edu.seu.studentmanagement.otherClasses.Course;
import bd.edu.seu.studentmanagement.users.Faculty;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CurrentSemesterDecider {
    public void save() {
        try{
            Connection connection = Singleton.getConnection();
            Statement statement = connection.createStatement();
            String query = "INSERT INTO currentSemester VALUE('" + HelloApplication.currentSemester + "');";
            statement.execute(query);

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public String read() {
        List<String> list = new ArrayList<>();
        try{
            Connection connection = Singleton.getConnection();
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM currentSemester;";
            ResultSet resultset = statement.executeQuery(query);
            while(resultset.next()){
                String semester = resultset.getString("semester");

                list.add(semester);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        if(list.isEmpty()){
            return "null";
        }
        else{
            return list.get(list.size()-1);
        }

    }

}
