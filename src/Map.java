public class Map {

    public Room buildMap() {
        //Create all 9 rooms for the game
        Room room1 = new Room("Crash Site", "The remains of your spacecraft lie scattered across the black sand. \nSmoke rises from the twisted metal and the air is unnaturally quiet.");
        Room room2 = new Room("Dead Forest", "Tall, pale trees surround you. \nTheir branches twist toward the dark sky, and something seems to move between them.");
        Room room3 = new Room("Abandoned Camp", "A small research camp stands deserted. \nThe tents are torn open, and strange footprints disappear into the darkness.");
        Room room4 = new Room("Wreckage", "A broken section of the spacecraft lies half-buried in the ground. \nSparks flicker from damaged cables inside the wreck.");
        Room room5 = new Room("Ancient Vault", "You enter a cold chamber built from smooth black stone. \nStrange symbols glow faintly across the walls. \nAt the center of the chamber stands a massive sealed door. \nA narrow indentation is carved into its surface, surrounded by the same strange symbols that cover the walls.");
        Room room6 = new Room("Research Outpost", "The outpost is dark and silent. \nBroken equipment covers the floor, and deep scratches mark the metal walls.");
        Room room7 = new Room("Dark Cavern", "The cave descends into darkness. \nWater drips from the ceiling, and a low growl echoes somewhere in the distance.");
        Room room8 = new Room("Alien Ruins", "Massive stone structures rise from the ground. \nTheir architecture is unlike anything made by humans.");
        Room room9 = new Room("Signal Tower", "A damaged communication tower reaches toward the sky. \nIts control panel still flickers with a weak blue light.");

        //Add different items to each room
        room1.addItem(new Item("helmet", "a cracked space helmet"));
        room1.addItem(new Item("photo", "a faded crew photograph"));
        room2.addItem(new Item("crystal", "a faintly glowing crystal"));
        room3.addItem(new Item("relic", "a strange obsidian relic"));
        room3.addItem(new Item("journal", "a damaged research journal"));
        room4.addItem(new Item("battery", "a partially charged power cel"));
        room4.addItem(new Item("scanner", "a broken handheld scanner"));
        room6.addItem(new Item("badge", "a blood-stained ID badge"));
        room6.addItem(new Item("container", "a sealed specimen container"));
        room7.addItem(new Item("tooth", "a large serrated tooth"));
        room7.addItem(new Item("bone", "an unusually long bone"));
        room8.addItem(new Item("tablet", "an ancient stone tablet"));
        room8.addItem(new Item("orb", "a perfectly smooth metal orb"));
        room9.addItem(new Item("transmitter", "a damaged signal transmitter"));

        //Add different foods to rooms
        room1.addItem(new Food("ration", "a sealed emergency ration", 20));
        room2.addItem(new Food("fruit", "a dark blue alien fruit", 15));
        room2.addItem(new Food("mushroom", "a pale glowing mushroom", -35));
        room3.addItem(new Food("bar", "an old protein bar", 10));
        room4.addItem(new Food("gel", "a tube of nutritional gel", 25));
        room6.addItem(new Food("meat", "a sealed piece of unknown meat", -20));
        room7.addItem(new Food("egg", "a small translucent egg", -50));
        room8.addItem(new Food("berries", "a handful of silver berries", 30));

        //Add different weapons to some rooms
        room1.addItem(new RangedWeapon("flaregun", "a damaged emergency flare gun", 2));
        room3.addItem(new MeleeWeapon("machete", "a heavy survival machete"));
        room4.addItem(new RangedWeapon("pistol", "a battered plasma pistol", 5));
        room6.addItem(new RangedWeapon("rifle", "an experimental pulse rifle", 3));
        room8.addItem(new MeleeWeapon("blade", "a strange alien blade"));

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

        //Return room1 as player starting room
        return room1;
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
}
