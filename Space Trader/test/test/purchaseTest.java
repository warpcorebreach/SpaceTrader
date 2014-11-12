package test;

import org.junit.Before;
import org.junit.Test;
import space.trader.gameplay.Ship;
import space.trader.resources.TradeGoods.TradeGood;
import space.trader.resources.TradeGoods.Water;

/**
 *
 * @author Justin
 */
public class purchaseTest {
    TradeGood selected;
    Ship ship;

    @Before
    public void init() {
        selected = new Water();
        ship = new Ship();
    }

    @Test
    public void buyWithNoCash() {
        
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