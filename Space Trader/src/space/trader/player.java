/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package space.trader;

/**
 *
 * @author Weiyu
 */
public class player {
    private String name;
    private int pilot, fighter, trader, engineer, investor;
    public player(String name, int p, int f, int t, int e, int i) {
        pilot = p;
        fighter = f;
        this.name = name;
        trader = t;
        engineer = e;
        investor = i;
    }
    public int getPilot() {
        return pilot;
    }
    public int getFighter() {
        return fighter;
    }
    public int getTrader() {
        return trader;
    }
    public int getEngineer() {
        return engineer;
    }
    public int getInvestor() {
        return investor;
    }
    public String getName() {
        return name;
    }
}
