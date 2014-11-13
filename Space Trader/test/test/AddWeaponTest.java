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
import space.trader.resources.ShipTypes.*;
import space.trader.resources.Equipment.Weapon;
/**
 *
 * @author Duc Tran
 */
public class AddWeaponTest {
    Ship ship;
    Weapon weapon;
    @Before
    public void init() {
        ship = new Ship();
        weapon = new Weapon("Pulse Laser");
    }
    @Test
    public void CheckIfEmpty() {
        assertEquals(0, ship.getWeaponsSize());
    }
    @Test
    public void AddGeneral() {
        int size = ship.getWeaponsSize();
        ship.addWeapon(weapon);
        assertEquals(size + 1, ship.getWeaponsSize());
    }
    
    @Test
    public void addWhenFull() {
        ship = new Ship();
        int weaponsSlot = ship.getShipType().getWeaponSlot();
        for (int i = 0; i < weaponsSlot; i++) {
            ship.addWeapon(weapon);
        }
        int size = ship.getWeaponsSize();
        ship.addWeapon(weapon);
        assertEquals(size, ship.getWeaponsSize());
    }
    @Test
    public void addNull() {
        ship = new Ship();
        int size = ship.getWeaponsSize();
        ship.addWeapon(null);
        assertEquals(size, ship.getWeaponsSize());
    }
}
