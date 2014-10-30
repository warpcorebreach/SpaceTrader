
package space.trader.resources.Equiptment;

/**
 *
 * @author Weiyu
 */
public class Weapon {
    private String weaponName;
    private int power;
    private int charges;
    public Weapon(String s) {
        weaponName = s;
        if(weaponName.equals("pulse laser")) {
            power = 10;
            charges = 30;
        }
        if(weaponName.equals("beam laser")) {
            power = 15;
            charges = 25;
        }
        if(weaponName.equals("military laser")) {
            power = 25;
            charges = 30;
        }
        if(weaponName.equals("Super laser")) {
            power = 55;
            charges = 10;
        }
    }
    public int getPower() {
        return power;
    }
    public int getCharges() {
        return charges;
    }
    public String getName() {
        return weaponName;
    }
}
