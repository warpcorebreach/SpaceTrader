/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package space.trader.gameplay;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import static space.trader.gameplay.Data.getMarket;
import static space.trader.gameplay.Data.getPlayer;
import static space.trader.gameplay.Data.getSolarSystem;
import static space.trader.gameplay.Data.getUniverse;
import static space.trader.gameplay.Data.setInstance;
import static space.trader.gameplay.Data.setMarket;
import static space.trader.gameplay.Data.setPlayer;
import static space.trader.gameplay.Data.setSolarSystem;
import static space.trader.gameplay.Data.setUniverse;

/**
 *
 * @author Weiyu
 */
public class Save {
     private static Data save;
     public Save() {
        save = Data.getInstance();
        save.setUniverse(getUniverse());
        save.setPlayer(getPlayer());
        save.setSolarSystem(getSolarSystem());
        save.setMarket(getMarket());
     }
     
             public static void saveModelBinary()  {
        try {
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data.bin"))) {
                setInstance();
                out.writeObject(save);
                System.out.println("Game Saved");
                System.out.println(save.getPlayer().getName());
            }
        } catch (IOException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void loadModelBinary()  {
        try {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("data.bin"))) {
                save =  (Data)in.readObject();
                Data.setMarket(save.getMarket());
                Data.setUniverse(save.getUniverse());
                Data.setSolarSystem(save.getSolarSystem());
                Data.setPlayer(save.getPlayer());
                System.out.println("Game loaded");
                System.out.println(save.getPlayer().getName());
            }
        } catch (IOException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
