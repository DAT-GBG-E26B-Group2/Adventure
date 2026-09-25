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
