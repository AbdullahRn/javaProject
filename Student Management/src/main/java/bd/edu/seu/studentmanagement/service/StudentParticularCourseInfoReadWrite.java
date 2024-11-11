package bd.edu.seu.studentmanagement.service;

import bd.edu.seu.studentmanagement.HelloApplication;
import bd.edu.seu.studentmanagement.controller.FacultyPortalController;
import bd.edu.seu.studentmanagement.dependentOnSemester.StudentCourseInfo;
import bd.edu.seu.studentmanagement.otherClasses.Course;
import bd.edu.seu.studentmanagement.users.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentParticularCourseInfoReadWrite {


//    public void AssignValueToSemesterInfo(String courseCode) {
//        try{
//            Connection connection = Singleton.getConnection();
//            Statement statement = connection.createStatement();
//            //select * from course where code = 'CSE281';
//            String query= "SELECT * FROM course WHERE code = '" + courseCode + "';";
//            ResultSet resultSet = statement.executeQuery(query);
//            List<String> list = new ArrayList<>();
//            while(resultSet.next()){
//                String c = resultSet.getString("id");
//                list.add(c);
//            }
//
//            String courseName = list.get(0);
//
//            //update course set faculty = 'SAMD' where code = '123213';
//            query = "INSERT INTO course VALUE('"  +courseName+ "', '"+ course.getCode()  + "',"+  course.getSlot() +",'" + course.getFaculty()+ "'," +course.getTotalStudent()+", '"+ HelloApplication.currentSemester +  "');";
//            statement.execute(query);
//
//        }catch(SQLException e){
//            e.printStackTrace();
//        }
//    }

    public void deletePreviousInfo(StudentCourseInfo studentCourseInfo){
        try{
            Connection connection = Singleton.getConnection();
            Statement statement = connection.createStatement();
            System.out.println("it's coming to save method");

            //delete from studentcourseinfo where name='Abdullah' and marks =100;
            String query = "DELETE FROM studentcourseinfo WHERE courseCode = '"+ studentCourseInfo.getCourseCode() +"' AND semester =  '"+ HelloApplication.currentSemester +  "';";
            statement.execute(query);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void save(StudentCourseInfo studentCourseInfo) {
        try {
            Connection connection = Singleton.getConnection();
            Statement statement = connection.createStatement();
            System.out.println("it's coming to save method");
            //insert into studentcourseinfo value('demo', '1234', 3, 'DEMO1', 'SUM24', 50, 2.49, 'file:/C:/Users/Abdullah/Downloads/IMG_4159.DNG');
            String query = "INSERT INTO studentcourseinfo VALUE('" + studentCourseInfo.getName() + "' , '" + studentCourseInfo.getId() + "' , " + studentCourseInfo.getCgpa() + " , '" + studentCourseInfo.getCourseCode() + "' , '" + studentCourseInfo.getSemester() + "' , " + studentCourseInfo.getMarks() + " , " + studentCourseInfo.getGrade() + " , '" + studentCourseInfo.getImageURL() + "');";
            statement.execute(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public void update(StudentCourseInfo studentCourseInfo) {
        try {
            Connection connection = Singleton.getConnection();
            Statement statement = connection.createStatement();
            //update studentcourseinfo set marks = 79, grade = 3.75 where semester = 'Summer 24' and id = '123' and courseCode='AI101';
            String query = "update studentcourseinfo set marks =" + studentCourseInfo.getMarks() + ", grade = "+  studentCourseInfo.getGrade()+ " where semester = '" +studentCourseInfo.getSemester() + "' and id = '" +studentCourseInfo.getId() + "' and courseCode = '"  + studentCourseInfo.getCourseCode()+ "';";
            statement.execute(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public List<StudentCourseInfo> GetStudentWhoAreInThisCourse(String code) {
        List<StudentCourseInfo> list = new ArrayList<>();
        try {
            Connection connection = Singleton.getConnection();
            Statement statement = connection.createStatement();
            //select s.name, s.id, s.cgpa, sc.code, sc.semester, s.imageURL from student as s join studentcourselist as sc on s.id = sc.id where sc.code = 'CSE281';
            String query = "select s.name, s.id, s.cgpa, sc.code, sc.semester, s.imageURL from student as s join studentcourselist as sc on s.id = sc.id where sc.code = '" + code + "';";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String c = resultSet.getString("id");

                String name = resultSet.getString("name");
                String id = resultSet.getString("id");
                Double cgpa = resultSet.getDouble("cgpa");
                String courseCode = resultSet.getString("code");
                String semester = resultSet.getString("semester");
                String imageURL = resultSet.getString("imageURL");
                Double marks = 0.0;
                Double grade = 0.0;
                StudentCourseInfo studentCourseInfo = new StudentCourseInfo(name, id, cgpa, courseCode, semester, marks, grade, imageURL);
                list.add(studentCourseInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    //etar argument e student class hbe naki onno class dekhte hbe
    public void addNewStudentToCourseInfoWhenAssigningCourse(Student student) {

    }
}
