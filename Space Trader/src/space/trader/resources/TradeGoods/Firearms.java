
package space.trader.resources.TradeGoods;

import space.trader.location.SystemStats.Resources;


/**
 * Represents a FireArms TradeGood.
 * @author Justin
 */
public class Firearms extends TradeGood {

    /**
     * Create a new Firearms with a call to TradeGood's constructor.
     * Format: super(MTLP, MTLU, TTP, basePrice, IPL, var, CR, ER, name)
     */
    public Firearms() {
        super(3, 1, 5, 1250, -75, 100, Resources.WARLIKE, null, "Firearms");
    }
}
