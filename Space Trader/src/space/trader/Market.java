/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space.trader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import space.trader.items.*;

/**
 * Represents a Marketplace where goods can be bought and sold.
 * 
 * @author Justin
 */
public class Market {
    SolarSystem sys;
    
    // maps a TradeGood to its available stock on the planet
    HashMap<TradeGood, Integer> goodList;
    // maps a TradeGood to its price on the planet
    HashMap<TradeGood, Integer> goodPrices;
    
    // full set of goods available to any Market
    Water water;
    Furs furs;
    Food food;
    Ore ore;
    Games games;
    Firearms arms;
    Medicine meds;
    Machines machines;
    Narcotics narcs;
    Robots bots;
    
    /**
     * Takes in a SolarSystem object and instantiates TradeGood objects.
     * 
     * @param sys The location of the Market
     */
    public Market(SolarSystem sys) {
        // maps goods to their availability in the current system
        // null availability means the good cannot be produced by the system
        goodList = new HashMap<>();
        // maps goods to their prices in the current system
        goodPrices = new HashMap<>();
        this.sys = sys;
        
        food = new Food();
        ore = new Ore();
        games = new Games();
        arms = new Firearms();
        meds = new Medicine();
        machines = new Machines();
        narcs = new Narcotics();
        bots = new Robots();
        
        generateGoods();
        generatePrices();
    }
    
    /**
     * Determine which goods are available in the current System by comparing its
     * TechLevel to the good's MTLP
     */
    private void generateGoods() {
        // Water and Furs can be produced by every planet so we don't need to
        // compare against the System's TechLevel
        // only their available quantities will change per System
        goodList.put(new Water(), 10);
        goodList.put(new Furs(), 10);
        
        if (sys.getTechLevel().getTechNum() >= food.getMTLP()) {
            goodList.put(food, 10);
        } else {
            goodList.put(food, null);
        }
        
        if (sys.getTechLevel().getTechNum() >= ore.getMTLP()) {
            goodList.put(ore, 10);
        } else {
            goodList.put(ore, null);
        }
        
        if (sys.getTechLevel().getTechNum() >= games.getMTLP()) {
            goodList.put(games, 10);
        } else {
            goodList.put(games, null);
        }
        
        if (sys.getTechLevel().getTechNum() >= arms.getMTLP()) {
            goodList.put(arms, 10);
        } else {
            goodList.put(arms, null);
        }
        
        if (sys.getTechLevel().getTechNum() >= meds.getMTLP()) {
            goodList.put(meds, 10);
        } else {
            goodList.put(meds, null);
        }
        
        if (sys.getTechLevel().getTechNum() >= machines.getMTLP()) {
            goodList.put(machines, 10);
        } else {
            goodList.put(machines, null);
        }
        
        if (sys.getTechLevel().getTechNum() >= narcs.getMTLP()) {
            goodList.put(narcs, 10);
        } else {
            goodList.put(narcs, null);
        }
        
        if (sys.getTechLevel().getTechNum() >= bots.getMTLP()) {
            goodList.put(bots, 10);
        } else {
            goodList.put(bots, null);
        }
    }
    
    /**
     * Generate prices for goods available in the current System
     */
    private void generatePrices() {
        for (TradeGood good : goodList.keySet()) {
            if (goodList.get(good) != null) {
                goodPrices.put(good, getPrice(good));
            } else {
                goodPrices.put(good, null);
            }
        }
    }
    
    /**
     * Takes in a TradeGood and returns its randomly generated price on the
     * current System, according to the formula:
     * (the base price) + (the IPL * (Planet Tech Level - MTLP)) + (variance)
     * 
     * @param good The TradeGood to calculate the price for
     * @return The good's price in the System
     */
    private int getPrice(TradeGood good) {
        Random r = new Random();
        int var = r.nextInt(good.getVar());
        if (r.nextDouble() > 0.5) {
            var = -var;
        }
        int price = good.getBasePrice() + good.getIPL()*(sys.getTechLevel().getTechNum()
                - good.getMTLP()) + var;
        return price;
    }
    
    /**
     * @return A string representation of the Market.
     */
    public String toString() {
        String out = "";
        out += sys.getName() + "\n";
        for (TradeGood good : goodList.keySet()) {
            out += good.getName() + "\n";
            out += "Price: " + goodPrices.get(good) + "\n";
            out += "Availability: " + goodList.get(good) + "\n" + "\n";
        }
        return out;
    }
    
    /**
     * @return An ArrayList of the available goods in the System
     */
    public ArrayList <String> getGoods() {
        ArrayList<String> tgoods = new ArrayList<>();
     for (TradeGood good : goodList.keySet()) {
         if(goodList.get(good) != null) {
             tgoods.add(good.getName());
     }
     }
        return tgoods;
    }
    
    /**
     * @return An ArrayList of the prices in the current System
     */
    public ArrayList <Integer> getPrices() {
        ArrayList<Integer> tprices = new ArrayList<>();
     for (TradeGood good : goodList.keySet()) {
         if(goodList.get(good) != null) {
             tprices.add(goodPrices.get(good));
     }
     }
        return tprices;
    }
    
    /**
     * @return An ArrayList of the quantities of goods available in the system
     */
    public ArrayList <Integer> getQuantity() {
            ArrayList<Integer> tq = new ArrayList<>();
     for (TradeGood good : goodList.keySet()) {
         if(goodList.get(good) != null) {
             tq.add(goodList.get(good));
     }
     }
        return tq;
    }
    
    /**
     * @return An ArrayList of TradeGoods available in the System
     */
    public ArrayList<TradeGood> getTradeGoods() {
     ArrayList<TradeGood> tgoods = new ArrayList<>();
     for (TradeGood good : goodList.keySet()) {
         if(goodList.get(good) != null) {
             tgoods.add(good);
     }
     }
        return tgoods;
    }
    
}
