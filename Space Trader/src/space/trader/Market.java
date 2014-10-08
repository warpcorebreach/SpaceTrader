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
    private SolarSystem sys;
    
    // maps a TradeGood to its available stock on the planet
    private HashMap<TradeGood, Integer> goodList;
    // maps a TradeGood to its price on the planet
    private HashMap<TradeGood, Integer> goodPrices;
    
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
    
    private ArrayList<TradeGood> goods;
    private ArrayList<TradeGood> goodsAvailable;
    
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
        
        furs = new Furs();
        water = new Water();
        food = new Food();
        ore = new Ore();
        games = new Games();
        arms = new Firearms();
        meds = new Medicine();
        machines = new Machines();
        narcs = new Narcotics();
        bots = new Robots();
        
        goodsAvailable = new ArrayList<>();
        goods = new ArrayList<>();
        goods.add(water);
        goods.add(furs);
        goods.add(food);
        goods.add(ore);
        goods.add(games);
        goods.add(arms);
        goods.add(meds);
        goods.add(machines);
        goods.add(narcs);
        goods.add(bots);
        
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
        
        for (TradeGood g : goods) {
            if (sys.getTechLevel().getTechNum() >= g.getMTLP()) {
                goodsAvailable.add(g);
                g.setQuantity(10);
            }
        }
    }
    
    /**
     * Generate prices for goods available in the current System
     */
    private void generatePrices() {
        for (TradeGood good : goodsAvailable) {
            good.setPrice(getPrice(good));
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
        for (TradeGood good : goodsAvailable) {
            out += good.getName() + "\n";
            out += "Price: " + good.getPrice() + "\n";
            out += "Availability: " + good.getQuantity() + "\n" + "\n";
        }
        return out;
    }
    
    /**
     * @return An ArrayList of the available goods in the System
     */
    public ArrayList<TradeGood> getGoods() {
        return goodsAvailable;
    }

    /**
     * @param good The good to get the price of
     * @return The price of the inputted good
     */
    public int getGoodPrice(TradeGood good) {
        return good.getPrice();
    }
    
    /**
     * @param good The good to get the quantity of
     * @return The quantity available of the inputted good
     */
    public int getGoodQuantity(TradeGood good) {
        return good.getQuantity();
    }
    
}
