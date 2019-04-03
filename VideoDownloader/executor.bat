@echo off
echo [website-url]: https://oload.fun/stream/MXG8EF3Qnac~1542014553~83.113.0.0~VpMJ6Hvi?mime=true
echo [youtubedl folder path]: C:\Users\adamc\Desktop\VideoDownloader\youtube-dl.exe
echo [Format dl]: mp3
echo [destination folder]: C:\Users\adamc\Desktop
echo [is playlist]: false
cd /D C:\Users\adamc\Desktop\VideoDownloader\
youtube-dl.exe -o "C:/Users/adamc/Desktop/blabla.%%(ext)s" --extract-audio --audio-format mp3 --audio-quality 0 https://oload.fun/stream/MXG8EF3Qnac~1542014553~83.113.0.0~VpMJ6Hvi?mime=true
pause
