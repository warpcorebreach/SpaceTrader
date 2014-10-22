
package space.trader.gameplay;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import space.trader.location.*;

/**
 * This class is used to write the state of the game to the user's disk so that
 * it can be loaded at a later time.
 * 
 * @author Justin
 */
public class Save {
    private Player player;
    private SolarSystem sys;
    private Universe uni;
    
    public Save() {
        player = Data.getPlayer();
        sys = Data.getSolarSystem();
        uni = Data.getUniverse();
    }
    
    /**
     * When called this method writes the state of the game to files which can
     * be used by the loadTextFile() method to restore a saved game.
     * 
     * Saves the current SolarSystem of the Player as well as the Player's
     * cash and skill points to a text file "save.txt"
     * Saves the Universe, represented by an ArrayList of SolarSystems, to a
     * text file "universe.txt"
     * Data is saved to text files as a string of comma separated values
     * generated via the saved object's save() methods.
     * 
     * Saves the Player's current Ship to a binary file using the Serializable
     * interface which allows for easy saving and restoring of the TradeGood
     * objects in the cargo.
     */
    public void saveTextFile() {
        try {
            FileWriter writer = new FileWriter(new File("save.txt"));
            writer.write(sys.save()+","+player.save());
            writer.close();
        } catch (IOException e) {
            System.out.println("file not found");
        }
        
        try {
            FileWriter writer = new FileWriter(new File("universe.txt"));
            ArrayList<SolarSystem> curUni = uni.getSystems();
            writer.write(""+curUni.size()+",");
            for (SolarSystem s : curUni.subList(0, curUni.size()-2)) {
                writer.write(s.save()+",");
            }
            writer.write(curUni.get(curUni.size()-1).save());
            writer.close();
        } catch (IOException e) {
            System.out.println("file not found");
        }
        
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("ship.bin"))) {
            out.writeObject(player.getShip());
            out.close();
        } catch (IOException e) {
            System.out.println("file not found");
        }
    }
    
    /**
     * Loads a saved game.
     * Splits the comma separated strings in the text files into an array which
     * can be indexed to get the desired data.
     * The binary file is easily loaded through the Serializable interface.
     */
    public void loadTextFile() {
        try {
            Data.setSolarSystem(new SolarSystem("", 0, 0, null, null));
            sys = Data.getSolarSystem();
            uni = new Universe();
            Scanner sc = new Scanner(new File("save.txt"));
            String[] saveData = sc.next().split(",");
            
            sys.setName(saveData[0]);
            sys.setTechLevel(SystemStats.TechLevel.valueOf(saveData[1]));
            sys.setResources(SystemStats.Resources.valueOf(saveData[2]));
            sys.setX(Integer.parseInt(saveData[3]));
            sys.setY(Integer.parseInt(saveData[4]));
            sys.setFuelCost(Integer.parseInt(saveData[5]));
            
            player = new Player(saveData[6], Integer.parseInt(saveData[7]),
                    Integer.parseInt(saveData[8]), Integer.parseInt(saveData[9]),
                    Integer.parseInt(saveData[10]), Integer.parseInt(saveData[11]));
            player.setCash(Integer.parseInt(saveData[12]));
            Data.setPlayer(player);
            
            sc = new Scanner(new File("universe.txt"));
            String[] uniData = sc.next().split(",");
            ArrayList<SolarSystem> loadedSystems = new ArrayList<>();
            SolarSystem s;
            int maxIndex = 5*Integer.parseInt(uniData[0]);
            int i = 1;
            while (i < maxIndex) {
                s = new SolarSystem(uniData[i], Integer.parseInt(uniData[i+3]),
                    Integer.parseInt(uniData[i+4]),
                    SystemStats.TechLevel.valueOf(uniData[i+1]),
                    SystemStats.Resources.valueOf(uniData[i+2]));
                s.setFuelCost(Integer.parseInt(uniData[i+5]));
                loadedSystems.add(s);
                i += 6;
            }
            uni.setSystems(loadedSystems);
            Data.setUniverse(uni);
            
            Data.setSolarSystem(sys);
            sc.close();
        } catch (IOException e) {
            System.out.println("file not found");
        }
        
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("ship.bin"))) {
            player.setShip((Ship)in.readObject());
        } catch (IOException e) {
            System.out.println("file not found");
        } catch (ClassNotFoundException ex) {
        }
    }
  
}
