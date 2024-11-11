package bd.edu.seu.studentmanagement.service;

import bd.edu.seu.studentmanagement.HelloApplication;
import bd.edu.seu.studentmanagement.users.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentReadWrite {
    public void save(Student student) {
        try{
            Connection connection = Singleton.getConnection();
            Statement statement = connection.createStatement();

            String query = "INSERT INTO student VALUE('"  +student.getName()+ "', '"+ student.getId()  + "', '" + student.getPassword()  + "'," + student.getHscGpa() + "," + student.getWaiver() + ","+ student.getCgpa() + ", '" + student.getImageURL() + "','" + HelloApplication.currentSemester + "');";
            statement.execute(query);

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public List<Student> read() {
        List<Student> list = new ArrayList<>();
        try{
            Connection connection = Singleton.getConnection();
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM student;";
            ResultSet resultset = statement.executeQuery(query);
            while(resultset.next()){
                String name = resultset.getString("name");
                String id = resultset.getString("id");
                String password = resultset.getString("password");
                Double hscGpa = resultset.getDouble("hscGpa");
                Double waiver = resultset.getDouble("waiver");
                Double cgpa = resultset.getDouble("cgpa");
                String imageURL = resultset.getString("imageURL");
                Student student = new Student(name, id, password, hscGpa, waiver, cgpa, imageURL);
                list.add(student);
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
            String query = "DELETE FROM student WHERE id = '"+ line + "';";
            statement.execute(query);



        }catch(SQLException e){
            e.printStackTrace();
        }
    }

}
