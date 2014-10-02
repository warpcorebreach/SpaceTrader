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
public abstract class TradeGood {
    protected final int MTLP, MTLU, TTP, basePrice, IPL, var;
    protected final Resources CR, ER;
    
    public TradeGood(int MTLP, int MTLU, int TTP, int basePrice, int IPL, int var,
                Resources CR, Resources ER) {
            this.MTLP = MTLP;
            this.MTLU = MTLU;
            this.TTP = TTP;
            this.basePrice = basePrice;
            this.IPL = IPL;
            this.var = var;
            this.CR = CR;
            this.ER = ER;
        }
}
