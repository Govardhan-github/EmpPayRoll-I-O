package com.bridgelabz;
/*
Importing java packages
 */
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;

public class NIOFileAPITest {
    private static final String HOME = System.getProperty("user.home");
    private static final String PLAY_WITH_NIO = "TempPlayGround";
/*
Test Method Declared Here
To Check File Exists
Delete File And Check File Not Exists
Create Files
 */
    @Test
    public void givenPathWhenCheckedThenConfirm() throws IOException {
        //Check File Exists
        Path homePath = Paths.get(HOME);
        Assertions.assertTrue(Files.exists(homePath));
        //Delete File And Check File Not Exists
        Path playPath = Paths.get(HOME + "/" + PLAY_WITH_NIO);
        if (Files.exists(playPath)) FileUtils.deleteFiles(playPath.toFile());
        Assertions.assertTrue(Files.notExists(playPath));
        //Create Directory
        Files.createDirectory(playPath);
        Assertions.assertTrue(Files.exists(playPath));
        //Create Files
        IntStream.range(1, 10).forEach(cntr -> {
            Path tempFile = Paths.get(playPath + "temp" + cntr);
            Assertions.assertTrue(Files.exists(tempFile));
            try {
                Files.createFile(tempFile);
            } catch (IOException e) {
            }
            Assertions.assertTrue(Files.exists(tempFile));
        });
        //List Files,Directories As Well As With extension
        Files.list(playPath).filter(Files::isRegularFile).forEach(System.out::println);
        Files.newDirectoryStream(playPath).forEach(System.out::println);
        Files.newDirectoryStream(playPath, Path -> Path.toFile().isFile() &&
                                                   Path.toString().startsWith("temp"))
                                                   .forEach(System.out::print);
    }
    /*
    Test Method To Directory To Connect With the WatchServices
     */
    @Test
    public void givenADirectoryWhenWatchedListAllTheActivities() throws IOException {
        Path dir = Paths.get(HOME + "/" + PLAY_WITH_NIO);
        Files.list(dir).filter(Files::isRegularFile).forEach(System.out::println);
        new Java8WatchServiceExample(dir).processEvents();
    }
}