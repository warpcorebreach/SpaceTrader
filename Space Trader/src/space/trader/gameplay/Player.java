
package space.trader.gameplay;

/**
 *
 * @author Weiyu
 */
public class Player {
    private String name;
    private int pilot, fighter, trader, engineer, investor, cash;
    private Ship s;
    
    
    public Player(String name, int p, int f, int t, int e, int i) {
        pilot = p;
        fighter = f;
        this.name = name;
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
        return name+","+pilot+","+fighter+","+trader+","+engineer+","+investor
                +","+cash;
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
    
    public void setShip(Ship s) {
        this.s = s;
    }
}

