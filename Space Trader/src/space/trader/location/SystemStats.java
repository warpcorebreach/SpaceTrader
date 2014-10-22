/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space.trader.location;

import java.util.HashMap;

/**
 *
 * @author Justin
 */
public class SystemStats {
    private HashMap<String, Name> names;
    
    /**
     * An enum to represent available names for the planet
     */
    public enum Name {
        ACAMAR, ADAHN, ALDEA, ANDEVIAN,ANTEDI,
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
        PARADE, PENTHARA, PICARD, POLLUX, QUATOR,
        RAKHAR, RAN, REGULAS, RELVA, RHYMUS, ROCHANI, RUBICUM, RUTIA,
        SARPEIDON, SEFALLA, SELTRICE, SIGMA, SOL, SOMARI, STAKORON, STYRIS,
        TALANI, TAMUS, TANTALOS, TANUGA, TARCHANNEN, TEROSA, THERA, TITAN,
        TORIN, TRIACUS, TURKANA, TYRUS, UMBERLEE, UTOPIA, WEIYU_LI,
        VADERA, VAGRA, VANDOR, VENTAX, XENON, XERXES, YEW, YOJIMBO, ZALKON
    }
    
    /**
     * An enum to represent the available resources characteristic of the planet
     */
    public enum Resources {
    NOSPECIALRESOURCES, MINERALRICH, MINERALPOOR, DESERT,
    LOTSOFWATER, RICHSOIL, POORSOIL, RICHFAUNA, LIFELESS,
    WEIRDMUSHROOMS, LOTSOFHERBS, ARTISTIC, WARLIKE
}
    /**
     * An enum to represent the available resources characteristic of the planet
     */
    public enum TechLevel {
         PRE_AGRICULTURE (0),
         AGRICULTURE (1),
         MEDIEVAL (2),
         RENAISSANCE (3),
         EARLY_INDUSTRIAL (4),
         INDUSTRIAL (5),
         POST_INDUSTRIAL (6),
         HI_TECH (7);
         
         private final int techNumber;
         
         TechLevel(int techNumber) {
             this.techNumber = techNumber;
         }
         
         public int getTechNum() {
             return techNumber;
         }
    }

}
