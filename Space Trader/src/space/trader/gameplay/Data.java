/**
 *
 * This class represents the model in the MVC.
 *
 * It holds the data in one place (singleton model) so that the controllers
 * can access data from other controllers.
 */

package space.trader.gameplay;

import space.trader.location.Market;
import space.trader.location.Shipyard;
import space.trader.location.SolarSystem;
import space.trader.location.Universe;

/**
 * @author JD Arthur.
 */
public class Data {
    /**.
     * The current data instance of the game
     */
    private static Data instance = new Data();
    /**.
     * The current player instance of the game
     */
    private static Player currentPlayer;
    /**.
     * The current solar system instance of the game
     */
    private static SolarSystem solarSys;
    /**.
     * The current universe instance of the game
     */
    private static Universe universe;
    /**.
     * The current market instance of the game
     */
    private static Market mar;
    /**.
     * The current shipyard instance of the game
     */
    private static Shipyard shipyard;
    /**.
     * This returns a static instance of this class so the data remains
     * constant no matter which controller is accessing it.
     * @return Data a static instance of this class
     */
    public static Data getInstance() {
        return instance;
    }
     /**.
     * Setter method for the Data object
     * @param in the data instance to set as current
     */
    public static void setInstance(Data in) {
        instance = in;
    }
    /**.
     * Setter method for the Universe object
     * @param u the universe to set as current
     */
    public static void setUniverse(Universe u) {
        universe = u;
    }
    /**.
     * Getter method for the universe
     * @return the universe of the game
     */
    public static Universe getUniverse() {
        return universe;
    }

    /**.
     * Getter method for the Player object
     * @return the player who is currently playing
     */
    public static Player getPlayer() {
        return currentPlayer;
    }

    /**.
     * Setter method for the Player object
     * @param p the player to set as current player
     */
    public static void setPlayer(Player p) {
        currentPlayer = p;
    }


    /**.
     * Getter method for the current solarsystem
     * @return the solar system you are currently in
     */
    public static SolarSystem getSolarSystem() {
        return solarSys;
    }

    /**.
     * setter method for the current solar system
     * @param s the solarsystem you want to set as the current one
     */
    public static void setSolarSystem(SolarSystem s) {
        solarSys = s;
    }

    /**.
     * Setter method for the current market
     * @param m the market that you want to set as current
     */
    public static void setMarket(Market m) {
        mar = m;
    }

    /**.
     * Getter method for the current market
     * @return the market the player is currently at
     */
    public static Market getMarket() {
        return mar;
    }

    /**.
     * Setter method for the current shipyard
     * @param s the shipyard that you want to set as current
     */
    public static void setShipyard(Shipyard s) {
        shipyard = s;
    }

    /**.
     * Getter method for the current shipyard
     * @return the shipyard the player is currently at
     */
    public static Shipyard getShipyard() {
        return shipyard;
    }

}