/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space.trader.items;

import space.trader.SystemStats.Resources;


/**
 * Represents an Ore object
 * @author Justin
 */
public class Ore extends TradeGood {

    public Ore() {
        super(2, 2, 3, 350, 20, 10, Resources.MINERALRICH, Resources.MINERALPOOR, "Ore");
    }
    
}
