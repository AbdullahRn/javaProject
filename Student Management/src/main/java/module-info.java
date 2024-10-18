module bd.edu.seu.studentmanagement {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens bd.edu.seu.studentmanagement to javafx.fxml;
    exports bd.edu.seu.studentmanagement;

    opens bd.edu.seu.studentmanagement.controller to javafx.fxml;
    exports bd.edu.seu.studentmanagement.controller;
}