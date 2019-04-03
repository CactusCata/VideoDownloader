package application.log;

import application.VideoDownloaderFX;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ErrorMessageFX {

	public static void create(String message) {

		Label messageInfo = new Label(message);

		StackPane secondaryLayout = new StackPane();
		Scene secondScene = new Scene(secondaryLayout, 230, 100);
		secondaryLayout.getChildren().add(messageInfo);

		Stage newWindow = new Stage();
		newWindow.setTitle("VideoDownloader - Information");
		newWindow.setScene(secondScene);
		newWindow.initModality(Modality.WINDOW_MODAL);
		newWindow.initOwner(VideoDownloaderFX.primaryStage);
		newWindow.setResizable(false);
		newWindow.getIcons().add(
				new Image(ErrorMessageFX.class.getResourceAsStream("/res/warning.png")));
		newWindow.show();

	}

}
