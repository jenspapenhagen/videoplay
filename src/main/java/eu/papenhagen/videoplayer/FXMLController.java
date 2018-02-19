package eu.papenhagen.videoplayer;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class FXMLController implements Initializable {

    @FXML
    private HBox box;

    private Scene scene;

    private Stage stage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        stage = new Stage();

        Button play1 = new Button("Play 1");
        play1.setOnAction((ActionEvent event) -> {
            showScreen("test1.mp4");
        });

        Button play2 = new Button("Play 2");
        play2.setOnAction((ActionEvent event) -> {
            showScreen("test2.mp4");
        });

        box.getChildren().addAll(play1, play2);
    }

    private void showScreen(String fileLocation) {
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(10));
        hbox.setAlignment(Pos.CENTER);

        Media media = new Media(getClass().getResource(fileLocation).toExternalForm());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.pause();
        mediaPlayer.setMute(true);
        mediaPlayer.setAutoPlay(true);

        MediaView mediaView = new MediaView(mediaPlayer);
        mediaView.setMediaPlayer(mediaPlayer);

        mediaPlayer.play();
        mediaPlayer.setMute(false);
        mediaPlayer.setOnError(() -> System.out.println("Current error: " + mediaPlayer.getError()));

        hbox.getChildren().add(mediaView);
        scene = new Scene(hbox, 640, 480);
        stage.setScene(scene);
        if (!stage.isShowing()) {
            stage.show();
        }
    }

}
