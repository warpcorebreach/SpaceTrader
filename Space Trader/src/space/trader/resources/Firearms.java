
package space.trader.resources;

import space.trader.location.SystemStats.Resources;


/**
 * Represents a FireArms TradeGood
 * @author Justin
 */
public class Firearms extends TradeGood {
    public Firearms() {
        super(3, 1, 5, 1250, -75, 100, Resources.WARLIKE, null, "Firearms");
    }
}
