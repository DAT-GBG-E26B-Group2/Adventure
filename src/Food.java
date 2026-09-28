public class Food extends Item{

    private int healthPoints;

    //Constractor that inherits shortname and longname from Item class
    public Food(String shortName, String longName, int healthPoints) {
        super(shortName, longName);
        this.healthPoints = healthPoints;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

}
