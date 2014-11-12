
package space.trader.resources.TradeGoods;

import space.trader.location.SystemStats.Resources;

/**
 * Represents a Water object.
 * @author Justin
 */
public class Water extends TradeGood {

    /**
     * Create a new Water with a call to TradeGood's constructor.
     * Format: super(MTLP, MTLU, TTP, basePrice, IPL, var, CR, ER, name)
     */
    public Water() {
        super(0, 0, 2, 30, 3, 4, Resources.LOTSOFWATER, Resources.DESERT, "Water");
    }

}
