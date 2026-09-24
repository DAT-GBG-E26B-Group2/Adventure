public class Room {

    //Basic info about the room
    private String name;
    private String description;

    //Reference to other rooms
    private Room north;
    private Room east;
    private Room south;
    private Room west;

    //Create room with a name and description
    public Room(String name, String description) {
        this.name = name;
        this.description = description;
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
