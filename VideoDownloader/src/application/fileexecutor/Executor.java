package application.fileexecutor;

import java.io.DataOutputStream;
import java.io.IOException;

public abstract class Executor {

	public abstract void writeLines(
			DataOutputStream dos,
			String url,
			String ytdlexePath,
			String destinationPath,
			boolean isMp3,
			boolean isPlayList)
			throws IOException;

	public static void writeFile(DataOutputStream dos, String string, Object... objects)
			throws IOException {
		dos.writeBytes(objects.length != 0 ? String.format(string, objects) : string);
		dos.write(System.getProperty("line.separator").getBytes());
	}

	protected
			String
			construct(String url, String destinationPath, boolean isMp3, boolean isPlayList) {

		StringBuilder builder = new StringBuilder("youtube-dl.exe ");

		if (isPlayList) builder.append("--yes-playlist ");

		builder.append("-o \"" + destinationPath.replace('\\', '/') + "/blabla.%%(ext)s\" ");

		if (isMp3) builder.append("--extract-audio --audio-format mp3 --audio-quality 0 ");
		else builder.append("--recode-video mp4 ");

		builder.append(url);

		return builder.toString();
	}

}
