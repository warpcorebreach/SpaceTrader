/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package space.trader;
import space.trader.items.*;
import java.util.HashMap;

/**
 *
 * @author Weiyu
 */
public class Ship {
    
    private int size, fuel, x, y;
    // Ship's cargo is represented by a Map from the name of a good to its
    // quantity in the cargo
    private HashMap<String, Integer> cargo;
    
    
    public Ship() {
        size = 0;
        fuel = 15;
        cargo = new HashMap<>();
    }
    
    
    /**
     * Add a TradeGood to the Ship's cargo.
     * Returns true if cargo was successfully added, false otherwise
     * 
     * @param good The TradeGood to add
     * @return true if the good was added, false if cargo is full
     */
    public boolean addCargo(TradeGood good) {
        if (size < 20) {
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

    public void setX(int x) {
        this.x = x;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return x;
    }

}
