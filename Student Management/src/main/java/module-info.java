module bd.edu.seu.studentmanagement {
    requires javafx.controls;
    requires javafx.fxml;


    opens bd.edu.seu.studentmanagement to javafx.fxml;
    exports bd.edu.seu.studentmanagement;
}