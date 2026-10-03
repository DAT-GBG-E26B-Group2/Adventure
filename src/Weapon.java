public abstract class Weapon extends Item {

    public Weapon(String shortName, String longName) {
        super(shortName, longName);
    }

    //Return true if weapon can be used currently
    public abstract boolean canUse();

    //Use the weapon once
    public abstract void use();

    //Return weapon using word when attacking
    public abstract String getAttack();

    //Return info about remaining uses/ammo
    public abstract String getUsesLeft();
}
