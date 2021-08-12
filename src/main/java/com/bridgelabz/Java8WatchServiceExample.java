package com.bridgelabz;
/*
Importing Java Packages
 */
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;
import static java.nio.file.StandardWatchEventKinds.*;
/*
Declaring The WatchService Example Class
 */
public class Java8WatchServiceExample {
    private final WatchService watcher;
    private final Map<WatchKey, Path> dirWatchers;
    /*
    Create Watch Services And Register The Given Directory
     */
    public Java8WatchServiceExample(Path dir) throws IOException {
        this.watcher = FileSystems.getDefault().newWatchService();
        this.dirWatchers = new HashMap<WatchKey,Path>();
        ScanAndRegisterDirectories(dir);
    }
    /*
    Registers The Given Directory With the Watch Services
     */
    private void registerDirwatches(Path dir) throws IOException {
        WatchKey key =dir.register(watcher,ENTRY_CREATE,ENTRY_DELETE,ENTRY_MODIFY);
        dirWatchers.put(key,dir);
    }
    /*
    Register The Given Directories,All Sub Directories To The WatchServices
     */
    private void ScanAndRegisterDirectories(final Path Start) throws IOException {
        Files.walkFileTree(Start ,new SimpleFileVisitor<Path>(){
            @Override
            public FileVisitResult preVisitDirectory(Path dir , BasicFileAttributes attrs) throws IOException {
                registerDirwatches(dir);
                return FileVisitResult.CONTINUE;
            }
        });
    }
    /*
    Process All Events For Keys Queued To the Watchers
     */
    @SuppressWarnings({"rawtypes","unchecked"})
    void processEvents(){
        while(true){
            WatchKey key;
            try{
                key = watcher.take();
            } catch (InterruptedException x) {
                return;
            }
            Path dir = dirWatchers.get(key);
            if(dir == null) continue;
            for(WatchEvent<?> event : key.pollEvents()) {
                WatchEvent.Kind kind = event.kind();
                Path name = ((WatchEvent<Path>) event).context();
                Path child = dir.resolve(name);
                System.out.format("%s : %s\n", event.kind().name(), child);
                //If Directory Is Created Then Register It And Its Sub Directories
                if (kind ==ENTRY_CREATE) {
                    try {
                        if (Files.isDirectory(child)) ScanAndRegisterDirectories(child);
                    } catch (IOException e) {
                    }
                }else if (kind.equals(ENTRY_DELETE)) {
                    if (Files.isDirectory(child)) dirWatchers.remove(key);
                }
            }
            /*
            Remove key If Directories Not Available
             */
            boolean valid = key.reset();
            if (!valid) {
                dirWatchers.remove(key);
                if (dirWatchers.isEmpty()) break;
            }

        }
    }
}
