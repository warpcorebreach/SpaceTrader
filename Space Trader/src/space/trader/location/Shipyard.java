package space.trader.location;
import java.util.ArrayList;
import space.trader.gameplay.Ship;
import space.trader.gameplay.Player;
import space.trader.resources.*;


/**
 * Represent a ship yard for player to buy and sell ship
 * @author trananhduc1004
 */
public class Shipyard {
    private SolarSystem sys;
    ArrayList<ShipType> shipList;
    ArrayList<ShipType> shipsAvailable;
    /**
     * Constructor to initialize the ship yard
     * Add all the types of ship into the shipList
     */
    public Shipyard(SolarSystem sys) {
        this.sys = sys;
        shipList.add(new BumbleBee());
        shipList.add(new Firefly());
        shipList.add(new Flea());
        shipList.add(new Gnat());
        shipList.add(new Mosquito());
        int techLevel = sys.getTechLevel().getTechNum();
        // Add only ships with smaller tech level
        for (ShipType ship: shipList) {
            if (ship.getMinTech() <= techLevel) {
                shipsAvailable.add(ship);
            }
        }
    }
     /**
     * @return A string representation of the Shipyard.
     */
    public String toString() {
        String out = "";
        out += sys.getName() + "\n";
        for (ShipType ship : shipsAvailable) {
            out += ship.getName() + "\n";
            out += "Price: " + ship.getPrice();
            out += "Fuel price " + ship.getFuelCost();
            out += "Repair " + ship.getRepairCost() + "\n";
            out += "Cargo " + ship.getCargoSize();
            out += "Weapon " + ship.getWeaponSlot();
            out += "Shield " + ship.getShieldSlot();
            out += "Gadget " + ship.getGadgetSlot();
            out += "Crew " + ship.getCrew() + "\n";
            out += "Bounty" + ship.getBounty();
            out += "Occurrence" + ship.getOccurence();
            out += "Hull strengh" + ship.getHullStrength();           
        }
        return out;
    }
}
