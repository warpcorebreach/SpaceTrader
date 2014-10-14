/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space.trader.location;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import space.trader.gameplay.Data;


/**
 * A class representing a solar system in the universe
 * @author Duc Tran
 */

public class SolarSystem {
    
    private final SystemStats.Name name;
    private final SystemStats.TechLevel techLevel;
    
    private SystemStats.Resources resources;
    private int x, y, fuelCost;
    private Market market;
    private SimpleStringProperty coords;
    
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
        
        coords = new SimpleStringProperty();
        coords.setValue(x + "," + y);
    }
    
    /**
     * Set the fuel cost to get to this system from the current one
     */
    public void setFuelCost(int c) {
        fuelCost = c;
    }
    
    public int getFuelCost() {
        return fuelCost;
    }
    
    /**
     * Generates the market for this SolarSystem
     */
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
    
    public StringProperty coordsProperty() {
        return coords;
    }
    
    public String toString() {
        return ""+name;
    }
}
