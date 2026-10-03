import java.util.ArrayList;

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

    //Tell player to try taking and item
    public Item takeItem(String shortName) {
        return player.takeItem(shortName);
    }

    //Tell player to try dropping an item
    public Item dropItem(String shortName) {
        return player.dropItem(shortName);
    }

    //Return players inventory
    public ArrayList<Item> getInventory() {
        return player.getInventory();
    }

    //Return players current health
    public int getHealth() { return player.getHealth(); }

    //Make player eat item/food
    public EatResult eat(String shortName) { return player.eat(shortName); }

    //Make player equip weapon
    public EquipResult equip(String shortName) { return player.equip(shortName); }

    //Get players equipped weapon
    public Weapon getEquippedWeapon() { return player.getEquippedWeapon(); }

    //Make player attack
    public AttackResult attack() { return player.attack(); }

    // Move player
    public boolean move(String direction) {
        return player.move(direction);
    }

    // Returns the room the player is currently in
    public Room getCurrentRoom() {
        return player.getCurrentRoom();
    }
}
