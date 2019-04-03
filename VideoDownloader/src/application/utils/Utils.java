package application.utils;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import application.fileexecutor.Executor;
import application.fileexecutor.UnixExecutor;
import application.fileexecutor.WindowsExecutor;

public class Utils {

	public static final List<Character> blacklistedCharacters = new ArrayList<>();

	static {
		for (int i = 0; i < 160; i++) {
			blacklistedCharacters.add((char) i);
			if (i == 32) i = 126;
		}
	}

	public static boolean isAnUrl(String url) {
		try {
			new URL(url).toURI();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	private static String OS = System.getProperty("os.name").toLowerCase();

	public static OSType getOS() {
		return OSType.getOSType(OS);
	}

	public static enum OSType {
		WINDOWS(new WindowsExecutor(), "bat", "win"),
		UNIX(new UnixExecutor(), "sh", "nix", "nux", "aix", "mac");

		private final String[] refs;
		private final String extensionExecutor;
		private final Executor executor;

		private OSType(Executor executor, String extensionExecutor, String... refs) {
			this.refs = refs;
			this.executor = executor;
			this.extensionExecutor = extensionExecutor;
		}

		public static OSType getOSType(String osRef) {
			for (OSType osType : OSType.values()) {
				for (String osTypeRef : osType.refs) {
					if (osRef.indexOf(osTypeRef) >= 0) return osType;
				}
			}
			return null;
		}

		public void writeFile(
				DataOutputStream dos,
				String url,
				String ytdlexePath,
				String destinationPath,
				boolean isMp3,
				boolean isPlayList)
				throws IOException {
			this.executor.writeLines(dos, url, ytdlexePath, destinationPath, isMp3, isPlayList);
		}

		public String getExtensionExecutor() {
			return extensionExecutor;
		}

	}

}
