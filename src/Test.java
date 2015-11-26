public class Test {
    static String source = "C:\\Documents and Settings\\v.kovtun\\Мои документы\\Dropbox\\INSART\\Source";
    static String destination = "C:\\Users\\Семья\\Dropbox\\INSART\\Destination";
    static String[] destinations = {"C:\\Documents and Settings\\v.kovtun\\Мои документы\\Dropbox\\INSART\\Destination","C:\\Documents and Settings\\v.kovtun\\Мои документы\\Dropbox\\INSART\\Destination2","C:\\Documents and Settings\\v.kovtun\\Мои документы\\Dropbox\\INSART\\Destination3"};

    public static void main(String[] args) {
        CopyWay copyWay = new CopierIoFis();
        copyWay.threadDispatcher(source, destinations);
    }
}
