public class Test {
    static String source = "C:\\Documents and Settings\\v.kovtun\\��� ���������\\Dropbox\\INSART\\Source";
    static String destination = "C:\\Users\\�����\\Dropbox\\INSART\\Destination";
    static String[] destinations = {"C:\\Documents and Settings\\v.kovtun\\��� ���������\\Dropbox\\INSART\\Destination","C:\\Documents and Settings\\v.kovtun\\��� ���������\\Dropbox\\INSART\\Destination2","C:\\Documents and Settings\\v.kovtun\\��� ���������\\Dropbox\\INSART\\Destination3"};

    public static void main(String[] args) {
        CopyWay copyWay = new CopierIoFis();
        copyWay.threadDispatcher(source, destinations);
    }
}
