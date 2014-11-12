
package space.trader.resources.TradeGoods;

import space.trader.location.SystemStats.Resources;


/**
 * Represents a Food object.
 * @author Justin
 */
public class Food extends TradeGood {

    /**
     * Create a new Food with a call to TradeGood's constructor.
     * Format: super(MTLP, MTLU, TTP, basePrice, IPL, var, CR, ER, name)
     */
    public Food() {
        super(1, 0, 1, 100, 5, 5, Resources.RICHSOIL, Resources.POORSOIL, "Food");
    }

}
