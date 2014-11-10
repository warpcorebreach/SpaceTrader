
package space.trader.resources.Equipment;

import java.io.Serializable;

/**
 *
 * @author Weiyu
 */
public class Shield implements Serializable {
    private String name;
    private int shieldPower;
    private int cost;
    public Shield(String s) {
        if(s.equals("Energy Shield")) {
            name = s;
            shieldPower = 50;
            cost = 4500;
        }
        if(s.equals("Reflective Shield")) {
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
        return "Shield name: " + name + "\nShield power: " + shieldPower + "\nCost: " + cost;
    }    
}
