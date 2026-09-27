import java.util.ArrayList;

public class Player {
    //Keep track of the room player is in
    private static Room currentRoom;

    //Place player in starting room
    public Player(Room startingRoom) {
        currentRoom = startingRoom;
    }

    //Returns current room player is in
    public static Room getCurrentRoom() {
        return currentRoom;
    }

    //Store all items currently carried by player
    private ArrayList<Item> inventory = new ArrayList<>();

    //Try taking item from the room player currently is in
    public Item takeItem(String shortName) {
        //Search current room for the item
        Item item = currentRoom.findItem(shortName);

        //If item found then it exists in current room
        if(item != null) {
            //Remove item from current room
            currentRoom.removeItem(item);
            //Add same item object to players inventory
            inventory.add(item);
        }

        //If nothing found return null
        return item;
    }

    //Try dropping item from players inventory
    public Item dropItem(String shortName) {
        //Search player inventory
        Item item = findItem(shortName);

        //Drop item if it is found in inventory
        if(item != null) {
            //Remove item from players inventory
            inventory.remove(item);
            //Add same item to the current room
            currentRoom.addItem(item);
        }

        //Return item or null
        return item;
    }

    //Search player inventory for and item with given name
    public Item findItem(String shortName) {
        //If item is in players inventory then return item object
        for(Item item : inventory) {
            if(item.getShortName().equalsIgnoreCase(shortName)) return item;
        }

        //Return null if not in inventory
        return null;
    }

    //Return all items currently carried by the player
    public ArrayList<Item> getInventory() {
        return inventory;
    }

    // Move the player to the given direction
    public boolean move(String direction) {

        Room desiredRoom = switch (direction) {
            case "north" -> currentRoom.getNorth();
            case "east" -> currentRoom.getEast();
            case "south" -> currentRoom.getSouth();
            case "west" -> currentRoom.getWest();
            default -> null;
        };

        // Move if a room exists in the direction
        if (desiredRoom != null) {
            currentRoom = desiredRoom;
            return true;
        } else {
            return false;
        }
    }
}
