package org.example.vidmot;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import vinnsla.Lag;
import vinnsla.Lagalistar;

/**
 * Controller klasi sem stjórnar listi-view.fxml
 */
public class ListiController {

    @FXML
    private ListView<Lag> list;

    @FXML
    private ImageView selectedImage;

    @FXML
    private ImageView pauseImage;

    @FXML
    private ImageView listImage;

    @FXML
    private ProgressBar selectedProgress;

    private Media media;

    private MediaPlayer mediaPlayer;

    private Image play = new Image(getClass().getResource("/vidmot/media/play.png").toString());
    private Image pause = new Image(getClass().getResource("/vidmot/media/pause.png").toString());

    private Status status = Status.PAUSED;

    /**
     * Enum fyrir hvort sé verið að spila eða ekki
     */
    private enum Status {
        PLAYING,PAUSED;
    }

    /**
     * Initialize fall
     */
    @FXML
    public void initialize() {
        list.setItems(Lagalistar.getLagalisti().getListi());

        pauseImage.setImage(pause);

        listImage.setImage(Lagalistar.getLagalisti().getAlbumCover());

        list.getSelectionModel().selectedItemProperty().addListener(e -> {
            Lag selectedSong = list.getSelectionModel().getSelectedItem();
            int index = list.getSelectionModel().getSelectedIndex();
            songIndex(index);
            playSong(selectedSong);
        });
    }

    /**
     * Höndlar þegar notandi ýtir á return takkann og skiptir í MAIN view
     */
    @FXML
    private void onReturn() {
        if (mediaPlayer!=null) {
            mediaPlayer.stop();
        }
        status = Status.PAUSED;
        ViewSwitcher.switchTo(View.MAIN);
    }

    /**
     * Höndlar þegar notandi ýtir á pause/play takkann
     * @param actionEvent actionEvent sem triggeraði button action
     */
    @FXML
    private void onPlayPause(ActionEvent actionEvent) {
        try {
            if (status == Status.PLAYING) {
                pauseImage.setImage(play);
                status = Status.PAUSED;
                mediaPlayer.pause();
            } else {
                pauseImage.setImage(pause);
                status = Status.PLAYING;
                mediaPlayer.play();
            }
        } catch (NullPointerException ignored) {}
    }

    /**
     * Setur hvaða lag á að nota
     * @param index númer hvað í röðinni er lagið
     */
    private void songIndex(int index) {
        Lagalistar.getLagalisti().setIndex(index);
    }

    /**
     * Spilar gefið lag
     * @param lag lag sem á að spila
     */
    private void playSong(Lag lag) {
        selectedImage.setImage(lag.getImage());
        media = new Media(lag.getURL());
        makePlayer(lag);
        status = Status.PLAYING;
        pauseImage.setImage(pause);
    }

    /**
     * Býr til nýjan mediaPlayer fyrir lögin
     * @param lag lagið sem á að spila
     */
    private void makePlayer(Lag lag) {
        if (mediaPlayer != null) mediaPlayer.stop();
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.currentTimeProperty().addListener((observable, old, newValue) ->
                selectedProgress.setProgress(newValue.divide(media.getDuration()).toMillis()));
        mediaPlayer.setStopTime(media.getDuration());
        mediaPlayer.setOnEndOfMedia(this::nextSong);
    }

    /**
     * Setur næsta lag á
     */
    private void nextSong() {
        list.getSelectionModel().select(list.getSelectionModel().getSelectedIndex()+1);
    }
}
