package application.fileexecutor;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import application.utils.Utils;
import application.utils.Utils.OSType;

public class FileExecutorManager {

	public static File createFile(
			String url,
			String ytdlexePath,
			String destinationPath,
			boolean isMp3,
			boolean isPlayList)
			throws IOException {

		OSType osType = Utils.getOS();
		File file = new File(
				System.getProperty("user.dir").replace("\\", "/"),
				"executor." + osType.getExtensionExecutor());
		System.out.println(file.getPath());
		if (file.exists()) file.delete();
		file.createNewFile();
		FileOutputStream fos = new FileOutputStream(file);
		DataOutputStream dos = new DataOutputStream(fos);
		osType.writeFile(dos, url, ytdlexePath, destinationPath, isMp3, isPlayList);
		return file;

	}

	// if (isWindows()) {
	// System.out.println("This is Windows");
	// } else if (isMac()) {
	// System.out.println("This is Mac");
	// } else if (isUnix()) {
	// System.out.println("This is Unix or Linux");
	// } else if (isSolaris()) {
	// System.out.println("This is Solaris");
	// } else {
	// System.out.println("Your OS is not support!!");
	// }

}
