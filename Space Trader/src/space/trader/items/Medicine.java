/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space.trader.items;

import space.trader.SystemStats.Resources;


/**
 * Represents a Medicine object
 * @author Justin
 */
public class Medicine extends TradeGood {
    public Medicine() {
        super(4, 1, 6, 650, -20, 10, Resources.LOTSOFHERBS, null, "Medicine");
    }
}
