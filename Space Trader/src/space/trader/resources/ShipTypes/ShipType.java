
package space.trader.resources.ShipTypes;

/**
 *
 * @author Weiyu
 */
public abstract class ShipType {
    protected String name;
    protected int cargoBay;
    protected int weaponSlot;
    protected int shieldSlot;
    protected int gadgetSlot;
    protected int crew;
    protected int fuel;
    protected int minTechLevel;
    protected int fuelCost;
    protected int price;
    protected int repairCost;
    protected int bounty;
    protected int occurence;
    protected int hullStrength;
    public ShipType(String n, int c, int ws, int ss, int gs, int cr, int f, int mt, int fc, int p, int rc, int b, int o, int hs) {
        name = n;
        cargoBay = c;
        weaponSlot = ws;
        shieldSlot = ss;
        gadgetSlot = gs;
        crew = cr;
        fuel = f;
        minTechLevel = mt;
        fuelCost = fc;
        price = p;
        repairCost = rc;
        bounty = b;
        occurence = o;
        hullStrength = hs;
    }
    public String getName() {
        return name;
    }
    public int getCargoSize() {
        return cargoBay;
    }
    public int getWeaponSlot() {
        return weaponSlot;
    }
    public int getShieldSlot() {
        return shieldSlot;
    }
    public int getGadgetSlot() {
        return gadgetSlot;
    }
    public int getCrew() {
        return crew;
    }
    public int getFuel() {
        return fuel;
    }
    public int getMinTech() {
        return minTechLevel;
    }
    public int getFuelCost() {
        return fuelCost;
    }
    public int getPrice() {
        return price;
    }
    public int getRepairCost() {
        return repairCost;
    }
    public int getBounty() {
        return bounty;
    }
    public int getOccurence() {
        return occurence;
    }
    public int getHullStrength() {
        return hullStrength;
    }
    
   
    
}
