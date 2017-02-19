package badidea;

import java.util.Scanner;

public class Client {
    final String promptMessage = "What would you like to do?\n(Type 'help' for a list of commands)";
    final String stockMessage = "Current stock: %s\nFull name: %s\nCurrent price: %f";
    final String errorMessage = "Unrecognized command";
    User user;
    boolean quit;
    // Stock currentStock;
    
    public Client() {    
    }
    
    public void run() {
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
            case "info":
                printCurrentStock();
                break;
            case "help":
                printHelp();
                break;
            default:
                String[] arguments = string.split(" ");
                if(arguments.length == 2) {
                    handleTwoArguments(arguments[0], arguments[1]);
                }
                else {
                    System.out.println(errorMessage);
                }
                break;
        }
    }
    
    private void handleTwoArguments(String arg1, String arg2) {
        switch(arg1) {
            case "get":
                getInfo(arg2);
                break;
            case "buy":
                buy(Integer.parseInt(arg2));
                break;
            case "sell":
                sell(Integer.parseInt(arg2));
                break;
            default:
                System.out.println(errorMessage);
                break;
                
        }
    }
    
    private void getInfo(String requestString) {
        // make a request and store the result in Stock currentStock
        System.out.println("GETINFO: " + requestString);
        printCurrentStock();
    }
    
    private void buy(int quantity) {
        System.out.println("BUY: " + quantity);
    }
    
    private void sell(int quantity) {
        System.out.println("SELL: " + quantity);
    }
    
    private void printCurrentStock() {
        System.out.println("INFO");
        // System.out.println(stockMessage)
    }
    
    private void printHelp() {
        System.out.println("exit    - quit the program");
        System.out.println("info    - print info about the currently selected stock");
        System.out.println("get x   - retrieve info about a stock using x to identify the stock");
        System.out.println("buy x   - buy x of the current stock if possible");
        System.out.println("sell x  - sell x of the current stock if possible");
        System.out.println("help    - print this menu");
        System.out.println("");
    }
    
//    private boolean haveStock() {
//        if(currentStock == null) {
//            System.out.println("No stock is currently selected");
//            return false;
//        }
//        else {
//            return true;
//        }
//    }
}
