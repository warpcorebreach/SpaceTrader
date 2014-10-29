
package space.trader.resources.TradeGoods;

import space.trader.location.SystemStats.Resources;

/**
 * Represents a Water object
 * @author Justin
 */
public class Water extends TradeGood {

    public Water() {
        super(0, 0, 2, 30, 3, 4, Resources.LOTSOFWATER, Resources.DESERT, "Water");
    }
    
}
