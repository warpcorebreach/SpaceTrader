
package space.trader.resources.Equiptment;

/**
 *
 * @author Weiyu
 */
public class Shield {
    private String name;
    private int shieldPower;
    public Shield(String s) {
        if(s.equals("Energy Shield")) {
            name = s;
            shieldPower = 50;
        }
        if(s.equals("Reflective Shield")) {
            name = s;
            shieldPower = 100;
        }
    }
    public int getShieldPower() {
        return shieldPower;
    }
    public String getName() {
        return name;
    }
}
