public class Visitor {

    private int wallet = 1000;
    private String name;
    private int age;
    private String gender;
    private String category;
    private int height;
    private int weight;
    private Ticket ticket;

    public Visitor( String name, int age, String gender, String category, Ticket ticket) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.category = category;
        this.ticket = ticket;
        System.out.println("--------------------------------------------------------");
        System.out.println("Collect Your " + this.ticket.toString());
        System.out.println("--------------------------------------------------------");
        System.out.println();
    }
}
