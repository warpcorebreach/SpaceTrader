/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package space.trader.gameplay;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import space.trader.location.*;

/**
 *
 * @author Weiyu
 */
public class Save {
    private Player player;
    private Market market;
    private SolarSystem sys;
    private Universe uni;
    private Object StandardOpenOptions;
    
    public Save() {
        player = Data.getPlayer();
        market = Data.getMarket();
        sys = Data.getSolarSystem();
        uni = Data.getUniverse();
    }
    
    /**
     * TODO
     * add save() method to each class that needs to be saved
     * save() should return an ArrayList of Strings of all necessary data
     * put them into one big ArrayList in saveTextFile() then write this to a file
     * 
     * TO LOAD
     * read Strings from text file, add to an ArrayList
     * set data in each saved class to data read from file
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
     
    public void saveModelBinary()  {
        try {
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("player.bin"))) {
                out.writeObject(player);
            }
            //try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("market.bin"))) {
            //    out.writeObject(market);
            //}
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("sys.bin"))) {
                out.writeObject(sys);
            }
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("uni.bin"))) {
                out.writeObject(uni);
            }
        } catch (IOException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void loadModelBinary()  {
        try {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("player.bin"))) {
                player = (Player)in.readObject();
            }
            //try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("market.bin"))) {
            //    market = (Market)in.readObject();
            //}
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("sys.bin"))) {
                sys = (SolarSystem)in.readObject();
            }
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("uni.bin"))) {
                uni = (Universe)in.readObject();
            }
            Data.setPlayer(player);
            //Data.setMarket(market);
            Data.setSolarSystem(sys);
            Data.setUniverse(uni);
            
        } catch (IOException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
