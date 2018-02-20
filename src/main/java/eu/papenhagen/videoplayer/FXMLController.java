package eu.papenhagen.videoplayer;

import java.io.File;
import java.io.FileFilter;
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
import javafx.scene.layout.VBox;
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

        VBox buttonBox = new VBox();
        buttonBox.setSpacing(5);

        File testDirectory = new File("C://home//");
        File[] files = testDirectory.listFiles((File pathname) -> {
            String name = pathname.getName().toLowerCase();
            return name.endsWith(".mp4") && pathname.isFile();
        });

        for (File file : files) {
            System.out.println("" + file.getName());
            Button play = new Button(file.getName());
            play.setOnAction((ActionEvent event) -> {
                showScreen(file.getName());
            });
            buttonBox.getChildren().add(play);
        }

        box.getChildren().add(buttonBox);
    }

    private void showScreen(String fileLocation) {
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(10));
        hbox.setAlignment(Pos.CENTER);

        Media media = new Media("file:///C://home//" + fileLocation);
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
