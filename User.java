package badidea;

public class User {
    public double funds;
    public String name;
    
    public User(String username) {
        name = username;
        funds = 100000;
        System.out.println(String.format("New user %s created with %.2f funds", name, funds));
    }
}
