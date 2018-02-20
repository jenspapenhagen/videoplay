@echo off
IF NOT EXIST C:\home (
	mkdir C:\home
)

IF EXIST test1.mp4 (
	copy test1.mp4 C:\home\test1.mp4
	copy test2.mp4 C:\home\test2.mp4
)
java -cp videoplayer-1.0-SNAPSHOT.jar eu.papenhagen.videoplayer.MainApp

PAUSE