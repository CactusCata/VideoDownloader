package application.fileexecutor;

import java.io.DataOutputStream;
import java.io.IOException;

public class UnixExecutor extends Executor {

	@Override
	public void writeLines(
			DataOutputStream dos,
			String url,
			String ytdlexePath,
			String destinationPath,
			boolean isMp3,
			boolean isPlayList)
			throws IOException {
		
		writeFile(dos, "@echo off");
		writeFile(dos, "echo [website-url]: %s", url);
		writeFile(dos, "echo [youtubedl folder path]: %s", ytdlexePath);
		writeFile(dos, "echo [Format dl]: %s", isMp3 ? "mp3" : "mp4");
		writeFile(dos, "echo [destination folder]: %s", destinationPath);
		writeFile(dos, "echo [is playlist]: %b", isPlayList);
		writeFile(dos, "cd /D %s", ytdlexePath.replaceAll("youtube-dl.exe", ""));
		writeFile(dos, "set path \"%path%;C:\\Program Files (x86)\\ffmpeg\\\"");
		writeFile(dos, super.construct(url, destinationPath, isMp3, isPlayList));
		writeFile(dos, "pause");
		dos.close();
		
	}

}
