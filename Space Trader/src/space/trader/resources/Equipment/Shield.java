
package space.trader.resources.Equipment;

import java.io.Serializable;

/**
 *
 * @author Weiyu
 */
public class Shield implements Serializable {
    /**
     * name corresponds to the type of shield.
     */
    private String name;
    /**
     * Strength of the shield.
     */
    private int shieldPower;
    /**
     * How much a shield costs to purchase.
     */
    private int cost;

    /**
     * Create a new shield object.
     * @param s the name of the shield type
     */
    public Shield(String s) {
        if (s.equals("Energy Shield")) {
            name = s;
            shieldPower = 50;
            cost = 4500;
        }
        if (s.equals("Reflective Shield")) {
            name = s;
            shieldPower = 100;
            cost = 7500;
        }
    }

    public int getShieldPower() {
        return shieldPower;
    }
    public String getName() {
        return name;
    }
    public int getCost() {
        return cost;
    }
    
    @Override
    public String toString() {
        return "Shield name: " + name + "\nShield power: " + shieldPower
                + "\nCost: " + cost;
    }
}
