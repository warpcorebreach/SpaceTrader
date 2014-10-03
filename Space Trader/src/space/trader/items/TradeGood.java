/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space.trader.items;

import space.trader.SystemStats.Resources;

/**
 * Represents a generic TradeGood object
 * Contains all the fields and methods a TradeGood should have
 * 
 * @author Justin
 */
public abstract class TradeGood {
    protected final int MTLP, MTLU, TTP, basePrice, IPL, var;
    protected final Resources CR, ER;
    protected final String name;
    
    public TradeGood(int MTLP, int MTLU, int TTP, int basePrice, int IPL, int var,
                Resources CR, Resources ER, String name) {
            this.MTLP = MTLP;
            this.MTLU = MTLU;
            this.TTP = TTP;
            this.basePrice = basePrice;
            this.IPL = IPL;
            this.var = var;
            this.CR = CR;
            this.ER = ER;
            this.name = name;
    }
    
    public int getMTLP() {
        return MTLP;
    }
    
    public int getMTLU() {
        return MTLU;
    }

    public int getTTP() {
        return TTP;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public int getIPL() {
        return IPL;
    }

    public int getVar() {
        return var;
    }

    public Resources getCR() {
        return CR;
    }

    public Resources getER() {
        return ER;
    }
    
    public String getName() {
        return name;
    }
}
