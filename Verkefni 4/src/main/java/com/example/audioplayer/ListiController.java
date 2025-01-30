package com.example.audioplayer;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import vinnsla.Lag;
import vinnsla.LagaListar;

public class ListiController {
    @FXML
    private ListView<Lag> listi;

    private MediaPlayer mediaPlayer;

    @FXML
    private ProgressBar progressBar;

    @FXML
    private ImageView selectedImage;

    private Status status;

    private enum Status {
        PLAYING,PAUSED;
    }

    public void initialize() {
        listi.setItems(LagaListar.getListi().getListi());

        listi.getSelectionModel().selectedItemProperty().addListener(e -> {
            Lag lag = listi.getSelectionModel().getSelectedItem();
            playLag(lag);
        });

        status = Status.PAUSED;
    }


    private void playLag(Lag lag) {
        Media media = new Media(lag.getURL());
        makePlayer(media);
        selectedImage.setImage(lag.getImage());
        status = Status.PLAYING;
    }

    private void makePlayer(Media media) {
        if (mediaPlayer != null) mediaPlayer.stop();
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.currentTimeProperty().addListener((observable, old, newValue) -> {
            progressBar.setProgress(newValue.divide(media.getDuration()).toMillis());
        });
        mediaPlayer.setOnEndOfMedia(this::nextSong);
    }

    private void nextSong() {
        listi.getSelectionModel().select(listi.getSelectionModel().getSelectedIndex()+1);
    }

    @FXML
    private void playPause() {
        if (status == Status.PAUSED) {
            status = Status.PLAYING;
            mediaPlayer.play();
        }
        else if (status == Status.PLAYING) {
            status = Status.PAUSED;
            mediaPlayer.pause();
        }
    }

    @FXML
    private void returnHandler() {
        mediaPlayer.stop();
        ViewSwitcher.switchTo(View.MAIN);
    }
}
