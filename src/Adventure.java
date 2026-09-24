public class Adventure {

    //Keep track of the room player is in
    private static Room currentRoom;

    public static void buildMap() {

        //Create all 9 rooms for the game
        Room room1 = new Room("Crash Site", "The remains of your spacecraft lie scattered across the black sand. \nSmoke rises from the twisted metal and the air is unnaturally quiet.");
        Room room2 = new Room("Dead Forest", "Tall, pale trees surround you. \nTheir branches twist toward the dark sky, and something seems to move between them.");
        Room room3 = new Room("Abandoned Camp", "A small research camp stands deserted. \nThe tents are torn open, and strange footprints disappear into the darkness.");
        Room room4 = new Room("Wreckage", "A broken section of the spacecraft lies half-buried in the ground. \nSparks flicker from damaged cables inside the wreck.");
        Room room5 = new Room("Ancient Vault", "You enter a cold chamber built from smooth black stone. \nStrange symbols glow faintly across the walls.");
        Room room6 = new Room("Research Outpost", "The outpost is dark and silent. \nBroken equipment covers the floor, and deep scratches mark the metal walls.");
        Room room7 = new Room("Dark Cavern", "The cave descends into darkness. \nWater drips from the ceiling, and a low growl echoes somewhere in the distance.");
        Room room8 = new Room("Alien Ruins", "Massive stone structures rise from the ground. \nTheir architecture is unlike anything made by humans.");
        Room room9 = new Room("Signal Tower", "A damaged communication tower reaches toward the sky. \nIts control panel still flickers with a weak blue light.");

        //Connect rooms horizontally
        connectEastWest(room1, room2);
        connectEastWest(room2, room3);
        connectEastWest(room7, room8);
        connectEastWest(room8, room9);

        //Connect rooms vertically
        connectSouthNorth(room1, room4);
        connectSouthNorth(room4, room7);
        connectSouthNorth(room3, room6);
        connectSouthNorth(room6, room9);

        //Room 5 has only one entrance
        connectSouthNorth(room5, room8);

        //Game starts at roome 1
        currentRoom = room1;
    }

    //Method used to connect 2 rooms in both east and west
    public static void connectEastWest(Room a, Room b) {
        a.setEast(b);
        b.setWest(a);
    }

    //Method used to connect 2 rooms in south and north direction
    public static void connectSouthNorth(Room a, Room b) {
        a.setSouth(b);
        b.setNorth(a);
    }

    //Returns current room player is in
    public static Room getCurrentRoom() {
        return currentRoom;
    }

    //Move player to north
    public static boolean goNorth() {
        if(currentRoom.getNorth() == null) return false;
        currentRoom = currentRoom.getNorth();
        return true;
    }

    //Move player to east
    public static boolean goEast() {
        if(currentRoom.getEast() == null) return false;
        currentRoom = currentRoom.getEast();
        return true;
    }

    //Move player to south
    public static boolean goSouth() {
        if(currentRoom.getSouth() == null) return false;
        currentRoom = currentRoom.getSouth();
        return true;
    }

    //Move player to west
    public static boolean goWest() {
        if(currentRoom.getWest() == null) return false;
        currentRoom = currentRoom.getWest();
        return true;
    }
}
