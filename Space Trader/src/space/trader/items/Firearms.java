/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space.trader.items;

import space.trader.SystemStats.Resources;


/**
 *
 * @author Justin
 */
public class Firearms extends TradeGood {
    public Firearms() {
        super(3, 1, 5, 1250, -75, 100, Resources.WARLIKE, null, "Firearms");
    }
}
