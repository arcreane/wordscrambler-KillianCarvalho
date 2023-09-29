package com.example.wordscramble;

import java.io.IOException;

public class ConsoleManager {
    int MIN_LEN_WORD_EASY = 2;
    int MAX_LEN_WORD_EASY = 4;
    int MIN_LEN_WORD_MEDIUM = 5;
    int MAX_LEN_WORD_MEDIUM = 7;
    int MIN_LEN_WORD_HARD = 8;
    int MAX_LEN_WORD_HARD = 12;
    String userInput;
    public void main() throws IOException {

        System.out.println("       ░▒█░░▒█░▄▀▀▄░█▀▀▄░█▀▄░▒█▀▀▀█░█▀▄░█▀▀▄░█▀▀▄░█▀▄▀█░█▀▀▄░█░░█▀▀");
        System.out.println("       ░▒█▒█▒█░█░░█░█▄▄▀░█░█░░▀▀▀▄▄░█░░░█▄▄▀░█▄▄█░█░▀░█░█▀▀▄░█░░█▀▀");
        System.out.println("       ░▒▀▄▀▄▀░░▀▀░░▀░▀▀░▀▀░░▒█▄▄▄█░▀▀▀░▀░▀▀░▀░░▀░▀░░▒▀░▀▀▀▀░▀▀░▀▀▀\n");

        GameManager gameManager = new GameManager();
        StringBuilder menuInfo = new StringBuilder("Choose a difficulty:\n");
        Menu menu = new Menu();

        Difficulties diff = menu.displayDifficultyMenu(menuInfo);
        int level = 0;
        switch (diff) {
            case EASY -> {
                gameManager.startGame(MIN_LEN_WORD_EASY, MAX_LEN_WORD_EASY);
            }
            case MEDIUM -> {
                gameManager.startGame(MIN_LEN_WORD_MEDIUM, MAX_LEN_WORD_MEDIUM);
            }
            case HARD -> {
                gameManager.startGame(MIN_LEN_WORD_HARD, MAX_LEN_WORD_HARD);
            }
        }
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
