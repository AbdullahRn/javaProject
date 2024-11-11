package bd.edu.seu.studentmanagement.service;

import bd.edu.seu.studentmanagement.users.Faculty;
import bd.edu.seu.studentmanagement.users.Officer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OfficerReadWrite {
    public void save(Officer officer) {
        try{
            Connection connection = Singleton.getConnection();
            Statement statement = connection.createStatement();
            //insert into officer value('Mahbub', 'MAHB', 'MAHB100', 15, 'Summer', 'nasdas');
            String query = "INSERT INTO officer VALUE('"  +officer.getName()+ "','"+ officer.getId()  + "', '" + officer.getPassword() + "','" + officer.getImage() + "','" + officer.getReference() + "');";
            statement.execute(query);

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public List<Officer> read() {
        List<Officer> list = new ArrayList<>();
        try{
            Connection connection = Singleton.getConnection();
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM officer;";
            ResultSet resultset = statement.executeQuery(query);
            while(resultset.next()){
                String name = resultset.getString("name");
                String initial = resultset.getString("id");
                String password = resultset.getString("password");
                String reference = resultset.getString("reference");
                String image = resultset.getString("image");
                Officer officer = new Officer(name, initial, password, image, reference);
                list.add(officer);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }


}
