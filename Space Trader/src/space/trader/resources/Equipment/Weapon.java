
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
    private static final int PULSE_POWER = 10;
    private static final int PULSE_CHARGE = 30;
    private static final int PULSE_COST = 2000;
    private static final int BEAM_POWER = 15;
    private static final int BEAM_CHARGE = 25;
    private static final int BEAM_COST = 2950;
    private static final int MILITARY_POWER = 25;
    private static final int MILITARY_CHARGE = 30;
    private static final int MILITARY_COST = 4250;
    private static final int SUPER_POWER = 55;
    private static final int SUPER_CHARGE = 10;
    private static final int SUPER_COST = 5550;
    /** Weapon for Ship.
     * Depend on input create a new weapon
     * @param s the name of the weapon
     */
    public Weapon(final String s) {
        weaponName = s;
        if (weaponName.equals("Pulse Laser")) {
            power = PULSE_POWER;
            charges = PULSE_CHARGE;
            cost = PULSE_COST;
        }
        if (weaponName.equals("Beam Laser")) {
            power = BEAM_POWER;
            charges = BEAM_CHARGE;
            cost = BEAM_COST;
        }
        if (weaponName.equals("Military Laser")) {
            power = MILITARY_POWER;
            charges = MILITARY_CHARGE;
            cost = MILITARY_COST;
        }
        if (weaponName.equals("Super Laser")) {
            power = SUPER_POWER;
            charges = SUPER_CHARGE;
            cost = SUPER_COST;
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
