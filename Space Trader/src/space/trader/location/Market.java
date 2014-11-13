
package space.trader.location;

import java.util.ArrayList;
import java.util.Random;
import space.trader.resources.TradeGoods.Firearms;
import space.trader.resources.TradeGoods.Food;
import space.trader.resources.TradeGoods.Furs;
import space.trader.resources.TradeGoods.Games;
import space.trader.resources.TradeGoods.Machines;
import space.trader.resources.TradeGoods.Medicine;
import space.trader.resources.TradeGoods.Narcotics;
import space.trader.resources.TradeGoods.Ore;
import space.trader.resources.TradeGoods.Robots;
import space.trader.resources.TradeGoods.TradeGood;
import space.trader.resources.TradeGoods.Water;

/**
 * Represents a Marketplace where goods can be bought and sold.
 *
 * @author Justin
 */
public class Market {
    /**
     * Current SolarSystem.
     */
    private final SolarSystem sys;

    /**
     * Max value for randomly generated Good quantity.
     */
    private static final int RAND_MAX = 15;

    /**
     * Constant used to do coin-toss calculation for determining variance in
     * Good price.
     */
    private static final double RAND_MAX_DOUBLE = 0.5;

    // full set of goods available to any Market
    private final Water water;
    private final Furs furs;
    private final Food food;
    private final Ore ore;
    private final Games games;
    private final Firearms arms;
    private final Medicine meds;
    private final Machines machines;
    private final Narcotics narcs;
    private final Robots bots;

    private final ArrayList<TradeGood> goods;
    private final ArrayList<TradeGood> goodsAvailable;

    /**
     * Takes in a SolarSystem object and instantiates TradeGood objects.
     *
     * @param psys The location of the Market
     */
    public Market(SolarSystem psys) {
        this.sys = psys;

        furs = new Furs();
        water = new Water();
        food = new Food();
        ore = new Ore();
        games = new Games();
        arms = new Firearms();
        meds = new Medicine();
        machines = new Machines();
        narcs = new Narcotics();
        bots = new Robots();

        goodsAvailable = new ArrayList<>();
        goods = new ArrayList<>();
        goods.add(water);
        goods.add(furs);
        goods.add(food);
        goods.add(ore);
        goods.add(games);
        goods.add(arms);
        goods.add(meds);
        goods.add(machines);
        goods.add(narcs);
        goods.add(bots);

        generateGoods();
        generatePrices();
    }

    /**
     * Determine which goods are available in the current System by comparing.
     * its TechLevel to the good's MTLP.
     */
    private void generateGoods() {
        Random r = new Random();

        for (TradeGood g : goods) {
            if (sys.getTechLevel().getTechNum() >= g.getMTLP()) {
                goodsAvailable.add(g);
                g.setQuantity(r.nextInt(RAND_MAX));
            }
        }
    }

    /**
     * Generate prices for goods available in the current System.
     */
    private void generatePrices() {
        for (TradeGood good : goodsAvailable) {
            good.setPrice(getPrice(good));
        }
    }

    /**
     * Takes in a TradeGood and returns its randomly generated price on the
     * current System, according to the formula:
     * (the base price) + (the IPL * (Planet Tech Level - MTLP)) + (variance)
     *
     * @param good The TradeGood to calculate the price for
     * @return The good's price in the System
     */
    private int getPrice(TradeGood good) {
        Random r = new Random();
        int var = r.nextInt(good.getVar());
        if (r.nextDouble() > RAND_MAX_DOUBLE) {
            var = -var;
        }
        int price = good.getBasePrice()
                + good.getIPL() * (sys.getTechLevel().getTechNum()
                - good.getMTLP()) + var;
        return price;
    }

    /**
     * @return A string representation of the Market.
     */
    /*public String toString() {
        String out = "";
        out += sys.getName() + "\n";
        for (TradeGood good : goodsAvailable) {
            out += good.getName() + "\n";
            out += "Price: " + good.getPrice() + "\n";
            out += "Availability: " + good.getQuantity() + "\n" + "\n";
        }
        return out;
    }*/

    /**
     * @return An ArrayList of the available goods in the System
     */
    public ArrayList<TradeGood> getGoods() {
        return goodsAvailable;
    }

}
