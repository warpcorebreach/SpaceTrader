/**
 * 
 * This class represents the model in the MVC.
 * 
 * It holds the data in one place (singleton model) so that the controllers 
 * can access data from other controllers. 
 */

package space.trader;

/**
 *
 * @author JD Arthur
 */
public class Data {
    public static Data instance = new Data();
    
    /**
     * This returns a static instance of this class so the data remains 
     * constant no matter which controller is accessing it.
     * @return Data a static instance of this class
     */
    public static Data getInstance() {
        return instance;
    }
    
    private static Player currentPlayer;
    public static Player getPlayer() {
        return currentPlayer;
    }
    public static void setPlayer(Player p) {
        currentPlayer = p;
    }
    
    private static SolarSystem solarSys;
    public static SolarSystem getSolarSystem() {
        return solarSys;
    }
    public static void setSolarSystem(SolarSystem s) {
        solarSys = s;
    }
}
