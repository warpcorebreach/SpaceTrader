
package space.trader.resources.TradeGoods;

import space.trader.location.SystemStats.Resources;


/**
 * Represents a Medicine object
 * @author Justin
 */
public class Medicine extends TradeGood {
    public Medicine() {
        super(4, 1, 6, 650, -20, 10, Resources.LOTSOFHERBS, null, "Medicine");
    }
}
