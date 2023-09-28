package com.example.wordscramble;

import java.io.IOException;

public class ConsoleManager {
    String userInput;
    public void main() throws IOException {

        System.out.println("       ░▒█░░▒█░▄▀▀▄░█▀▀▄░█▀▄░▒█▀▀▀█░█▀▄░█▀▀▄░█▀▀▄░█▀▄▀█░█▀▀▄░█░░█▀▀");
        System.out.println("       ░▒█▒█▒█░█░░█░█▄▄▀░█░█░░▀▀▀▄▄░█░░░█▄▄▀░█▄▄█░█░▀░█░█▀▀▄░█░░█▀▀");
        System.out.println("       ░▒▀▄▀▄▀░░▀▀░░▀░▀▀░▀▀░░▒█▄▄▄█░▀▀▀░▀░▀▀░▀░░▀░▀░░▒▀░▀▀▀▀░▀▀░▀▀▀\n");

        GameManager gameManager = new GameManager();
        while (!gameManager.endGame) {
            System.out.println("word: " + gameManager.m_sShuffleWord);
            System.out.print("> ");
            userInput = HelloApplication.m_scanInput.nextLine();
            if (userInput.equalsIgnoreCase("exit")) {
                System.out.println("You have leave the session.");
                break;
            }
            if (gameManager.checkAnswer(userInput))
            {
                long duration =  (System.currentTimeMillis() - gameManager.start) / 1000;
                System.out.println("Good Job ! You have found the original word in " + duration + "s.");
                gameManager.endGame = true;
            }
            else
            {
                System.out.println("It's not the word, try again please.");
            }
        }
        System.out.println("Do you want to restart ? Say 'yes' if you want.");
        System.out.print("> ");
        userInput = HelloApplication.m_scanInput.nextLine();
        if (userInput.equalsIgnoreCase("yes"))
            main();
        System.out.println("Thanks you have to have play ! Good bye !");
        System.exit(0);
    }
}
