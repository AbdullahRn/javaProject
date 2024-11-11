package bd.edu.seu.studentmanagement.service;

import bd.edu.seu.studentmanagement.otherClasses.Log;
import bd.edu.seu.studentmanagement.users.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LogEditor {
    public void save(Log log) {
        try {
            Connection connection = Singleton.getConnection();
            Statement statement = connection.createStatement();

            String query = "INSERT INTO log VALUE('" + log.getAdminName() + "', '" + log.getTask() + "', '" + log.getTime() + "');";
            statement.execute(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Log> read() {
        List<Log> list = new ArrayList<>();
        try{
            Connection connection = Singleton.getConnection();
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM log;";
            ResultSet resultset = statement.executeQuery(query);
            while(resultset.next()){
                String admin = resultset.getString("admin");
                String task = resultset.getString("task");
                String time = resultset.getString("time");

                Log log = new Log(admin, task, time);
                list.add(log);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }

}
