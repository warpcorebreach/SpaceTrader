package space.trader.location;

import java.util.ArrayList;
import space.trader.resources.Equipment.Shield;
import space.trader.resources.Equipment.Weapon;
import space.trader.resources.ShipTypes.BumbleBee;
import space.trader.resources.ShipTypes.Firefly;
import space.trader.resources.ShipTypes.Flea;
import space.trader.resources.ShipTypes.Gnat;
import space.trader.resources.ShipTypes.Mosquito;
import space.trader.resources.ShipTypes.ShipType;


/**
 * Represent a ship yard for player to buy and sell ship
 * @author trananhduc1004
 */
public class Shipyard {
    private SolarSystem sys;
    private ArrayList<ShipType> shipList = new ArrayList();
    private ArrayList<ShipType> shipsAvailable = new ArrayList();
    private ArrayList<Weapon> weaponList = new ArrayList();
    private ArrayList<Shield> shieldList = new ArrayList();
    private ArrayList<Shield> shieldAvailable = new ArrayList();
    private ArrayList<Weapon> weaponAvailable = new ArrayList();
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
        weaponList.add(new Weapon("Pulse Laser"));
        weaponList.add(new Weapon("Beam Laser"));
        weaponList.add(new Weapon("Military Laser"));
        weaponList.add(new Weapon("Super Laser"));
        shieldList.add(new Shield("Energy Shield"));
        shieldList.add(new Shield("Reflective Shield"));
        int techLevel = this.sys.getTechLevel().getTechNum();
        // Add only ships with smaller tech level
        if (techLevel >= 4) {
            for (ShipType ship: shipList) {
                if (ship.getMinTech() <= techLevel) {
                    shipsAvailable.add(ship);
                }
            }
            weaponAvailable.add(weaponList.get(0));
        }
        if (techLevel >= 5 ) {
            weaponAvailable.add(weaponList.get(1));
        }
        if (techLevel >= 6 ) {
            weaponAvailable.add(weaponList.get(2));
            shieldAvailable.add(shieldList.get(0));
        }
        if (techLevel >= 7 ) {
            weaponAvailable.add(weaponList.get(3));
            shieldAvailable.add(shieldList.get(1));
        }
        
    }
    
    public ArrayList<ShipType> getShips() {
        return shipsAvailable;
    }
    public ArrayList<Weapon> getWeapons() {
        return weaponAvailable;
    }
    public ArrayList<Shield> getShields() {
        return shieldAvailable;
    }
     /**
     * @return A string representation of the Shipyard.
     */
    @Override
    public String toString() {
        String out = "";
        out += sys.getName() + "   " +  sys.getTechLevel().getTechNum() + "\n";
        for (ShipType ship : shipsAvailable) {
            out += ship.getName() + " MIn Tech Level: " + ship.getMinTech() + "\n";
            out += "Price: " + ship.getPrice();
            out += " Fuel price " + ship.getFuelCost();
            out += " Repair " + ship.getRepairCost() + "\n";
            out += "Cargo " + ship.getCargoSize();
            out += " Weapon " + ship.getWeaponSlot();
            out += " Shield " + ship.getShieldSlot();
            out += " Gadget " + ship.getGadgetSlot();
            out += " Crew " + ship.getCrew() + "\n";
            out += "Bounty " + ship.getBounty();
            out += " Occurrence " + ship.getOccurence();
            out += " Hull strengh " + ship.getHullStrength() + "\n";
        }
        return out;
    }
}
