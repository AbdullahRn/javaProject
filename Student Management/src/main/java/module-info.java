module bd.edu.seu.studentmanagement {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;
    requires mysql.connector.j;

    opens bd.edu.seu.studentmanagement to javafx.fxml;
    exports bd.edu.seu.studentmanagement;

    opens bd.edu.seu.studentmanagement.controller to javafx.fxml;
    exports bd.edu.seu.studentmanagement.controller;

    exports bd.edu.seu.studentmanagement.popupController;
    opens bd.edu.seu.studentmanagement.popupController to javafx.fxml;


}