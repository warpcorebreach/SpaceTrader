/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space.trader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.ArrayList;
import java.util.Random;


/**
 * A class representing a solar system in the universe
 * @author Duc Tran
 */

public class SolarSystem {
    /**
     * An enum to represent available names for the planet
     */
    public static enum Name {
        ACAMAR,ADAHN, ALDEA, ANDEVIAN,ANTEDI,
        BALOSNEE, BARATAS,BRAX, BRETEL,	BOB_WATER,
        CALONDIA, CAMPOR, CAPELLE, CARZON, CASTOR, CESTUS, CHERON, COURTENEY,
        DALED, DAMAST, DAVLOS, DENEB, DENEVA, DEVIDIA, DRAYLON, DUC_TRAN, DREMA,
        ENDOR, ESMEE, EXO, FERRIS, FESTEN, FOURMI, FROLIX, GEMULON, GUINIFER,
        HADES, HAMLET, HELENA, HULST, IODINE, IRALIUS,
        JANUS, JAPORI, JARADA, JASON, JUSTIN_COATES, JD_ARTHUR,
        KAYLON, KHEFKA, KIRA, KLAATU, KLAESTRON, KORMA, KRAVAT, KRIOS,
        LAERTES, LARGO, LAVE, LIGON, LOWRY,
        MAGRAT, MALCORIA, MELINA, MENTAR, MERIK, MINTAKA, MORDAN, MYRTHE,
        NELVANA, NIX, NYLE, ODET, OG, OMEGA, OMPHALOS, ORIAS, OTHELLO, 
        PARADE, PENTHARA, PICARD, POLLUX, QUATOR, QIFENG_LI,
        RAKHAR, RAN, REGULAS, RELVA, RHYMUS, ROCHANI, RUBICUM, RUTIA,
        SARPEIDON, SEFALLA, SELTRICE, SIGMA, SOL, SOMARI, STAKORON, STYRIS,
        TALANI, TAMUS, TANTALOS, TANUGA, TARCHANNEN, TEROSA, THERA, TITAN,
        TORIN, TRIACUS, TURKANA, TYRUS, UMBERLEE, UTOPIA, WEIYU_LI,
        VADERA, VAGRA, VANDOR, VENTAX, XENON, XERXES, YEW, YOJIMBO, ZALKON
    }
    /**
     * An enum to represent the available resources characteristic of the planet
     */
    public static enum Resources {
    NOSPECIALRESOURCES,  MINERALRICH, MINERALPOOR, DESERT,
    LOTSOFWATER, RICHSOIL, POORSOIL, RICHFAUNA, LIFELESS,
    WEIRDMUSHROOMS, LOTSOFHERBS, ARTISTIC, WARLIKE
}
    /**
     * An enum to represent the available resources characteristic of the planet
     */
    public static enum TechLevel {
         PRE_AGRICULTURE, AGRICULTURE, MEDIEVAL, RENAISSANCE,
         EARLY_INDUSTRIAL, INDUSTRIAL, POST_INDUSTRIAL, HI_TECH
    }
    private Name name;
    private int x, y;
    private TechLevel techLevel;
    private Resources resources;
    /**
     * Constructor of a solar system
     */
    public SolarSystem(Name name, int x, int y, TechLevel techLevel, Resources resources) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.techLevel = techLevel;
        this.resources = resources;
        
    }
    /**
     * Create getter for each data in the object
     */
    /**
     * Return the name
     * @return: name
     */
    
    public Name getName() {
        return name;
    }
    /**
     * Return the horizontal location
     * @return : x
     */
    public int getX() {
        return x;
    }
    /**
     * Return the vertical location
     * @return : y
     */
    public int getY() {
        return y;
    }
    /**
     * Return the techLevel
     * @return : techLevel
     */
    public TechLevel getTechLevel() {
        return techLevel;
    }
    /**
     * Return the available resources
     * @return : resources
     */
    public Resources getResources() {
        return resources;
    }
    /**
     * Create a string representation for the system
     * @return: The string represent a solar system.
     */
    @Override
    public String toString() {
        return name.name() + " " + x + " " + y + " " + techLevel.name() + " "
                + resources.name();
    }
    /**
     * Generate an universe with random generated solar systems.
     * Put it as static so client can used it easier.
     */
    public static ArrayList<SolarSystem> universeGenerate() {
        // Get number of available system nam
        int numberOfName = Name.values().length;
        Random randObject = new Random();
        // Generate 2 arrayList
        ArrayList<Integer> numArray = new ArrayList();
        ArrayList<SolarSystem> universe = new ArrayList();
        // Generate each planet and add it to the array
        for (int i = 0; i < 50; i++) {
            
            // Generate a random unique universe name
            
            int nextNum = randObject.nextInt(numberOfName);
            while (numArray.contains(nextNum)) {
                nextNum = randObject.nextInt(numberOfName);
            }
            Name systemName = Name.values()[nextNum];
            // Pick tech level and resources randomly
            TechLevel systemLevel = TechLevel.values()[randObject.nextInt(8)];
            Resources systemResources = Resources.values()[randObject
                                                           .nextInt(13)];
            numArray.add(nextNum);
            universe.add(new SolarSystem(systemName, 0, 0, systemLevel,
                    systemResources));

        }
        return universe;
    }
}
