enum Priority {TOP,MID,LOW};

public class Ticket{

    int PriorityNum=0;
    Priority priority=Priority.LOW;
    static int ticketID = 0;

    // Est. time
    // Owner (default 0, ?)

    public Ticket() {
        ticketID++;
    }
}
