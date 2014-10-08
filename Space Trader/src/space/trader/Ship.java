/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package space.trader;
import space.trader.items.*;
import java.util.ArrayList;

/**
 *
 * @author Weiyu
 */
public class Ship {
    private ArrayList<TradeGood> cargo;
    private int fuelLevel;
    public Ship() {
        cargo = new ArrayList<>();
        fuelLevel = 15;
    }
    public ArrayList<TradeGood> getCargo() {
        return cargo;
    }
    public void setCargo(ArrayList<TradeGood> c) {
        cargo = c;
    }
    public ArrayList<String> getCargoName() {
        ArrayList<String> cargonames = new ArrayList<>();
        for(int i = 0; i<cargo.size();i++) {
            if(cargo.get(i) != null) {
                cargonames.add(cargo.get(i).getName());
    }
        }
            return cargonames;
    }
    public int getFuel() {
        return fuelLevel;
    }
}
