
package space.trader.resources.TradeGoods;

import space.trader.location.SystemStats.Resources;


/**
 * Represents an Ore object.
 * @author Justin
 */
public class Ore extends TradeGood {

    /**
     * Create a new Ore with a call to TradeGood's constructor.
     * Format: super(MTLP, MTLU, TTP, basePrice, IPL, var, CR, ER, name)
     */
    public Ore() {
        super(2, 2, 3, 350, 20, 10, Resources.MINERALRICH, Resources.MINERALPOOR, "Ore");
    }

}
