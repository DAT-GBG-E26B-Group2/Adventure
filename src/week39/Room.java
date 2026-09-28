package week39;

import java.util.ArrayList;

public class Room {
    private String name;
    private String description;
    private String sound;
    private ArrayList<Item> items = new ArrayList<>();
    private Room north;
    private Room south;
    private Room east;
    private Room west;


    public Room(String name, String description, String sound){
        this.name = name;
        this.description = description;
        this.sound = sound;
    }
    public void addItems(Item item) {
        items.add(item);
    }
    public void removeItems(Item item) {
        items.remove(item);
    }
    private Item getItem(String name){
        for(Item item : items){
            if(name.equalsIgnoreCase(item.getShortName())){
                return item;
            }
        }
        return null;
    }
    public Item findItem(String name){
        for(Item item : items){
            if(name.equalsIgnoreCase(item.getShortName())){
                return item;
            }
        }
        return null;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setNorth(Room north) {
        this.north = north;
    }

    public void setSouth(Room south) {
        this.south = south;
    }

    public void setEast(Room east) {
        this.east = east;
    }

    public void setWest(Room west) {
        this.west = west;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Room getNorth() {
        return north;
    }

    public Room getSouth() {
        return south;
    }

    public Room getEast() {
        return east;
    }

    public Room getWest() {
        return west;
    }
    public String getSound(){
        return sound;
    }
    public ArrayList<Item> getItems() {
        return items;
    }
}
