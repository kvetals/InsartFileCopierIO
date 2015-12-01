import java.io.IOException;
import java.nio.file.*;


public class CopierNio implements CopyWay {
    @Override
    public void threadDispatcher(String source, String... destinationPaths) {
        for(String destination: destinationPaths){
            new WorkerThread(source, destination, this);
        }

    }

    @Override
    public void copyFile(String source, String destination) {
        Path sourcePath = Paths.get(source);
        Path destinationPath = Paths.get(destination, sourcePath.getFileName().toString());
        System.out.println(Thread.currentThread().getName());
        try {
            Files.copy(sourcePath,destinationPath,StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(Files.isDirectory(sourcePath)){
            System.out.println("sourceFile is a Directory!!");
            Path subPath = Paths.get(destination, sourcePath.getFileName().toString());
            try{
                DirectoryStream<Path> stream = Files.newDirectoryStream(sourcePath);
                for (Path entry : stream){
                    copyFile(entry.toString(), subPath.toString());
                }
                stream.close();
            }
            catch (IOException e){
                System.out.println("Some problems while copying!!");
                e.printStackTrace();
            }
        }
    }
}
