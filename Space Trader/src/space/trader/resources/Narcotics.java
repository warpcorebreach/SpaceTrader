
package space.trader.resources;

import space.trader.location.SystemStats.Resources;


/**
 * Represents a Narcotics object
 * @author Justin
 */
public class Narcotics extends TradeGood {
    public Narcotics() {
        super(5, 0, 5, 3500, -125, 150, Resources.WEIRDMUSHROOMS, null, "Narcotics");
    }
}
