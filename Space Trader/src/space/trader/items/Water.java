/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space.trader.items;

import space.trader.SystemStats;

/**
 *
 * @author Justin
 */
public class Water extends TradeGood {

    public Water(int MTLP, int MTLU, int TTP, int basePrice, int IPL, int var,
            SystemStats.Resources CR, SystemStats.Resources ER) {
        super(MTLP, MTLU, TTP, basePrice, IPL, var, CR, ER);
    }
    
}
