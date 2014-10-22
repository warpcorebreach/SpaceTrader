
package space.trader.resources;

import space.trader.location.SystemStats.Resources;


/**
 * Represents a Games object
 * @author Justin
 */
public class Games extends TradeGood {
    public Games() {
        super(3, 1, 6, 250, -10, 5, Resources.ARTISTIC, null, "Games");
    }
}
