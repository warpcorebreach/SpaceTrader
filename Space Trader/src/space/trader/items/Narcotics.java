/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space.trader.items;

import space.trader.SystemStats.Resources;


/**
 * Represents a Narcotics object
 * @author Justin
 */
public class Narcotics extends TradeGood {
    public Narcotics() {
        super(5, 0, 5, 3500, -125, 150, Resources.WEIRDMUSHROOMS, null, "Narcotics");
    }
}
