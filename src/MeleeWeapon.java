public class MeleeWeapon  extends Weapon{

    public MeleeWeapon(String shortName, String longName) {
        super(shortName, longName);
    }

    @Override
    public boolean canUse() {
        return true;
    }

    @Override
    public void use() {
        //Melee waepons dont run out of use/ has no ammo
    }

    @Override
    public String getAttack() {
        return "swing";
    }

    @Override
    public String getUsesLeft() {
        return "";
    }
}
