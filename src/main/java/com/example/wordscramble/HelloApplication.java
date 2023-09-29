package com.example.wordscramble;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;

public class HelloApplication extends Application {
    static Scanner m_scanInput = new Scanner(System.in);
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 640, 480);
        stage.setTitle("WordScramble");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws IOException {
//        TODO change to doesn't use the args but a menu to know if the user want to play in console or with the interface
        if (args[0].equals("0"))
        {
            ConsoleManager console = new ConsoleManager();
            console.main();
        }
        else if (args[0].equals("1"))
            launch();

    }
}