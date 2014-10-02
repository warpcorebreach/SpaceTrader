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
public class Games extends TradeGood {
    public Games() {
        super(3, 1, 6, 250, -10, 5, Resources.ARTISTIC, null, "Games");
    }
}
