import java.io.*;

/**
 * Created by v.kovtun on 25.11.15.
 */
public class Copier {

    public static void main(String[] args) {
        String source = "C:\\Users\\Семья\\Dropbox\\INSART\\Source";
//        String destination = "C:\\Users\\Семья\\Dropbox\\INSART\\Destination";
        String[] destinations = {"C:\\Users\\Семья\\Dropbox\\INSART\\Destination","C:\\Users\\Семья\\Dropbox\\INSART\\Destination2","C:\\Users\\Семья\\Dropbox\\INSART\\Destination3"};
        threadDispatcher(source, destinations);
    }
    public static void threadDispatcher(String source, String ... destinations){
        for(String destination: destinations){
            new WorkerThread(new File(source), new File(destination));
        }
    }

    public static void copyFile(File source, File destinationPath){
        System.out.println(Thread.currentThread().getName());
        if(source.isFile()) {
            System.out.println("source is a file!!");
            File newCopy = new File(destinationPath.getAbsolutePath() + "\\" + source.getName());
            FileReader fileReader = null;
            FileWriter fileWriter = null;
            try {
                fileWriter = new FileWriter(newCopy);
            } catch (IOException e) {
                System.out.println("Can't create destination File!");
                e.printStackTrace();
            }
            try {
                fileReader = new FileReader(source);
            } catch (FileNotFoundException e) {
                System.out.println("There is no such File: " + source.getName());
                e.printStackTrace();
            }
            String line;
            BufferedReader br = new BufferedReader(fileReader);
            try {
                while ((line = br.readLine()) != null) {
                    fileWriter.write(line + "\n");
                }
                fileWriter.flush();
            } catch (IOException e) {
                System.out.println("Error while writing file : " + source.getName());
                e.printStackTrace();
            }
        }else{
            File subDestinationPath = new File(destinationPath.getAbsolutePath() + "\\" +source.getName());
            subDestinationPath.mkdir();
            File[] fileList = source.listFiles();
            for(File file: fileList)
                copyFile(new File(source.getAbsolutePath() + "\\" + file.getName()), subDestinationPath);
        }

    }

}
