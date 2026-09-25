public class Adventure {

    //Player controlled by game
    private Player player;

    public Adventure() {
        //Create the map
        Map map = new Map();
        Room startingRoom = map.buildMap();

        //Create player in room1
        player = new Player(startingRoom);
    }

    // Move player
    public boolean move(String direction) {
        return player.move(direction);
    }

    // Returns the room the player is currently in
    public Room getCurrentRoom() {
        return player.getCurrentRoom();
    }
}
