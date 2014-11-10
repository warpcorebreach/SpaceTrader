
import java.util.ArrayList;
import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import space.trader.gameplay.Ship;
import space.trader.resources.TradeGoods.Furs;
import space.trader.resources.TradeGoods.TradeGood;

/**
 *
 * @author Weiyu
 */
public class AddCargoJUnitTestWeiyuLi {
    Ship testShip;
    ArrayList<TradeGood> answer;
    ArrayList<TradeGood> answer2;
    @Before
    public void setUp() {
        testShip = new Ship();
        answer = new ArrayList<>();
        answer2 = new ArrayList<>();
        answer.add(new Furs());
        answer.add(new Furs());
        answer.add(new Furs());
        for (int i = 0; i < 20; i++) {
            answer2.add(new Furs());
        }
    }
    @Test
    public void addCargoNotFull() {
        testShip.addCargo(new Furs());
        testShip.addCargo(new Furs());
        testShip.addCargo(new Furs());
        assertEquals(testShip.getCargoSize(),answer.size());
        HashMap<String, Integer> c = testShip.getCargo();
        int i = 0;
        for (String item : c.keySet()) {
            assertEquals(item,answer.get(i).getName());
            i++;
        }
    }
    @Test
    public void addCargoFull() {
        for(int i = 0; i < testShip.getMaxCargoSize(); i++) {           
            assertTrue(testShip.addCargo(new Furs()));
        }
        assertFalse(testShip.addCargo(new Furs()));
    }
}
