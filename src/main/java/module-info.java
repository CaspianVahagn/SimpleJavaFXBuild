module myModule{
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    opens com.project.main;
}