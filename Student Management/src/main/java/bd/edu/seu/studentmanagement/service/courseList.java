package bd.edu.seu.studentmanagement.service;

import bd.edu.seu.studentmanagement.otherClasses.Course;
import bd.edu.seu.studentmanagement.users.Student;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class courseList {
    public void save(Course course) {
        try{
            Connection connection = Singleton.getConnection();
            Statement statement = connection.createStatement();

            //String query = "INSERT INTO course VALUE('"  +course.()+ "', '"+ student.getId()  + "', '" + student.getPassword()  + "'," + student.getHscGpa() + "," + student.getWaiver() + ","+ student.getCgpa() + ", '" + student.getImageURL() + "');";
            //statement.execute(query);

        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
