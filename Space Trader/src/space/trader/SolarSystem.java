/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space.trader;

import java.util.HashMap;


/**
 * A class representing a solar system in the universe
 * @author Duc Tran
 */

public class SolarSystem {
    
    private SystemStats.Name name;
    private SystemStats.TechLevel techLevel;
    private SystemStats.Resources resources;
    private int x, y;
    private Market market;
    /**
     * Constructor of a solar system
     */
    public SolarSystem(SystemStats.Name name, int x, int y, SystemStats.TechLevel techLevel,
            SystemStats.Resources resources) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.techLevel = techLevel;
        this.resources = resources;
    }
    
    public void makeMarket() {
        market = new Market(this);
        Data.setMarket(market);
    }
    
    /**
     * Create getter for each data in the object
     */
    /**
     * Return the name
     * @return: name
     */
    
    public SystemStats.Name getName() {
        return name;
    }
    /**
     * Return the horizontal location
     * @return : x
     */
    public int getX() {
        return x;
    }
    /**
     * Return the vertical location
     * @return : y
     */
    public int getY() {
        return y;
    }
    /**
     * Return the techLevel
     * @return : techLevel
     */
    public SystemStats.TechLevel getTechLevel() {
        return techLevel;
    }
    /**
     * Return the available resources
     * @return : resources
     */
    public SystemStats.Resources getResources() {
        return resources;
    }
    
    public Market getMarket() {
        return market;
    }
}
