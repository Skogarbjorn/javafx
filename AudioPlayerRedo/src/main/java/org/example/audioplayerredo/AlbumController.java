package org.example.audioplayerredo;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import vinnsla.Lag;
import vinnsla.Lagalistar;
import vinnsla.Lagalisti;

public class AlbumController {
    @FXML
    private ListView<Lag> fxList;
    @FXML
    private ImageView fxImage;
    @FXML
    private ImageView fxAlbumCover;
    @FXML
    private ImageView fxPlayPauseImage;
    @FXML
    private ProgressBar fxProgress;

    private Lagalisti list;
    private Status status = Status.PAUSED;
    private MediaPlayer mediaPlayer;

    private enum Status {
        PLAYING(new Image(MainApplication.class.getResource("/vidmot/media/pause.png").toString())),
        PAUSED(new Image(MainApplication.class.getResource("/vidmot/media/play.png").toString()));

        private Image image;

        Status(Image s) {
            image = s;
        }

        Image getImage() {
            return image;
        }
    }

    @FXML
    private void playPauseHandler() {
        if (mediaPlayer == null) return;
        switch (status) {
            case PLAYING:
                pause();
                break;
            case PAUSED:
                play();
                break;
            default:
                break;
        }
    }

    private void play() {
        status = Status.PLAYING;
        fxPlayPauseImage.setImage(status.getImage());
        mediaPlayer.play();
    }
    private void pause() {
        status = Status.PAUSED;
        fxPlayPauseImage.setImage(status.getImage());
        mediaPlayer.pause();
    }

    private void playSong(Lag lag) {
        fxImage.setImage(lag.getImage());
        Media song = new Media(lag.getLag());
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
        mediaPlayer = new MediaPlayer(song);
        mediaPlayer.setOnEndOfMedia(this::nextSong);
        mediaPlayer.setStopTime(song.getDuration());
        mediaPlayer.currentTimeProperty().addListener((observable, oldValue, newValue) -> {
            fxProgress.setProgress(newValue.toMillis()/song.getDuration().toMillis());
        });
        play();
    }

    private void nextSong() {
        fxList.getSelectionModel().selectNext();
    }

    @FXML
    private void onReturn() {
        if (mediaPlayer != null) mediaPlayer.stop();
        status = Status.PAUSED;
        ViewSwitcher.switchTo(View.MAIN);
    }

    public void initialize() {
        list = Lagalistar.selected;
        fxAlbumCover.setImage(list.getImage());

        fxList.setItems(list.getSongs());
        fxList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            playSong(newValue);
            System.out.println(newValue.getImage().getUrl());
        });
    }
}
