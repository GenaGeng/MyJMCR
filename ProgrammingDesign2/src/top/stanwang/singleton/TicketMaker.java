package top.stanwang.singleton;

public class TicketMaker {
    private TicketMaker() {

    }

    private static TicketMaker instance;

    private static int ticket = 1000;

    public int getNextTicketNumber() {
        return ticket++;
    }

    public synchronized static TicketMaker getInstance() {
        if (instance == null) {
            instance = new TicketMaker();
        }
        return instance;
    }
}
