package bd.edu.seu.studentmanagement.service;

import bd.edu.seu.studentmanagement.HelloApplication;
import bd.edu.seu.studentmanagement.dependentOnSemester.StudentCourseInfo;
import bd.edu.seu.studentmanagement.dependentOnSemester.StudentSemesterInfo;
import bd.edu.seu.studentmanagement.users.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentSemesterInfoReadWrite {
    public void save(Student student) {
        try{
            Connection connection = Singleton.getConnection();
            Statement statement = connection.createStatement();
            Double gpa = 0.0;
            Double payment = 0.0;
            int credits = 0;
            Double sumOfGrades = 0.0;
            String query = "INSERT INTO studentSemesterInfo VALUE('"  +student.getId()+ "', '"+ HelloApplication.currentSemester  + "', " + gpa  + "," + payment + "," + credits + ","+ sumOfGrades + ");";
            statement.execute(query);

        }catch(SQLException e){
            e.printStackTrace();
        }
    }


    /////////////////////////////
    // jei jei course add kra hoise oigular grade add kre update krte hbe
//    public void update(StudentCourseInfo student) {
//        try{
//            Connection connection = Singleton.getConnection();
//            Statement statement = connection.createStatement();
//            Double gpa = 0.0;
//            Double payment = 0.0;
//            int credits = 0;
//            Double sumOfGrades = 0.0;
//            String query = "UPDATE studentSemesterInfo set "
//            String query = "INSERT INTO studentSemesterInfo VALUE('"  +student.getId()+ "', '"+ HelloApplication.currentSemester  + "', " + gpa  + "," + payment + "," + credits + ","+ sumOfGrades + ");";
//            statement.execute(query);
//
//        }catch(SQLException e){
//            e.printStackTrace();
//        }
//    }

    public List<StudentSemesterInfo> read() {
        List<StudentSemesterInfo> list = new ArrayList<>();
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
               // StudentSemesterInfo student = new StudentSemesterInfo(name, id, password, hscGpa, waiver, cgpa, imageURL);
                //list.add(student);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }



}
