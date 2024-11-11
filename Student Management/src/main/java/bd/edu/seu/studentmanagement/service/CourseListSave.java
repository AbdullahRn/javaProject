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

public class CourseListSave {
    public void save(Course course) {
        try{
            Connection connection = Singleton.getConnection();
            Statement statement = connection.createStatement();
            //insert into course value('DEMO 3', 'DEMO33', 0, 'null', 0, 'null', 36);
            String query = "INSERT INTO course VALUE('"  +course.getName()+ "', '"+ course.getCode()  + "', 0 ,'" + course.getFaculty()+ "'," +course.getTotalStudent()+", '"+ course.getSemester()+"' , " + course.getTotalSeat()  +");";
            statement.execute(query);

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void assignCourseForIndividualSemester(Course course) {
        try{
            Connection connection = Singleton.getConnection();
            Statement statement = connection.createStatement();
            //select * from course where code = 'CSE281';
            String query= "SELECT * FROM course WHERE code = '" + course.getCode() + "';";
            ResultSet resultSet = statement.executeQuery(query);
            List<String> list = new ArrayList<>();
            while(resultSet.next()){
                String c = resultSet.getString("name");
                list.add(c);
            }
            String courseName ="";
            if(list.isEmpty()){
                courseName ="";
            }
            else{
                courseName = list.get(0);
            }


            //update course set faculty = 'SAMD' where code = '123213';
            query = "INSERT INTO course VALUE('"  +courseName+ "', '"+ course.getCode()  + "',"+  course.getSlot() +",'" + course.getFaculty()+ "'," +course.getTotalStudent()+", '"+ HelloApplication.currentSemester +  "');";
            statement.execute(query);

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

//ekta course create kra hbe, jeta shob semester er jonno thakbe, then per semester oi course take copy kre new course banay faculty assign kra hbe
    public void assignFacultyToExistingCourse(Course course) {
        try{
            Connection connection = Singleton.getConnection();
            Statement statement = connection.createStatement();
            System.out.println(course.getFaculty());
            System.out.println(course.getCode());
            //update course set faculty = 'SAMD' where code = '123213';
            String query = "DELETE FROM course WHERE code = '" + course.getCode()+ "' AND semester = '" + HelloApplication.currentSemester  + "';";
            statement.execute(query);
            query= "SELECT * FROM course WHERE code = '" + course.getCode()+ "' AND semester = 'null';";
            ResultSet resultSet =  statement.executeQuery(query);
            String courseName ="null";
            int totalSeat = 0;
            while(resultSet.next()){
                courseName = resultSet.getString("name");
                totalSeat = resultSet.getInt("totalSeat");
                System.out.println(courseName);
                System.out.println(totalSeat);
                System.out.println(resultSet.getString("semester"));
            }


            //Course course2 = new Course(course.getCode(), course.getSlot(), courseName,  course.getFaculty(),course.getTotalStudent(), HelloApplication.currentSemester, totalSeat );

            query = "INSERT INTO course VALUE('"  +courseName+ "', '"+ course.getCode()  + "',"+  course.getSlot() +",'" + course.getFaculty()+ "'," +course.getTotalStudent()+", '"+ HelloApplication.currentSemester + "', "+ totalSeat + ");";
            statement.execute(query);


            //save(course2);
//            query = "UPDATE course SET faculty = '"  +course.getFaculty()+ "'  WHERE CODE = '"+ course.getCode()  + "';";
//            statement.execute(query);

        }catch(SQLException e){
            e.printStackTrace();
        }
    }


    public void studentCountIncrement(Course course) {
        try{
            Connection connection = Singleton.getConnection();
            Statement statement = connection.createStatement();
            //update course set totalStudent = totalStudent + 1 where code = 'MAT261';
            String query = "UPDATE course SET totalStudent = totalStudent + 1  WHERE code = '"+ course.getCode() +"' and semester = '" + HelloApplication.currentSemester + "';";
            statement.execute(query);

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void studentCountDecrement(Course course) {
        try{
            Connection connection = Singleton.getConnection();
            Statement statement = connection.createStatement();
            //update course set totalStudent = totalStudent + 1 where code = 'MAT261';
            String query = "UPDATE course SET totalStudent = totalStudent - 1  WHERE code = '"+ course.getCode() +"' and semestter = '" + HelloApplication.currentSemester + "';";
            statement.execute(query);

        }catch(SQLException e){
            e.printStackTrace();
        }
    }





    public List<Course> getCourseList(){
        List<Course> courseList = new ArrayList<Course>();
        try{
            Connection connection = Singleton.getConnection();
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM course;";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                String name= resultSet.getString("name");
                String code = resultSet.getString("code");
                int slot = resultSet.getInt("slot");
                String faculty = resultSet.getString("faculty");
                int totalStudent = resultSet.getInt("totalStudent");
                String semester = resultSet.getString("semester");
                int totalSeat = resultSet.getInt("totalSeat");
                Course course = new Course(code, slot , name, faculty, totalStudent, semester, totalSeat);
                courseList.add(course);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return courseList;
    }

    public List<Course> GetFacultyCourseList(Faculty faculty){
        List<Course> list = new ArrayList<Course>();
        try{
            Connection connection = Singleton.getConnection();
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM course WHERE faculty = '"+ faculty.getInitial()+"';";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                String name= resultSet.getString("name");
                String code = resultSet.getString("code");
                int slot = resultSet.getInt("slot");
                String f = resultSet.getString("faculty");
                int totalStudent = resultSet.getInt("totalStudent");
                String semester = resultSet.getString("semester");
                Course course = new Course(code, slot , name, f, totalStudent, semester);
                list.add(course);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    public List<Course> GetStudentInCourseList(String id){
        List<Course> list = new ArrayList<Course>();
        try{
            Connection connection = Singleton.getConnection();
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM studentcourselist WHERE id = '"+ id + "';";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                String code = resultSet.getString("code");

                String iD = resultSet.getString("id");

//                Course course = new Course(code, iD);
//                list.add(course);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }


    public void addStudentsToCourse(String code, String id, String semester, int slot){
        try{
            Connection connection = Singleton.getConnection();
            Statement statement = connection.createStatement();
            String query = "INSERT INTO studentcourselist VALUE('"  +code+ "' , '"+ id  + "','" + semester+ "', "+ slot +");";
            statement.execute(query);

        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
