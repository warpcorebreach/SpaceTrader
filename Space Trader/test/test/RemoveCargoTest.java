package test;

import java.util.HashMap;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;
import space.trader.gameplay.Ship;
import space.trader.resources.TradeGoods.Games;
import space.trader.resources.TradeGoods.TradeGood;
import space.trader.resources.TradeGoods.Water;

/**
 *
 * @author Justin
 */
public class RemoveCargoTest {
    Ship ship;
    TradeGood good;
    HashMap<String, Integer> cargo;

    @Before
    public void init() {
        ship = new Ship();
        good = new Water();
    }

    @Test
    public void removeFromEmptyCargo() {
        assertEquals(ship.removeCargo(good), 0);
    }

    @Test
    public void removeGoodNotInCargo() {
        TradeGood game = new Games();
        ship.addCargo(good);
        assertEquals(ship.removeCargo(game), -1);
    }

    @Test
    public void removeOneQuantityGood() {
        ship.removeCargo(good);
        cargo = ship.getCargo();
        assertNull(cargo.get(good.getName()));
    }

    @Test
    public void removeMultipleQuantityGood() {
        ship.addCargo(good);
        ship.addCargo(good);
        ship.removeCargo(good);
        cargo = ship.getCargo();
        assertEquals((int)cargo.get(good.getName()), 1);
    }
}



/*

if (selected == null) return;
        if (cash - selected.getPrice() < 0) {
            // out of money error message
            mnn.setText("You can't afford that, trader.");
        } else if (selected.getQuantity() == 0) {
            // none available error message
            mnn.setText("Our pirates, er, friendly traders are out acquiring "
                    + "more.");
        } else {
            boolean buy = ship.addCargo(selected);
            if (buy == false) {
                // cargo full error message
                mnn.setText("You'll need more cargo space to store that.");
            } else {
                cash -= selected.getPrice();
                player.setCash(cash);
                cashLabel.setText("Cash: " + cash);
                int q = selected.getQuantity() - 1;
                selected.setQuantity(q);

                updateCargoScreen();
            }
        }

*/