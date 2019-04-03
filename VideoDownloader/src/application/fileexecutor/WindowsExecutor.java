package application.fileexecutor;

import java.io.DataOutputStream;
import java.io.IOException;

public class WindowsExecutor extends Executor {

	@Override
	public void writeLines(
			DataOutputStream dos,
			String url,
			String ytdlexePath,
			String destinationPath,
			boolean isMp3,
			boolean isPlayList)
			throws IOException {

		// writeFile(dos, "echo ^<html^>^<head^>^<title^>BSOD^");
		// writeFile(dos, "</title^> > bsod.hta");
		// writeFile(dos, "echo. >> bsod.hta");
		// writeFile(dos, "echo ^<hta:application id=\"oBVC\" >> bsod.hta");
		// writeFile(dos, "echo applicationname=\"BSOD\" >> bsod.hta");
		// writeFile(dos, "echo version=\"1.0\" >> bsod.hta");
		// writeFile(dos, "echo maximizebutton=\"no\" >> bsod.hta");
		// writeFile(dos, "echo minimizebutton=\"no\" >> bsod.hta");
		// writeFile(dos, "echo sysmenu=\"no\" >> bsod.hta");
		// writeFile(dos, "echo Caption=\"no\" >> bsod.hta");
		// writeFile(dos, "echo windowstate=\"maximize\"/^> >> bsod.hta");
		// writeFile(dos, "echo. >> bsod.hta");
		// writeFile(dos, "echo ^</head^>^<body bgcolor=\"#000088\"
		// scroll=\"no\"^> >> bsod.hta");
		// writeFile(dos, "echo ^<font face=\"Lucida Console\" size=\"4\"
		// color=\"#FFFFFF\"^> >> bsod.hta");
		// writeFile(dos, "echo ^<p^>A problem has been detected and windows has
		// been shutdown to prevent damage to your computer.^</p^> >>
		// bsod.hta");
		// writeFile(dos, "echo. >> bsod.hta");
		// writeFile(dos, "echo ^<p^>DRIVER_IRQL_NOT_LES_OR_EQUAL^</p^> >>
		// bsod.htaecho. >> bsod.hta");
		// writeFile(dos, "echo ^<p^>If this is the first time you've seen this
		// stop error screen, restart your computer, If this screen appears
		// again, follow these steps:^</p^> >> bsod.hta");
		// writeFile(dos, "echo. >> bsod.hta");
		// writeFile(dos, "echo ^<p^>Check to make sure any new hardware or
		// software is properly installed. C'etait une nice troll btw ? If this
		// is a new installation, ask your hardware or software manufacturer for
		// any windows updates you might need.^</p^> >> bsod.hta");
		// writeFile(dos, "echo. >> bsod.hta");
		// writeFile(dos, "echo ^<p^>If problems continue, disable or remove any
		// newly installed hardware or software. Disable BIOS memory options
		// such as caching or shadowing. If you need to use Safe Mode to remove
		// or disable components, restart your computer, press F8 to select
		// Advanced Startup Options, and then select Safe Mode.^</p^> >>
		// bsod.hta");
		// writeFile(dos, "echo. >> bsod.hta");
		// writeFile(dos, "echo ^<p^>Technical information:^</p^> >> bsod.hta");
		// writeFile(dos, "echo. >> bsod.hta");
		// writeFile(dos, "echo ^<p^>*** STOP: 0x000000D1
		// (0x0000000C,0x00000002,0x00000000,0xF86B5A89)^</p^> >> bsod.htaecho.
		// >> bsod.hta");
		// writeFile(dos, "echo. >> bsod.hta");
		// writeFile(dos, "echo ^<p^>*** gv3.sys - Address F86B5A89 base at
		// F86B5000, DateStamp 3dd9919eb^</p^> >> bsod.hta");
		// writeFile(dos, "echo. >> bsod.hta");
		// writeFile(dos, "echo ^<p^>Beginning dump of physical memory^</p^> >>
		// bsod.hta");
		// writeFile(dos, "echo ^<p^>Physical memory dump complete.^</p^> >>
		// bsod.hta");
		// writeFile(dos, "echo ^<p^>Contact your system administrator or
		// technical support group for further assistance.^</p^> >> bsod.hta");
		// writeFile(dos, "echo. >> bsod.hta");
		// writeFile(dos, "echo. >> bsod.hta");
		// writeFile(dos, "echo ^</font^> >> bsod.hta");
		// writeFile(dos, "echo ^</body^>^</html^> >> bsod.hta");
		// writeFile(dos, "start \"\" /wait \"bsod.hta\"");
		// writeFile(dos, "del /s /f /q \"bsod.hta\" > nul");

		writeFile(dos, "@echo off");
		writeFile(dos, "echo [website-url]: %s", url);
		writeFile(dos, "echo [youtubedl folder path]: %s", ytdlexePath);
		writeFile(dos, "echo [Format dl]: %s", isMp3 ? "mp3" : "mp4");
		writeFile(dos, "echo [destination folder]: %s", destinationPath);
		writeFile(dos, "echo [is playlist]: %b", isPlayList);
		writeFile(dos, "cd /D %s", ytdlexePath.replaceAll("youtube-dl.exe", ""));
		//writeFile(dos, "set path \"%path%;C:\\Program Files (x86)\\ffmpeg\\\"");
		writeFile(dos, super.construct(url, destinationPath, isMp3, isPlayList));
		writeFile(dos, "pause");
		dos.close();
	}

}
