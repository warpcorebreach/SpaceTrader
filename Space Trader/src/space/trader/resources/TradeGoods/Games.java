
package space.trader.resources.TradeGoods;

import space.trader.location.SystemStats.Resources;


/**
 * Represents a Games object.
 * @author Justin
 */
public class Games extends TradeGood {

    /**
     * Create a new Games with a call to TradeGood's constructor.
     * Format: super(MTLP, MTLU, TTP, basePrice, IPL, var, CR, ER, name)
     */
    public Games() {
        super(3, 1, 6, 250, -10, 5, Resources.ARTISTIC, null, "Games");
    }
}
