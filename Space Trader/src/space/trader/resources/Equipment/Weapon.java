
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
        if(weaponName.equals("Pulse Laser")) {
            power = 10;
            charges = 30;
        }
        if(weaponName.equals("Beam Laser")) {
            power = 15;
            charges = 25;
        }
        if(weaponName.equals("Military Laser")) {
            power = 25;
            charges = 30;
        }
        if(weaponName.equals("Super Laser")) {
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
