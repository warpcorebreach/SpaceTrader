/**
 * 
 * This class represents the model in the MVC.
 * 
 * It holds the data in one place (singleton model) so that the controllers 
 * can access data from other controllers. 
 */

package space.trader.gameplay;

import space.trader.location.Market;
import space.trader.location.SolarSystem;
import space.trader.location.Universe;

/**
 *
 * @author JD Arthur
 */
public class Data {
    private static Data instance = new Data();
    private static Player currentPlayer;
    private static SolarSystem solarSys;
    private static Universe universe;
    private static Market mar;
    
    /**
     * This returns a static instance of this class so the data remains 
     * constant no matter which controller is accessing it.
     * @return Data a static instance of this class
     */
    public static Data getInstance() {
        return instance;
    }
    
    public static void setInstance(Data in) {
        instance = in;
    }
    
    public static void setUniverse(Universe u) {
        universe = u;
    }
    
    public static Universe getUniverse() {
        return universe;
    }
    
    /**
     * Getter method for the Player object
     * @return the player who is currently playing
     */
    public static Player getPlayer() {
        return currentPlayer;
    }
    
    /**
     * Setter method for the Player object
     * @param p the player to set as current player
     */
    public static void setPlayer(Player p) {
        currentPlayer = p;
    }
    
    
    /**
     * Getter method for the current solarystem
     * @return the solar system you are currently in
     */
    public static SolarSystem getSolarSystem() {
        return solarSys;
    }
    
    /**
     * setter method for the current solar system
     * @param s the solarsystem you want to set as the current one
     */
    public static void setSolarSystem(SolarSystem s) {
        solarSys = s;
    }
    
    /**
     * Setter method for the current market
     * @param m the market that you want to set as current
     */
    public static void setMarket(Market m) {
        mar = m;
    }
    
    /**
     * Getter method for the current market
     * @return the market the player is currently at
     */
    public static Market getMarket() {
        return mar;
    }
    

}
