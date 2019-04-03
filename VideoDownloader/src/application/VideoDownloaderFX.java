package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class VideoDownloaderFX extends Application {

	public static Stage primaryStage;
	
	@Override
	public void start(Stage primaryStage) throws IOException {

		VideoDownloaderFX.primaryStage = primaryStage;
		
		Parent root = FXMLLoader.load(super.getClass().getResource("/VideoDownloader.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(super.getClass().getResource("/application/application.css").toExternalForm());
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("VideoDownloader");
		primaryStage.setResizable(false);
		primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/res/icon.png")));
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
