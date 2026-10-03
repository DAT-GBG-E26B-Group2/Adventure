public class RangedWeapon extends Weapon {

    private int ammunition;

    public RangedWeapon(String shortName, String longName, int ammunition) {
        super(shortName, longName);
        this.ammunition = ammunition;
    }

    //Ranged weapon can be used is there is ammo left in wapon
    @Override
    public boolean canUse() {
        return ammunition > 0;
    }

    //When used first check if weapon can be used and then use it and reduce ammo by 1
    @Override
    public void use() {
        if(canUse()) ammunition--;
    }

    @Override
    public String getAttack() {
        return "fire";
    }

    @Override
    public String getUsesLeft() {
        return ammunition + " shots left";
    }
}
