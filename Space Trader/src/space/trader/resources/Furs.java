/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space.trader.resources;

import space.trader.location.SystemStats.Resources;

/**
 * Represents a Fur object
 * @author Justin
 */
public class Furs extends TradeGood {

    public Furs() {
        super(0, 0, 0, 250, 10, 10, Resources.RICHFAUNA, Resources.LIFELESS, "Furs");
    }
    
}