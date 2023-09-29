package com.example.wordscramble;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.io.IOException;

public class HelloController {
    public Label labelTime;
    public Label wordsTentative;
    private Timeline timer;
    private int m_iSeconds = 0;
    private int m_iMinutes = 0;
    public Label LabelShuffleWord;
    public Button buttonTry;
    public TextField userInputForm;
    public Label informationText;
    int MIN_LEN_WORD_EASY = 2;
    int MAX_LEN_WORD_EASY = 4;
    int MIN_LEN_WORD_MEDIUM = 5;
    int MAX_LEN_WORD_MEDIUM = 7;
    int MIN_LEN_WORD_HARD = 8;
    int MAX_LEN_WORD_HARD = 12;
    public Button buttonStart;
    public VBox listDifficulty;
    public Button buttonEasy;
    public Button buttonMedium;
    public Button buttonHard;
    private GameManager session;


    public void startGame(ActionEvent actionEvent) throws IOException {
        session = new GameManager();
        resetTimer();
        if (actionEvent.getSource() == buttonStart)
        {
            listDifficulty.opacityProperty().set(1.0);
            listDifficulty.setDisable(false);
        } else if (actionEvent.getSource() == buttonEasy)
        {
            startTimer();
            session.startGame(MIN_LEN_WORD_EASY, MAX_LEN_WORD_EASY);
            LabelShuffleWord.setText(String.valueOf(session.m_sShuffleWord));
        } else if (actionEvent.getSource() == buttonMedium)
        {
            startTimer();
            session.startGame(MIN_LEN_WORD_MEDIUM, MAX_LEN_WORD_MEDIUM);
            LabelShuffleWord.setText(String.valueOf(session.m_sShuffleWord));
        } else if (actionEvent.getSource() == buttonHard)
        {
            startTimer();
            session.startGame(MIN_LEN_WORD_HARD, MAX_LEN_WORD_HARD);
            LabelShuffleWord.setText(String.valueOf(session.m_sShuffleWord));
        }
    }

    public void exitGame(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void tryAnswer(ActionEvent actionEvent) {
        wordsTentative.setText(userInputForm.getCharacters().toString());
       if (session.checkAnswer(userInputForm.getCharacters().toString()))
       {
           stopTimer();
           informationText.setText("YOU WON !!!");
       }
       else {
           informationText.setText("Wrong ! Try again.");
       }
    }
    @FXML
    private void startTimer() {
        if (timer == null) {
            timer = new Timeline(new KeyFrame(Duration.seconds(1), e -> updateTimer()));
            timer.setCycleCount(Timeline.INDEFINITE); // Exécutez indéfiniment
        }
        timer.play();
    }

    @FXML
    private void stopTimer() {
        if (timer != null) {
            timer.stop();
        }
    }
    @FXML
    private void resetTimer()
    {
        m_iMinutes = 0;
        m_iSeconds = 0;
        String timeString = String.format("%02d:%02d", m_iMinutes, m_iSeconds);
        labelTime.setText(timeString);
    }

    private void updateTimer() {
        m_iSeconds++;
        if (m_iSeconds == 60) {
            m_iSeconds = 0;
            m_iMinutes++;
        }
        String timeString = String.format("%02d:%02d", m_iMinutes, m_iSeconds);
        labelTime.setText(timeString);
    }
}