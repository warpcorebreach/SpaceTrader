
package space.trader.resources.TradeGoods;


/**
 * Represents a Robot object.
 * @author Justin
 */
public class Robots extends TradeGood {

    /**
     * Create a new Robot with a call to TradeGood's constructor.
     * Format: super(MTLP, MTLU, TTP, basePrice, IPL, var, CR, ER, name)
     */
    public Robots() {
        super(6, 4, 7, 5000, -150, 100, null, null, "Robots");
    }
}
