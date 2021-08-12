package com.bridgelabz;
import java.io.File;
public class FileUtils {
/*
Declaring dDelete Files Method Here
To Delete The Files
 */
public static boolean deleteFiles(File contentsToDelete){
    File[] allContents = contentsToDelete.listFiles();
    if(allContents!=null){
        for(File file : allContents){
            deleteFiles(file);
        }
    }
    return contentsToDelete.delete();
    }
}
