import java.util.ArrayList;

public class Room {

    //Basic info about the room
    private String name;
    private String description;

    private ArrayList<Item> items;

    //Reference to other rooms
    private Room north;
    private Room east;
    private Room south;
    private Room west;

    //Create room with a name and description and also an empty list of items
    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        items = new ArrayList<>();
    }

    //Add item object to room (array list)
    public void addItem(Item item) {
        items.add(item);
    }

    //Removes item object from room
    public void removeItem(Item item) {
        items.remove(item);
    }

    //Return list of items in room
    public ArrayList<Item> getItems() {
        return items;
    }

    //Search room for item by shortname.
    //Return matching Item object or
    //return null if no matching item exists
    public Item findItem(String shortName) {
        for (Item item: items) {
            if(item.getShortName().equalsIgnoreCase(shortName)) return item;
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    //Create connection to north
    public void setNorth(Room north) {
        this.north = north;
    }

    public Room getNorth() {
        return north;
    }

    //Create connection to east
    public void setEast(Room east) {
        this.east = east;
    }

    public Room getEast() {
        return east;
    }

    //Create connection to south
    public void setSouth(Room south) {
        this.south = south;
    }

    public Room getSouth() {
        return south;
    }

    //Create connection to weest
    public void setWest(Room west) {
        this.west = west;
    }

    public Room getWest() {
        return west;
    }
}
