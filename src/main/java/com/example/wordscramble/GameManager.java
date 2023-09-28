package com.example.wordscramble;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameManager {
    public boolean endGame = false;
    private List<String> m_listWords;
    private String m_sOriginalWord;
    protected StringBuilder m_sShuffleWord;
    protected int m_iScore = 0;
    long start;

    File m_fileName;
    FileReader m_fd;
    int MIN_LEN_WORD_EASY = 2;
    int MAX_LEN_WORD_EASY = 4;
    int MIN_LEN_WORD_MEDIUM = 5;
    int MAX_LEN_WORD_MEDIUM = 7;
    int MIN_LEN_WORD_HARD = 8;
    int MAX_LEN_WORD_HARD = 12;

    public GameManager() throws IOException {
        StringBuilder menuInfo = new StringBuilder("Choose a difficulty:\n");
        Menu menu = new Menu();

        Difficulties diff = menu.displayDifficultyMenu(menuInfo);
        int level = 0;
        switch (diff) {
            case EASY -> {
                startGame(MIN_LEN_WORD_EASY, MAX_LEN_WORD_EASY);
            }
            case MEDIUM -> {
                startGame(MIN_LEN_WORD_MEDIUM, MAX_LEN_WORD_MEDIUM);
            }
            case HARD -> {
                startGame(MIN_LEN_WORD_HARD, MAX_LEN_WORD_HARD);
            }
        }
    }

    public void startGame(int p_min, int p_max) throws IOException {
        start = System.currentTimeMillis();
        shuffleLetters(p_min, p_max);
    }
    public void shuffleLetters(int p_min, int p_max) throws IOException {
//        search a word that correspond to the predica with filter and return only one word
        m_listWords = Files.readAllLines(Paths.get("D:\\1 projects\\Java\\WordScramble\\src\\main\\resources\\words.txt"))
                .stream()
                .filter(words -> words.length() >= p_min && words.length() <= p_max) // Filter words into min and max characters.
                .toList();

        int max = m_listWords.size();
        int randNbr = (int) (1 + Math.random() * max);

        m_sOriginalWord = m_listWords.get(randNbr);

        List<Character> characters = new ArrayList<>();


        for (char c : m_sOriginalWord.toCharArray()) {
            characters.add(c);
        }

        Collections.shuffle(characters);

        m_sShuffleWord = new StringBuilder();
        for (Character character : characters) {
            m_sShuffleWord.append(character);
        }
    }

    public boolean checkAnswer(String p_userAnswer)
    {
        return p_userAnswer.equalsIgnoreCase(m_sOriginalWord);
    }

    public int score() {
        return m_iScore;
    }
}
