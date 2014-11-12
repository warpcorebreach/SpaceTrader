
package space.trader.resources.Equipment;

import java.io.Serializable;

/**
 *
 * @author Weiyu
 */
public class Weapon implements Serializable {
    private String weaponName;
    private int power;
    private int charges;
    private int cost;
    private static final int pulsePower = 10;
    private static final int pulseCharge = 30;
    private static final int pulseCost = 2000;
    private static final int beamPower = 15;
    private static final int beamCharge = 25;
    private static final int beamCost = 2950;
    private static final int militaryPower = 25;
    private static final int militaryCharge = 30;
    private static final int militaryCost = 4250;
    private static final int superPower = 55;
    private static final int superCharge = 10;
    private static final int superCost = 5550;
    /** Weapon for Ship.
     * Depend on input create a new weapon
     * @param s the name of the weapon
     */
    public Weapon(final String s) {
        weaponName = s;
        if (weaponName.equals("Pulse Laser")) {
            power = pulsePower;
            charges = pulseCharge;
            cost = pulseCost;
        }
        if (weaponName.equals("Beam Laser")) {
            power = beamPower;
            charges = beamCharge;
            cost = beamCost;
        }
        if (weaponName.equals("Military Laser")) {
            power = militaryPower;
            charges = militaryCharge;
            cost = militaryCost;
        }
        if (weaponName.equals("Super Laser")) {
            power = superPower;
            charges = superCharge;
            cost = superCost;
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
        return "Weapon name: " + weaponName + "\nPower: "
                + power + "\nCharges: " + charges + "\nCost: " + cost;
    }
}
