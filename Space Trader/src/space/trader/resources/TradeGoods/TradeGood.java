
package space.trader.resources.TradeGoods;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import space.trader.location.SystemStats.Resources;

/**
 * Represents a generic TradeGood object.
 * Contains all the fields and methods a TradeGood should have
 *
 * @author Justin
 */
public abstract class TradeGood {
    protected final int mtlp;
    protected final int mtlu;
    protected final int ttp;
    protected final int basePrice;
    protected final int ipl;
    protected final int var;
    protected final Resources cr;
    protected final Resources er;
    protected final String name;
    protected int price;
    protected int quant;
    protected SimpleIntegerProperty pprop;
    protected SimpleIntegerProperty qprop;
    /** TradeGoods for trading.
     * create a trade good depending on inputs
     * @param mtlp1 min tech level to produce
     * @param mtlu1 min tech level to use
     * @param ttp1 tech level that produces most of the items
     * @param basePrice1 base price of good
     * @param ipl1 price increase per tech level
     * @param var1 percent that can vary for base price
     * @param cr1 price is low condition
     * @param er1 price is high condition
     * @param name1 name of the good
     */
    public TradeGood(int mtlp1, int mtlu1, int ttp1, int basePrice1,
            int ipl1, int var1,
                Resources cr1, Resources er1, String name1) {
        mtlp = mtlp1;   // min tech level to produce
        mtlu = mtlu1;   // min tech level for system to use
        ttp = ttp1;
        basePrice = basePrice1;
        ipl = ipl1;
        var = var1;
        cr = cr1;
        er = er1;
        name = name1;
        price = quant = 0;
        pprop = new SimpleIntegerProperty();
        qprop = new SimpleIntegerProperty();
    }
    /**Getter for MTLP.
     *
     * @return The good's MTLP
     */
    public int getMTLP() {
        return mtlp;
    }
    /**Getter for MTLU.
     *
     * @return The good's MTLU
     */
    public int getMTLU() {
        return mtlu;
    }

    /** Getter for TTP.
     *
     * @return The good's TTP
     */
    public int getTTP() {
        return ttp;
    }

    /** Getter for basePrice.
     *
     * @return The good's basePrice
     */
    public int getBasePrice() {
        return basePrice;
    }

    /** Getter for IPL.
     *
     * @return The good's IPL
     */
    public int getIPL() {
        return ipl;
    }

    /** Getter for variance.
     *
     * @return The good's variance
     */
    public int getVar() {
        return var;
    }
    /** Getter for CR.
     *
     * @return The good's CR
     */
    public Resources getCR() {
        return cr;
    }

    /** Getter for ER.
     *
     * @return The good's ER
     */
    public Resources getER() {
        return er;
    }

    /** Getter for name.
     *
     * @return The good's name
     */
    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quant;
    }

    public void setPrice(int p) {
        price = p;
        pprop.setValue(price);
    }

    public void setQuantity(int q) {
        quant = q;
        qprop.setValue(quant);
    }

    public final IntegerProperty priceProperty() {
        return pprop;
    }

    public final IntegerProperty quantProperty() {
        return qprop;
    }
}
