/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space.trader.resources;

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
