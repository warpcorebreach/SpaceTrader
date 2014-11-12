
package space.trader.resources.TradeGoods;


/**
 * Represents a Machines object.
 * @author Justin
 */
public class Machines extends TradeGood {

    /**
     * Create a new Machines with a call to TradeGood's constructor.
     * Format: super(MTLP, MTLU, TTP, basePrice, IPL, var, CR, ER, name)
     */
    public Machines() {
        super(4, 3, 5, 900, -30, 5, null, null, "Machines");
    }
}
