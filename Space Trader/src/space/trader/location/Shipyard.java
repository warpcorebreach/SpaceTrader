package space.trader.location;

import java.util.ArrayList;
import java.util.List;
import space.trader.resources.Equipment.Shield;
import space.trader.resources.Equipment.Weapon;
import space.trader.resources.ShipTypes.BumbleBee;
import space.trader.resources.ShipTypes.Firefly;
import space.trader.resources.ShipTypes.Flea;
import space.trader.resources.ShipTypes.Gnat;
import space.trader.resources.ShipTypes.Mosquito;
import space.trader.resources.ShipTypes.ShipType;


/**
 * Represent a ship yard for player to buy and sell ship.
 * @author trananhduc1004
 */
public class Shipyard {
    private final SolarSystem sys;
    private final List<ShipType> shipList = new ArrayList();
    private final List<Weapon> weaponList = new ArrayList();
    private final List<Shield> shieldList = new ArrayList();

    /**
     * List of Ships available to purchase at the Shipyard.
     */
    private final List<ShipType> shipsAvailable = new ArrayList();
    /**
     * List of Shields available to purchase at the Shipyard.
     */
    private final List<Shield> shieldAvailable = new ArrayList();
    /**
     * List of Weapons available to purchase at the Shipyard.
     */
    private final List<Weapon> weaponAvailable = new ArrayList();

    /**
     * Constructor to initialize the ship yard.
     * Add all the types of ship into the shipList
     * @param pSys the current SolarSystem the Player is at
     */
    public Shipyard(SolarSystem pSys) {
        this.sys = pSys;
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

    public List<ShipType> getShips() {
        return shipsAvailable;
    }
    public List<Weapon> getWeapons() {
        return weaponAvailable;
    }
    public List<Shield> getShields() {
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
            out += ship.getName() + " MIn Tech Level: " + ship.getMinTech()
                    + "\n";
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
