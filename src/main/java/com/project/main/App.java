package com.project.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileInputStream;

public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        // What I want to accomplish - Works If I build a Jar
        Parent p = loader.load(App.class.getClassLoader().getResource("test.fxml"));
        Scene s = new Scene (p,200,200);
        stage.setScene(s);
        stage.show();
    }
}
