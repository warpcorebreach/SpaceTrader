
package space.trader.resources.TradeGoods;

import space.trader.location.SystemStats.Resources;

/**
 * Represents a Fur object
 * @author Justin
 */
public class Furs extends TradeGood {

    /**
     * Create a new Fur with a call to TradeGood's constructor.
     * Format: super(MTLP, MTLU, TTP, basePrice, IPL, var, CR, ER, name)
     */
    public Furs() {
        super(0, 0, 0, 250, 10, 10, Resources.RICHFAUNA, Resources.LIFELESS, "Furs");
    }

}
