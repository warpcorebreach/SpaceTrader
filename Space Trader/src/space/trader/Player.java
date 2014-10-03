/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package space.trader;
import space.trader.items.*;

/**
 *
 * @author Weiyu
 */
public class Player {
    private String name;
    private int pilot, fighter, trader, engineer, investor, cash;
    public Player(String name, int p, int f, int t, int e, int i) {
        pilot = p;
        fighter = f;
        this.name = name;
        trader = t;
        engineer = e;
        investor = i;
        cash = 10000;
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
    public int getCash() {
        return cash;
    }
    public void setCash(int c) {
        cash = c;
    }
}

