import java.io.*;

public class CopierIoFis implements CopyWay {
    @Override
    public void threadDispatcher(String source, String ... destinations){
        for(String destination: destinations){
            new WorkerThread(source, destination);
        }
    }
    @Override
    public void copyFile(String source, String destinationPath){

        File sourceFile = new File(source);
        File destinationPathFile = new File(destinationPath);
        System.out.println(Thread.currentThread().getName());
        System.out.println("sourceFile = " + sourceFile.getAbsolutePath());
        System.out.println("destination = " + destinationPathFile.getAbsolutePath());
        if(sourceFile.isFile()) {
            System.out.println("sourceFile is a file!!");
            File newCopy = new File(destinationPathFile.getAbsolutePath() + "\\" + sourceFile.getName());
            FileInputStream fis = null;
            FileOutputStream fos = null;
            try {
                fos = new FileOutputStream(newCopy);
            } catch (IOException e) {
                System.out.println("Can't create destination File!");
                e.printStackTrace();
            }
            try {
                fis = new FileInputStream(sourceFile);
            } catch (FileNotFoundException e) {
                System.out.println("There is no such File: " + sourceFile.getName());
                e.printStackTrace();
            }
            byte[] b = new byte[4096];
            int length;
            try {
                while ((length = fis.read(b)) > 0){
                    fos.write(b, 0, length);
                }
            } catch (IOException e) {
                System.out.println("Error while writing file : " + sourceFile.getName());
                e.printStackTrace();
            }finally {
                try {
                    fos.close();
                    fis.close();
                } catch (IOException e) {
                    System.out.println("Error while closing streams!");
                    e.printStackTrace();
                }

            }
        }else{
            System.out.println("sourceFile is not a file!!");
            File subDestinationPath = new File(destinationPathFile.getAbsolutePath() + "\\" +sourceFile.getName());
            subDestinationPath.mkdir();
            File[] fileList = sourceFile.listFiles();
            for(File file: fileList)
                copyFile(sourceFile.getAbsolutePath() + "\\" + file.getName(), subDestinationPath.getAbsolutePath());
        }

    }
}
