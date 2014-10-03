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
            this.MTLP = MTLP;   // min tech level to produce
            this.MTLU = MTLU;   // min tech level for system to use
            this.TTP = TTP;
            this.basePrice = basePrice;
            this.IPL = IPL;
            this.var = var;
            this.CR = CR;
            this.ER = ER;
            this.name = name;
    }
    
    /**
     * Getter for MTLP
     * @return The good's MTLP
     */
    public int getMTLP() {
        return MTLP;
    }
    
    /**
     * Getter for MTLU
     * @return The good's MTLU
     */
    public int getMTLU() {
        return MTLU;
    }
    
    /**
     * Getter for TTP
     * @return The good's TTP
     */
    public int getTTP() {
        return TTP;
    }
    
    /**
     * Getter for basePrice
     * @return The good's basePrice
     */
    public int getBasePrice() {
        return basePrice;
    }
    
    /**
     * Getter for IPL
     * @return The good's IPL
     */
    public int getIPL() {
        return IPL;
    }
    
    /**
     * Getter for var
     * @return The good's var
     */
    public int getVar() {
        return var;
    }
    
    /**
     * Getter for CR
     * @return The good's CR
     */
    public Resources getCR() {
        return CR;
    }
    
    /**
     * Getter for ER
     * @return The good's ER
     */
    public Resources getER() {
        return ER;
    }
    
    /**
     * Getter for name
     * @return The good's name
     */
    public String getName() {
        return name;
    }
}
