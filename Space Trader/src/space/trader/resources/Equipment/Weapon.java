
package space.trader.resources.Equipment;

/**
 *
 * @author Weiyu
 */
public class Weapon {
    private String weaponName;
    private int power;
    private int charges;
    private int cost;
    public Weapon(String s) {
        weaponName = s;
        if(weaponName.equals("Pulse Laser")) {
            power = 10;
            charges = 30;
            cost = 2000;
        }
        if(weaponName.equals("Beam Laser")) {
            power = 15;
            charges = 25;
            cost = 2950;
        }
        if(weaponName.equals("Military Laser")) {
            power = 25;
            charges = 30;
            cost = 4250;
        }
        if(weaponName.equals("Super Laser")) {
            power = 55;
            charges = 10;
            cost = 5550;
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
    public int getCost() {
        return cost;
    }
    @Override
    public String toString() {
        return "Weapon name: " + weaponName + "\nPower: " + power + "\nCharges: " + charges + "\nCost: " + cost;
    }
}
