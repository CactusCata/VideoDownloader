package application.controller;

import java.io.File;
import java.io.IOException;

import application.fileexecutor.FileExecutorManager;
import application.log.ErrorMessageFX;
import application.utils.Utils;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class VideoDownloaderController {

	@FXML
	private Label correctUrlChar, correctYTDLExeChar, correctDestinationFolderChar;
	@FXML
	private TextField urlField, youtubedlexeField, destinationFolderField;
	@FXML
	private RadioButton mp3, mp4;
	@FXML
	private CheckBox playlist;

	public static final String CORRECT = "correctTextField";
	public static final String ERROR = "errorTextField";

	@FXML
	public void writeUrl(KeyEvent event) {
		TextField urlField = (TextField) event.getSource();
		setTextFieldState(urlField, Utils.isAnUrl(getCorrectText(event)));
	}

	@FXML
	public void writeYTDLExe(KeyEvent event) {
		TextField youtubedlexeField = (TextField) event.getSource();
		setTextFieldState(
				youtubedlexeField,
				new File(getCorrectText(event)).exists() && getCorrectText(event).endsWith(".exe"));
	}

	@FXML
	public void chooseFile(ActionEvent event) {
		FileChooser fileSelected = new FileChooser();
		fileSelected.setTitle("Open Youtube-dl file");
		fileSelected.setInitialDirectory(new File(System.getProperty("user.dir")));
		fileSelected.getExtensionFilters().add(new FileChooser.ExtensionFilter("Youtube-dl executable", "*.exe"));
		File ytdlExeFile = fileSelected.showOpenDialog(new Stage());
		if (ytdlExeFile != null) {
			this.youtubedlexeField.setText(ytdlExeFile.getPath());
			setTextFieldState(this.youtubedlexeField, true);
		}
	}

	@FXML
	public void chooseFolder(ActionEvent event) {
		DirectoryChooser directorySelected = new DirectoryChooser();
		directorySelected.setTitle("Open destination folder");
		directorySelected.setInitialDirectory(new File(System.getProperty("user.home")));
		File directoryFile = directorySelected.showDialog(new Stage());
		if (directoryFile != null) {
			this.destinationFolderField.setText(directoryFile.getPath());
			this.setTextFieldState(this.destinationFolderField, true);
		}
	}

	@FXML
	public void writeDestinationFolder(KeyEvent event) {
		TextField destinationFolderField = (TextField) event.getSource();
		setTextFieldState(destinationFolderField, new File(getCorrectText(event)).exists());
	}

	@FXML
	public void download(ActionEvent event) throws IOException {
		if (!allTextFieldCorrects()) return;
		File batFile = FileExecutorManager.createFile(
				this.urlField.getText(),
				this.youtubedlexeField.getText(),
				this.destinationFolderField.getText(),
				this.mp3.isSelected(),
				this.playlist.isSelected());
		Runtime.getRuntime().exec(String.format("cmd /c start %s", batFile.getPath()));

	}

	private String getCorrectText(KeyEvent event) {
		TextField field = (TextField) event.getSource();
		return field.getText() + (Utils.blacklistedCharacters
				.contains(event.getCharacter().charAt(0)) ? "" : event.getCharacter());
	}

	private void setTextFieldState(TextField source, boolean isCorrect) {
		if (isCorrect) {
			source.getStyleClass().add(VideoDownloaderController.CORRECT);
			source.getStyleClass().removeIf(style -> style.equals(VideoDownloaderController.ERROR));
		} else {
			source.getStyleClass().add(VideoDownloaderController.ERROR);
			source.getStyleClass().removeIf(style -> style.equals(VideoDownloaderController.CORRECT));
		}
	}

	private boolean allTextFieldCorrects() {
		StringBuilder builder = new StringBuilder("Logs Error:\n\n");
		boolean correct = true;

		if (!urlField.getStyleClass().contains(VideoDownloaderController.CORRECT)) {
			correct = false;
			builder.append("The url isn't correct !\n");
		}

		if (!youtubedlexeField.getStyleClass().contains(VideoDownloaderController.CORRECT)) {
			correct = false;
			builder.append("The youtube-dl.exe path isn't correct !\n");
		}

		if (!destinationFolderField.getStyleClass().contains(VideoDownloaderController.CORRECT)) {
			correct = false;
			builder.append("The destination folder is incorrect !");
		}

		if (!correct) Platform.runLater(() -> ErrorMessageFX.create(builder.toString()));

		return correct;
	}

}
