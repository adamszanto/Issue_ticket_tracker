public class Main {
    public static void main(String[] args) {
        Ticket ticket1 = new Ticket();
        System.out.println(ticket1.PriorityNum);
        Ticket t1=new Ticket();

        Ticket t2=new Ticket();

        //System.out.println(t1.ticketID);
        System.out.println(Ticket.ticketID);

    }

}


// User, Manager, Lead. Mindenki tud létrehozni ticketet
// Ticket: ID, Title, leírás, és 'aktív' állapot  amikor elkészül (+ utána becsült idő és hozzárendelés managerhez).
// Ticket: Lehet 3 prioritása, TOP 1, MED 2, LOW 3
// Lehet 3 állapota, 'aktív', 'frissített', 'megoldott'
// User: Legkevesebb jogköre van, csak létrehozni tud ticketet (+ max frissíteni extra infoval a leírást)
// Manager: Tud ticketet magához rendelni, becsült időt megadni a tickethez. Ezeknek a hozzárendelt ticketeknek a státuszt állítani, előzményben látható az aktivitás?
// Manager: Lássa egy helyen az épp még aktív ticketjeit amivel foglalkoznia kell
// Lead: Tud más managerekhez assignolni ticketet, becsült időt megadni.


// Lehet még: Company, Project?
// Company > Project > Ticket típus
// Lead: Tud projekteket létrehozni, módosítani. Tud projekthez assignolni & szerepköröket módosítani (User/Manager/Admin) pl.:
// User1 = Projekt1, Projekt2
// User2 = Projekt2