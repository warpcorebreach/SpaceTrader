
package space.trader.resources.TradeGoods;

import space.trader.location.SystemStats.Resources;


/**
 * Represents a Narcotics object.
 * @author Justin
 */
public class Narcotics extends TradeGood {

    /**
     * Create a new Narcotics with a call to TradeGood's constructor.
     * Format: super(MTLP, MTLU, TTP, basePrice, IPL, var, CR, ER, name)
     */
    public Narcotics() {
        super(5, 0, 5, 3500, -125, 150, Resources.WEIRDMUSHROOMS, null, "Narcotics");
    }
}
