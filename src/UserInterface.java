import java.util.Scanner;

public class UserInterface {

    static void runGame() {
        Scanner scanner = new Scanner(System.in);

        //Show the intro and starting room
        printIntro();
        printCurrentRoom();

        //Main game loop
        while(true) {
            System.out.print("\nCommand -> ");
            String cmd = scanner.nextLine().strip();

            //Check which command player entered
            if ("exit".equalsIgnoreCase(cmd)) break;

            else if ("help".equalsIgnoreCase(cmd)) printHelp();
            else if ("look".equalsIgnoreCase(cmd)) printCurrentRoom();

            else if ("go north".equalsIgnoreCase(cmd) ||
                    "north".equalsIgnoreCase(cmd) ||
                    "n".equalsIgnoreCase(cmd)) {
                move(Adventure.goNorth());
            }
            else if ("go east".equalsIgnoreCase(cmd) ||
                    "east".equalsIgnoreCase(cmd) ||
                    "e".equalsIgnoreCase(cmd)) {
                move(Adventure.goEast());
            }
            else if ("go south".equalsIgnoreCase(cmd) ||
                    "south".equalsIgnoreCase(cmd) ||
                    "s".equalsIgnoreCase(cmd)) {
                move(Adventure.goSouth());
            }
            else if ("go west".equalsIgnoreCase(cmd) ||
                    "west".equalsIgnoreCase(cmd) ||
                    "w".equalsIgnoreCase(cmd)) {
                move(Adventure.goWest());
            }

            //unknown command entered
            else System.out.println("Unknown command. Type 'help' to see available commands.");
        }

        System.out.println("Goodbye!");
    }

    //Print the intro when game starts
    private static void printIntro() {
        System.out.println("=================================");
        System.out.println("       ECHOES OF KEPLER-9");
        System.out.println("=================================");
        System.out.println();
        System.out.println("Your spacecraft has crashed on Kepler-9.");
        System.out.println("The rest of your crew is missing, and your");
        System.out.println("communication system is offline.");
        System.out.println();
        System.out.println("Your mission:");
        System.out.println("Explore the planet and find a way to survive.");
        System.out.println();
        printHelp();
        System.out.println("=================================");
    }

    //Print all available commands
    private static void printHelp() {
        System.out.println("Commands:");
        System.out.println("  go north  - Move north");
        System.out.println("  go east   - Move east");
        System.out.println("  go south  - Move south");
        System.out.println("  go west   - Move west");
        System.out.println("  look      - Look around");
        System.out.println("  help      - Show commands");
        System.out.println("  exit      - Quit the game");
    }

    //Print name and description of current room
    private static void printCurrentRoom() {
        Room currentRoom = Adventure.getCurrentRoom();

        System.out.println();
        System.out.println(currentRoom.getName());
        System.out.println(currentRoom.getDescription());
    }

    //Check if move was success and then move player to new room + show new room info. Else show error message
    private static void move(boolean canMove) {
        if (canMove) {
            printCurrentRoom();
        } else {
            System.out.println("You cannot go that way");
        }
    }

}
