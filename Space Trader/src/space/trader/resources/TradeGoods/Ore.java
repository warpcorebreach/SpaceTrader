
package space.trader.resources.TradeGoods;

import space.trader.location.SystemStats.Resources;


/**
 * Represents an Ore object
 * @author Justin
 */
public class Ore extends TradeGood {

    public Ore() {
        super(2, 2, 3, 350, 20, 10, Resources.MINERALRICH, Resources.MINERALPOOR, "Ore");
    }
    
}
