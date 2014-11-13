
package space.trader.gameplay;

/**
 *
 * @author Weiyu
 */
public class Player {
    /**
     * Player's name.
     */
    private final String name;
    /**
     * Player's pilot skill points.
     */
    private final int pilot;
    /**
     * Player's fighter skill points.
     */
    private final int fighter;
    /**
     * Player's trader skill points.
     */
    private final int trader;
    /**
     * Player's engineer skill points.
     */
    private final int engineer;
    /**
     * Player's investor skill points.
     */
    private final int investor;
    /**
     * Player's cash skill points.
     */
    private int cash;
    /**
     * Player's current Ship.
     */
    private Ship s;

    /**
     * Initializes the current player.
     *
     * @param pname player's name
     * @param p pilot skill points
     * @param f fighter skill points
     * @param t trader skill points
     * @param e engineer skill points
     * @param i investor skill points
     */
    public Player(String pname, int p, int f, int t, int e, int i) {
        pilot = p;
        fighter = f;
        name = pname;
        trader = t;
        engineer = e;
        investor = i;
        cash = 10000;
        s = new Ship();
    }

    /**
     * Produces a comma separated string of data needed to restore the current
     * Player at a later time.
     * @return A string containing the relevant data.
     */
    public String save() {
        return name + "," + pilot + "," + fighter + "," + trader + ","
                + engineer + "," + investor + "," + cash;
    }

    public int getPilot() {
        return pilot;
    }
    public int getFighter() {
        return fighter;
    }
    public int getTrader() {
        return trader;
    }
    public int getEngineer() {
        return engineer;
    }
    public int getInvestor() {
        return investor;
    }
    public String getName() {
        return name;
    }
    public int getCash() {
        return cash;
    }
    public void setCash(int c) {
        cash = c;
    }
    public Ship getShip() {
        return s;
    }

    public void setShip(Ship ps) {
        s = ps;
    }
}

