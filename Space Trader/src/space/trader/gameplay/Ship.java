
package space.trader.gameplay;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import space.trader.resources.Equipment.Shield;
import space.trader.resources.Equipment.Weapon;
import space.trader.resources.ShipTypes.Gnat;
import space.trader.resources.ShipTypes.ShipType;
import space.trader.resources.TradeGoods.TradeGood;

/**
 *
 * @author Weiyu
 */
public class Ship implements Serializable {
    private static final int INITIAL_X = 25;
    private static final int INITIAL_Y = 75;
    private int size;
    private int fuel;
    private int x;
    private int y;
    private int maxCargo;
    private ShipType type;
    private ArrayList<Weapon> weapons;
    private ArrayList<Shield> shields;
    /**
     * Ship's cargo is represented by a Map from the name of a good to its.
     * quantity in the cargo
     */
    private HashMap<String, Integer> cargo;
    /**
     * Ship constructor with default ship Gnat.
     */
    public Ship() {
        x = INITIAL_X;
        y = INITIAL_Y;
        cargo = new HashMap<>();
        type = new Gnat();
        shields = new ArrayList();
        weapons = new ArrayList();
        fuel = type.getFuel();
        //size = type.getCargoSize();
        size = 0;
        maxCargo = type.getCargoSize();
    }

    /**
     * Add a TradeGood to the Ship's cargo.
     * Returns true if cargo was successfully added, false otherwise
     *
     * @param good The TradeGood to add
     * @return true if the good was added, false if cargo is full
     */
    public boolean addCargo(TradeGood good) {
        if (size < getMaxCargoSize()) {
            Integer q = cargo.get(good.getName());
            if (q == null) {
                // add good to the map if it is not in it
                cargo.put(good.getName(), 1);
            } else {
                // increment the quantity of the given cargo item
                cargo.replace(good.getName(), ++q);
            }
            size++;
            return true;
        }
        return false;
    }
    /**
     * Attempt to remove a TradeGood from the Ship's cargo.
     * Returns: 0 if the cargo is empty
     *          -1 if the cargo does not contain the given TradeGood
     *          1 if the remove is successful
     * 
     * If removing a good would set its quantity to 0, the mapping is deleted
     * 
     * @param good The good to remove.
     * @return 0 if the cargo is empty, -1 if cargo does not contain good, 1 if
     * the remove is successful
     */
    public int removeCargo(TradeGood good) {
        if (size == 0) {
            // cargo is empty
            return 0;
        }
        Integer q = cargo.get(good.getName());
        if (q == null) {
            // cargo does not contain good
            return -1;
        } else {
            if (q == 1) {
                cargo.remove(good.getName());
            } else {
                cargo.replace(good.getName(), --q);
            }
            size--;
            return 1;
        }
    }
    public HashMap<String, Integer> getCargo() {
        return cargo;
    }
    public void setCargo(HashMap<String, Integer> c) {
        cargo = c;
    }

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int f) {
        fuel = f;
    }

    public void setX(int x1) {
        this.x = x1;
    }

    public void setY(int y1) {
        this.y = y1;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return x;
    }

    public int getCargoSize() {
        return size;
    }

    public int getMaxCargoSize() {
        return maxCargo;
    }

    public void setMaxCargoSize(int newMaxCargoSize) {
        this.maxCargo = newMaxCargoSize;
    }

    public ShipType getShipType() {
        return type;
    }

    public void setShipType(ShipType t) {
        type = t;
        fuel = t.getFuel();
    }
    
    /**
     * Add a Weapon to the ship.
     * If param is null, or ship is out of slots, it is not added
     * 
     * @param w The Weapon to add
     */
    public void addWeapon(Weapon w) {
        if (w != null) {
            if (getWeaponsSize() < getShipType().getWeaponSlot()) {
                weapons.add(w);
            }
        }
    }
    
    /**
     * Add a Shield to the ship.
     * If param is null, or ship is out of slots, it is not added
     * 
     * @param w The Shield to add
     */
    public void addShield(Shield w) {
        if (w != null) {
            if (getShieldsSize() < getShipType().getShieldSlot()) {
                shields.add(w);
            }
        }
    }
    public int getShieldsSize() {
        return shields.size();
    }
    public int getWeaponsSize() {
        return weapons.size();
    }
    public ArrayList<Shield> getShields() {
        return shields;
    }
    public ArrayList<Weapon> getWeapons() {
        return weapons;
    }
}
