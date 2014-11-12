
package space.trader.resources.TradeGoods;

import space.trader.location.SystemStats.Resources;


/**
 * Represents a Medicine object.
 * @author Justin
 */
public class Medicine extends TradeGood {

    /**
     * Create a new Medicine with a call to TradeGood's constructor.
     * Format: super(MTLP, MTLU, TTP, basePrice, IPL, var, CR, ER, name)
     */
    public Medicine() {
        super(4, 1, 6, 650, -20, 10, Resources.LOTSOFHERBS, null, "Medicine");
    }
}
