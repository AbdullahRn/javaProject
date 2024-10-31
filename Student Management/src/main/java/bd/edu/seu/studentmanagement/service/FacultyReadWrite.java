package bd.edu.seu.studentmanagement.service;

import bd.edu.seu.studentmanagement.users.Faculty;
import bd.edu.seu.studentmanagement.users.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FacultyReadWrite {
    public void save(Faculty faculty) {
        try{
            Connection connection = Singleton.getConnection();
            Statement statement = connection.createStatement();
            //insert into faculty value('Mahbub', 'MAHB', 'MAHB100', 15, 'Summer', 'nasdas');
            String query = "INSERT INTO faculty VALUE('"  +faculty.getName()+ "','"+ faculty.getInitial()  + "', '" + faculty.getPassword() + "'," + faculty.getCredits() + ",'" + faculty.getSemester() + "', '" + faculty.getImage() + "');";
            statement.execute(query);

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public List<Faculty> read() {
        List<Faculty> list = new ArrayList<>();
        try{
            Connection connection = Singleton.getConnection();
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM faculty;";
            ResultSet resultset = statement.executeQuery(query);
            while(resultset.next()){
                String name = resultset.getString("name");
                String initial = resultset.getString("id");
                String password = resultset.getString("password");
                int credits = resultset.getInt("credits");
                String semester = resultset.getString("semester");
                String image = resultset.getString("iimage");
                Faculty faculty = new Faculty(name, initial, password, credits, semester, image);
                list.add(faculty);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }


    public void delete(String line) {
        try{
            Connection connection = Singleton.getConnection();
            Statement statement = connection.createStatement();
            String query = "DELETE FROM faculty WHERE id = '"+ line + "';";
            statement.execute(query);



        }catch(SQLException e){
            e.printStackTrace();
        }
    }



}
