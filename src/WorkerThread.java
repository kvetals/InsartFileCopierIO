public class WorkerThread implements Runnable {
    String source;
    String destination;
    Thread t;
    WorkerThread(String source, String destination){
        this.source = source;
        this.destination = destination;
        t = new Thread(this);
        t.start();
    }
    @Override
    public void run() {
        CopyWay copyWay = new CopierIoFis();
        System.out.println(t.getName());
        copyWay.copyFile(source, destination);
    }
}
