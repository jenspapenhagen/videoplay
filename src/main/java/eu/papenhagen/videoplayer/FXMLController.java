package eu.papenhagen.videoplayer;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.scene.media.MediaView;

public class FXMLController implements Initializable {

    @FXML
    private Button play1;
    @FXML
    private Button play2;
    @FXML
    private MediaView mediaView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // Create a Media
        Media media1 = new Media(getClass().getResource("Test.mp4").toExternalForm());
        Media media2 = new Media(getClass().getResource("Test2.mp4").toExternalForm());

        // Create a Media Player for every new video file.
        MediaPlayer player1 = new MediaPlayer(media1);
        MediaPlayer player2 = new MediaPlayer(media2);

        player1.setAutoPlay(false);

        mediaView.setSmooth(true);
        mediaView.setMediaPlayer(player1);

        play1.setOnAction((ActionEvent event) -> {
            if (player1.getStatus() == Status.PLAYING) {
                player1.stop();
                player1.play();
            } else {
                player1.play();
            }
        });
        
        play2.setOnAction((ActionEvent event) -> {
            mediaView.setMediaPlayer(player2);
            if (player2.getStatus() == Status.PLAYING) {
                player2.stop();
                player2.play();
            } else {
                player2.play();
            }
        });

    }

}
