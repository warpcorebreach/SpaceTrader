
package space.trader.location;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import space.trader.gameplay.Data;


/** Solar System class.
 * A class representing a solar system in the universe
 * @author Duc Tran
 */

public class SolarSystem {

    private String name;
    private SystemStats.TechLevel techLevel;
    private SystemStats.Resources resources;
    private int x;
    private int y;
    private int fuelCost;
    private Market market;
    private Shipyard shipyard;
    private SimpleStringProperty coords;
    private SimpleStringProperty nameProp;

    /** Solar System constructor.
     * Constructor of a solar system
     * @param nAme name of planet
     * @param xcord x cord of planet
     * @param ycord y cord of planet
     * @param techlevel tech level of planet
     * @param rEsources resources of planet
     */
    public SolarSystem(final String  nAme, final int xcord, final int ycord,
            final SystemStats.TechLevel techlevel,
            final SystemStats.Resources rEsources) {
        name = nAme;
        x = xcord;
        y = ycord;
        techLevel = techlevel;
        resources = rEsources;
        coords = new SimpleStringProperty();
        coords.setValue(x + "," + y);
        nameProp = new SimpleStringProperty();
        nameProp.setValue(name);
    }

    /**
     * Produces a comma separated string of data needed to restore the current
     * SolarSystem at a later time.
     * @return A string containing the relevant data.
     */
    public String save() {
        return name + "," + techLevel.toString() + ","
                + resources.toString() + ","
                 + x + "," + y + "," + fuelCost;
    }

    public void setTechLevel(SystemStats.TechLevel t) {
        techLevel = t;
    }

    public void setResources(SystemStats.Resources r) {
        resources = r;
    }

    /** setFuel Method.
     * Set the fuel cost to get to this system from the current one
     * @param c fuel cost of planet
     */
    public void setFuelCost(int c) {
        fuelCost = c;
    }

    public int getFuelCost() {
        return fuelCost;
    }

    public void setX(int x1) {
        this.x = x1;
    }

    public void setY(int y1) {
        this.y = y1;
    }

    /** Market for solarSystem.
     * Generates the market for this SolarSystem
     */
    public void makeMarket() {
        market = new Market(this);
        Data.setMarket(market);
    }
    /** Create ShipYard for solarSystem.
     * set a new shipYard in data as well
     */
    public void makeShipyard() {
        shipyard = new Shipyard(this);
        Data.setShipyard(shipyard);
    }

    /**
     * Create getter for each data in the object
     */
    /** name getter.
     * Return the name
     * @return name
     */
    public String getName() {
        return name;
    }
    /**
     * Return the horizontal location.
     * @return  x
     */
    public int getX() {
        return x;
    }
    /** Y cord.
     * Return the vertical location
     * @return : y
     */
    public int getY() {
        return y;
    }
    /** techlevel getter.
     * Return the techLevel
     * @return : techLevel
     */
    public SystemStats.TechLevel getTechLevel() {
        return techLevel;
    }
    /** resource getter.
     * Return the available resources
     * @return : resources
     */
    public SystemStats.Resources getResources() {
        return resources;
    }

    public Market getMarket() {
        return market;
    }
    public Shipyard getShipyard() {
        return shipyard;
    }

    public StringProperty coordsProperty() {
        return coords;
    }
    public StringProperty nameProperty() {
        return nameProp;
    }
    public void setName(String s) {
        name = s;
    }
    @Override
    public String toString() {
        return "" + name;
    }
}
