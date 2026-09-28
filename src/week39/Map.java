package week39;

public class Map {
    public static Room buildmap() {
        Room room1 = new Room("The Mineshaft", "This mineshaft is dark and full of spiders", "");
        Item lamp = new Item("flashlight", "A military grade flashlight.");
        room1.addItems(lamp);
        Item key = new Item("key", "Open a door with this key.");
        room1.addItems(key);
        Room room2 = new Room("The Haunted Mansion", "This mansion is haunted with spirits", "");
        Room room3 = new Room("The Old Space Station", "This place is a safe zone, it was used for research in the past", "");
        Room room4 = new Room("The hut", "Empty besides a bedroll", "");
        Room room5 = new Room("The Gold Room", "Full of gold coins", "");
        Room room6 = new Room("The School", "A good place to gather knowledge", "");
        Room room7 = new Room("The Nuclear Facility", "Very radioactive you want to leave as soon as possible", "");
        Room room8 = new Room("The Kitchen", "Food is abundant you start drooling uncontrollably", "");
        Room room9 = new Room("The Forrest", "You cant see more then 3 meters ahead of you and suddenly a noise comes from next to you", "");
        connectSouthNorth(room1, room4, room3, room7, room6, room9, room5, room8);
        connectEastWest(room1, room2, room3, room7, room8, room9);

        return room1;
    }
    public static void connectEastWest(Room room1, Room room2, Room room3, Room room7, Room room8, Room room9 ){
        room1.setEast(room2);
        room2.setWest(room1);
        room2.setEast(room3);
        room3.setWest(room2);
        //
        room7.setEast(room8);
        room8.setWest(room7);
        room8.setEast(room9);
        room9.setWest(room8);
    }
    public static void connectSouthNorth(Room room1, Room room4, Room room3, Room room7, Room room6, Room room9, Room room5, Room room8 ){
        room1.setSouth(room4);
        room4.setNorth(room1);
        room4.setSouth(room7);
        room7.setNorth(room4);
        //
        room3.setSouth(room6);
        room6.setNorth(room3);
        room6.setSouth(room9);
        room9.setNorth(room6);
        room5.setSouth(room8);
        room8.setNorth(room5);
    }
}
