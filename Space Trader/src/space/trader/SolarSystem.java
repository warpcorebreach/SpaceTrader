/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space.trader;

/**
 * A class representing a solar system in the universe
 * @author Duc Tran
 */

public class SolarSystem {
    /**
     * An enum to represent the available resources characteristic of the planet
     */
    public enum Resources {
    NOSPECIALRESOURCES,  MINERALRICH, MINERALPOOR, DESERT,
    LOTSOFWATER, RICHSOIL, POORSOIL, RICHFAUNA, LIFELESS,
    WEIRDMUSHROOMS, LOTSOFHERBS, ARTISTIC, WARLIKE
}
    /**
     * An enum to represent the available resources characteristic of the planet
     */
    public enum TechLevel {
         PRE_AGRICULTURE, AGRICULTURE, MEDIEVAL, RENAISSANCE,
         EARLY_INDUSTRIAL, INDUSTRIAL, POST_INDUSTRIAL, HI_TECH
    }
    private String name;
    private int x, y;
    private TechLevel techLevel;
    private Resources resources;
    /**
     * Create getter for each data in the object
     */
    public String getName() {
        return name;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public TechLevel getTechLevel() {
        return techLevel;
    }
    public Resources getResources() {
        return resources;
    }
}
