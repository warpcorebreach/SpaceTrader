/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space.trader.resources;

import space.trader.location.SystemStats.Resources;


/**
 * Represents a Food object
 * @author Justin
 */
public class Food extends TradeGood {

    public Food() {
        super(1, 0, 1, 100, 5, 5, Resources.RICHSOIL, Resources.POORSOIL, "Food");
    }
    
}
