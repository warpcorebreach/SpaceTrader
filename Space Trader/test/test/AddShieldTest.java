package test;

import java.util.ArrayList;
import java.util.HashMap;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import space.trader.gameplay.Ship;
import space.trader.resources.ShipTypes.Firefly;
import space.trader.resources.Equipment.Shield;
import space.trader.resources.TradeGoods.Furs;

/**
 *
 * @author JD
 */
public class AddShieldTest {
    Ship ship;
    Shield shield;
    ArrayList<Shield> shieldsList;

    @Before
    public void init() {
        ship = new Ship();
        ship.setShipType(new Firefly());
        shield = new Shield("Energy Shield");
    }

    @Test
    public void addShieldAvailable() {
        int size = ship.getShieldsSize();
        ship.addShield(new Shield("Energy Shield"));
        assertEquals(size + 1, ship.getShieldsSize());
    }
    
    @Test
    public void addNullShield() {
        int size = ship.getShieldsSize();
        ship.addShield(null);
        assertEquals(size, ship.getShieldsSize());
    }
    
    @Test
    public void addShieldNotAvailable() {
        for (int i = 0; i < ship.getShipType().getShieldSlot(); i++) {
            ship.addShield(new Shield("Energy Shield"));
        }
        int size = ship.getShieldsSize();
        ship.addShield(new Shield("Energy Shield"));
        assertEquals(size, ship.getShieldsSize());
    }
}