package badidea;

import java.util.Scanner;

public class Client {
    final String promptMessage = "What stock would you like to view?";
    User user;
    boolean quit;
    Stock currentStock;
    
    public Client() {    
    }
    
    public void run() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your name: ");
        user = new User(scanner.nextLine());
        
        quit = false;
        while(!quit) {
            System.out.println(promptMessage);
            handle(scanner.nextLine());
        }
    }
    
    private void handle(String string) {
        switch(string) {
            case "exit":
                quit = true;
                break;
            default:
                getInfo(string);
                break;
        }
    }
    
    private void getInfo() {
        
    }
}
