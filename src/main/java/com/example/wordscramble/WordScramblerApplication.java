package com.example.wordscramble;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;

public class WordScramblerApplication extends Application {
    static Scanner m_scanInput = new Scanner(System.in);
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(WordScramblerApplication.class.getResource("wordScrambler-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 750, 550);
        stage.setTitle("WordScramble");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws IOException {
        boolean haveChoice = false;
        while (!haveChoice) {
            System.out.println("Choose a type of game:\n1- Console\n2- Graphics");
            String choice = m_scanInput.nextLine();
            if (choice.equals("1"))
            {
                ConsoleManager console = new ConsoleManager();
                console.main();
                haveChoice = true;
            }
            else if (choice.equals("2")) {
                launch();
                haveChoice = true;
            }
            else {
                System.out.println("Please choose an existing options !");
            }
        }

    }
}