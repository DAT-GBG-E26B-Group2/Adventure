package week39;
import java.util.Scanner;

public class Adventure {
    private Player player;

    public Adventure() {
        player = new Player();
        player.setCurrentRoom(Map.buildmap());
    }
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String RESET = "\u001B[0m";

    private  void look(){
        System.out.println(GREEN + "You are currently located in " + player.getCurrentRoom().getName() + RESET);
        System.out.println(player.getCurrentRoom().getDescription());
        if(player.getCurrentRoom().getNorth() != null){
            System.out.println("There is an exit towards north");
        }
        if (player.getCurrentRoom().getSouth() != null){
            System.out.println("There is an exit towards south");
        }
        if (player.getCurrentRoom().getEast() != null){
            System.out.println("There is an exit towards east");
        }
        if (player.getCurrentRoom().getWest() != null){
            System.out.println("There is an exit towards west");
        }
        for (Item item : player.getCurrentRoom().getItems()) {
            System.out.println("There is a " + item.getShortName());
        }
    }
    private void getHelp(){
        System.out.println("List over all possible commands (caps will be ignored):");
        System.out.println("1: Go North || North || N -> moves the player north");
        System.out.println("2: Go South || South || S -> moves the player south");
        System.out.println("3: Go West || West || W -> moves the player west");
        System.out.println("4: Go East || East || E -> moves the player east");
        System.out.println("5: Look -> displays a description over the current room");
        System.out.println("6: Help -> more info");
        System.out.println("7: Exit -> closes game");
    }
    private void goNorth(){
        if (player.getCurrentRoom().getNorth() == null){
            System.out.println("You cannot go that way");
        }
        else{
            System.out.println("You enter the room towards north");
            player.setCurrentRoom(player.getCurrentRoom().getNorth());
        }
    }
    private void goSouth(){
        if (player.currentRoom.getSouth() == null){
            System.out.println("You cannot go that way");
        }
        else{
            System.out.println("You enter the room towards south");
            player.setCurrentRoom(player.getCurrentRoom().getSouth());
        }
    }
    private void goEast(){
        if (player.currentRoom.getEast() == null){
            System.out.println("You cannot go that way");
        }
        else{
            System.out.println("You enter the room towards east");
            player.setCurrentRoom(player.getCurrentRoom().getEast());
        }
    }
    private void goWest(){
        if (player.getCurrentRoom().getWest() == null){
            System.out.println("You cannot go that way");
        }
        else{
            System.out.println("You enter the room towards west");
            player.setCurrentRoom(player.getCurrentRoom().getWest());
        }
    }
    public void runGame(Room buildmap){
        Scanner scanner = new Scanner(System.in);
        player.currentRoom = buildmap;

        while(true){
            look();
            System.out.print("Enter a command: ");
            String cmd = scanner.nextLine().strip();
            String[] parts = cmd.split(" ");
            if("exit".equalsIgnoreCase(cmd)){
                break;
            }
            else if("go north" .equalsIgnoreCase(cmd) || "north".equalsIgnoreCase(cmd) || "n".equalsIgnoreCase(cmd)){
                goNorth();
            }
            else if("go south".equalsIgnoreCase(cmd) || "south".equalsIgnoreCase(cmd) || "s".equalsIgnoreCase(cmd)){
                goSouth();
            }
            else if("go east".equalsIgnoreCase(cmd) || "east".equalsIgnoreCase(cmd) || "e".equalsIgnoreCase(cmd)){
                goEast();
            }
            else if("go west".equalsIgnoreCase(cmd) || "west".equalsIgnoreCase(cmd) || "w".equalsIgnoreCase(cmd)) {
                goWest();
            }
            else if ("help".equalsIgnoreCase(cmd)){
                getHelp();
                }
            else if ("look".equalsIgnoreCase(cmd)){
                look();
            }
            else if ("inventory".equalsIgnoreCase(cmd) || "inv".equalsIgnoreCase(cmd) || "i".equalsIgnoreCase(cmd)){
                for (Item item : player.getInventory()) {
                    System.out.println("\u001B[31mInventory:\u001B[0m");
                    System.out.println(item.getShortName());
                }
            }
            else if (parts[0].equalsIgnoreCase("take")) {
                    player.takeItem(parts[1]);
                }
            else if (parts[0].equalsIgnoreCase("drop")) {
                player.dropItem(parts[1]);
            }
            else {
                System.out.println("Unknown command. Try another one");
            }
            // System.out.println("\n".repeat(30));
        }
    }
}
