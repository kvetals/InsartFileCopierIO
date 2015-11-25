import java.io.File;

/**
 * Created by v.kovtun on 25.11.15.
 */
public class WorkerThread implements Runnable {
    File source;
    File destination;
    Thread t;
    WorkerThread(File source, File destination){
        this.source = source;
        this.destination = destination;
        t = new Thread(this);
        t.start();
    }
    @Override
    public void run() {
        System.out.println(t.getName());
        Copier.copyFile(source, destination);
    }
}
