package week39;

import java.util.ArrayList;

public class Player {
    private ArrayList<Item> inventory = new ArrayList<>();
    public Room currentRoom;


    public void addItem(Item item) {
        inventory.add(item);
    }


    public void removeItem(Item item) {
        inventory.remove(item);
    }


    public Item takeItem(String shortName) {
        Item item = currentRoom.findItem(shortName);
        if (item != null) {
            addItem(item);
            currentRoom.removeItems(item);
            return item;
        }
        return null;
    }


    public Item dropItem(String shortName) {
        Item item = findItem(shortName);
        if (item != null) {
            removeItem(item);
            currentRoom.addItems(item);
            return item;
        }
        return null;
    }


    public Item findItem(String name){
        for(Item item : inventory){
            if(name.equalsIgnoreCase(item.getShortName())){
                return item;
            }
        }
        return null;
    }


    public ArrayList<Item> getInventory() {
        return inventory;
    }
    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }
}