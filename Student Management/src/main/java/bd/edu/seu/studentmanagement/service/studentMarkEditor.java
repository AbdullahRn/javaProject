package bd.edu.seu.studentmanagement.service;

import bd.edu.seu.studentmanagement.otherClasses.Marks;
import bd.edu.seu.studentmanagement.users.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class studentMarkEditor {
    public void save(Marks marks) {
        try{
            Connection connection = Singleton.getConnection();
            Statement statement = connection.createStatement();

            String query = "INSERT INTO studentMarks VALUE('"  +marks.getId()+ "', "+ marks.getQuiz()  + ", " + marks.getAttendance()  + "," + marks.getMid() + "," + marks.getAssignment() + ","+ marks.getFinale() + ", '" +marks.getSemester() + "');";
            statement.execute(query);

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public List<Marks> read() {
        List<Marks> list = new ArrayList<>();
        try{
            Connection connection = Singleton.getConnection();
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM studentMarks;";
            ResultSet resultset = statement.executeQuery(query);
            while(resultset.next()){
                String id = resultset.getString("id");
                Double quiz = resultset.getDouble("quiz");
                Double attendance = resultset.getDouble("attendance");
                Double mid = resultset.getDouble("mid");
                Double assignment = resultset.getDouble("assignment");
                Double finale = resultset.getDouble("final");
                String semester = resultset.getString("semester");

                Marks marks = new Marks(id,quiz,attendance,mid,assignment,finale,semester);
                list.add(marks);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }
}
