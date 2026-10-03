import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    static void runGame() {
        Scanner scanner = new Scanner(System.in);

        //Create game controller
        Adventure adventure = new Adventure();

        //Show the intro and starting room
        printIntro();
        printCurrentRoom(adventure);

        //Main game loop
        while(true) {
            System.out.print("\nCommand -> ");
            String cmd = scanner.nextLine().strip().toLowerCase();

            //Check which command player entered
            if ("exit".equalsIgnoreCase(cmd)) break;

            else if ("help".equalsIgnoreCase(cmd)) printHelp();
            else if ("look".equalsIgnoreCase(cmd)) printCurrentRoom(adventure);

            else if ("go north".equalsIgnoreCase(cmd) ||
                    "north".equalsIgnoreCase(cmd) ||
                    "n".equalsIgnoreCase(cmd)) {
                move(adventure, "north");
            }
            else if ("go east".equalsIgnoreCase(cmd) ||
                    "east".equalsIgnoreCase(cmd) ||
                    "e".equalsIgnoreCase(cmd)) {
                move(adventure, "east");
            }
            else if ("go south".equalsIgnoreCase(cmd) ||
                    "south".equalsIgnoreCase(cmd) ||
                    "s".equalsIgnoreCase(cmd)) {
                move(adventure, "south");
            }
            else if ("go west".equalsIgnoreCase(cmd) ||
                    "west".equalsIgnoreCase(cmd) ||
                    "w".equalsIgnoreCase(cmd)) {
                move(adventure, "west");
            }
            //Check if command starts with "take"
            else if (cmd.startsWith("take ")) {
                //take everything after "take "
                String itemName = cmd.substring(5);
                Item item = adventure.takeItem(itemName);

                if(item != null) System.out.println("You have taken " +item.getShortName());
                else System.out.println("There is nothing like "+itemName+" to take around here");
            }
            //Check if command starts with "drop"
            else if (cmd.startsWith("drop")) {
                //take everything after "drop "
                String itemName = cmd.substring(5);
                Item item = adventure.dropItem(itemName);

                if(item != null) System.out.println("You have dropped "+item.getShortName());
                else System.out.println("You don´t have anything like " +itemName+" in your inventory" );
            }
            else if ("inventory".equalsIgnoreCase(cmd) || "inv".equalsIgnoreCase(cmd)) {
                ArrayList<Item> inventory = adventure.getInventory();

                if(inventory.isEmpty()) System.out.println("Your inventory is empty.");
                else {
                    //Show players equipped weapon
                    Weapon equippedWeapon = adventure.getEquippedWeapon();

                    if (equippedWeapon != null) System.out.println("Equipped: " +equippedWeapon.getShortName());

                    System.out.println("You are carrying:");

                    for (Item item : inventory) {
                        System.out.println(item.getShortName() +" - "+item.getLongName());
                    }
                }
            }
            else if ("health".equalsIgnoreCase(cmd)) {
                printHealth(adventure);
            }
            //Check if command starts with "eat"
            else if (cmd.startsWith("eat ")) {
                //take everything after "eat " <_- that will be item
                String itemName = cmd.substring(4);

                int healthBefore = adventure.getHealth();

                EatResult result = adventure.eat(itemName);

                int healthAfter = adventure.getHealth();

                switch (result) {
                    case NOT_FOUND -> System.out.println("There is nothing like "+itemName+" to eat around here");
                    case NOT_FOOD -> System.out.println("You cannot eat "+itemName);
                    case EATEN -> {
                        if (healthAfter > healthBefore) System.out.println("You eat "+itemName+". You feel a little better.");
                        else System.out.println("You eat "+itemName+". That was a mistake.");

                        printHealth(adventure);
                    }
                }
            }
            //Check if command starts with "equip"
            else if (cmd.startsWith("equip ")) {
                //take everything afer "equip " <- that will be weapon name
                String itemName = cmd.substring(6);

                EquipResult result = adventure.equip(itemName);

                switch (result) {
                    case NOT_FOUND -> System.out.println("You dont have a weapon like " +itemName);
                    case NOT_WEAPON -> System.out.println(itemName + " is not a weapon");
                    case EQUIPPED -> System.out.println("You have equipped "+itemName);
                }
            }
            else if ("attack".equalsIgnoreCase(cmd)) {

                AttackResult result = adventure.attack();

                Weapon weapon = adventure.getEquippedWeapon();

                switch (result) {
                    case NO_WEAPON -> System.out.println("You dont have a weapon equipped");
                    case NO_USES_LEFT -> System.out.println(weapon.getShortName() + " has no uses left");
                    case ATTACKED -> System.out.println("You "+weapon.getAttack()+" "+weapon.getShortName()+" at the empty air. "+weapon.getUsesLeft());
                }
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
        System.out.println("  go north          - Move north");
        System.out.println("  go east           - Move east");
        System.out.println("  go south          - Move south");
        System.out.println("  go west           - Move west");
        System.out.println("  inventory         - Show your inventory");
        System.out.println("  take <item>       - Add item to your inventory");
        System.out.println("  drop <item>       - Remove item from your inventory");
        System.out.println("  health            - Show your current health");
        System.out.println("  eat <food>        - Eat food to replenish your health");
        System.out.println("  equip <weapon>    - Equip weapon from your inventory");
        System.out.println("  attack            - Attack enemy with equipped weapon");
        System.out.println("  look              - Look around");
        System.out.println("  help              - Show commands");
        System.out.println("  exit              - Quit the game");
    }

    //Print name and description of current room
    private static void printCurrentRoom(Adventure adventure) {
        Room currentRoom = adventure.getCurrentRoom();

        System.out.println();
        System.out.println(currentRoom.getName());
        System.out.println(currentRoom.getDescription());

        //Check if current rooms has any items
        if(!currentRoom.getItems().isEmpty()) {
            System.out.println("Here you can see: ");

            //If there are items in current room then display them
            for(Item item : currentRoom.getItems()) System.out.println(item.getShortName() +" - "+item.getLongName());

        }
    }

    //Prints players health together with a description
    private static void printHealth(Adventure adventure) {
        int health = adventure.getHealth();

        System.out.print("Health: " +health+ " - ");

        if (health >= 100) System.out.println("you are in perfect health");
        else if (health >= 50) System.out.println("you are in good health, but avoid fighting right now");
        else if (health >= 25) System.out.println("you are wounded - find something healthy to eat");
        else if (health >= 1) System.out.println("you are barely alive");
        else System.out.println("you should be dead");
    }


    //Check if move was success and then move player to new room + show new room info. Else show error message
    private static void move(Adventure adventure, String direction) {
        if (adventure.move(direction)) {
            printCurrentRoom(adventure);
        } else {
            System.out.println("You cannot go that way");
        }
    }

}
