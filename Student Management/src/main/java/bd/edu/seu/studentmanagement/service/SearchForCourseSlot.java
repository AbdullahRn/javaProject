package bd.edu.seu.studentmanagement.service;

import bd.edu.seu.studentmanagement.dependentOnSemester.StudentCourseInfo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SearchForCourseSlot {

    public List<Integer> searchFromStudent(String id) {
        List<Integer> list = new ArrayList<>();
        try {
            Connection connection = Singleton.getConnection();
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM studentcourselist WHERE ID ='" + id + "';";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int c = resultSet.getInt("slot");

                list.add(c);
                }
            }catch (SQLException e) {
                e.printStackTrace();
            }
            return list;
        }


    public List<Integer> searchFromFaculty(String faculty, int slot) {
        List<Integer> list = new ArrayList<>();
        try {
            Connection connection = Singleton.getConnection();
            Statement statement = connection.createStatement();
            //SELECT * FROM COURSE WHERE FACULTY = 'NOOR' AND SLOT =4;
            String query = "SELECT * FROM course WHERE faculty ='" + faculty + "' AND slot = " + slot +";";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int c = resultSet.getInt("slot");

                list.add(c);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


}


