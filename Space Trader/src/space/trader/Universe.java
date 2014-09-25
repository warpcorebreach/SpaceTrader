/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space.trader;

import java.util.ArrayList;
import java.util.Random;

/**
 * Represents the game universe.
 * Contains 50 randomly generated solar systems with unique locations in the
 * universe.
 * @author Justin
 */
public class Universe {
    
    private final int MAX_X = 50;
    private final int MAX_Y = 100;
    
    private ArrayList<SolarSystem> systems;
    // An ArrayList of int arrays which represents the x,y coordinates of each planet
    // in the solar system
    private ArrayList<int[]> map;
    
    public Universe() {
        map = new ArrayList();
        systems = universeGenerate();
    }
    
    /**
     * Generates 50 solar systems in the game universe.
     * Each solar system contains one planet, each with its own set of resources,
     * a given technology level, and a unique (x,y) location in the universe.
     * Resources, tech levels, and coordinates are randomly generated for each
     * solar system upon creation of a new Universe object.
     * 
     * @return universe An ArrayList containing the solar systems in the universe.
     */
    private ArrayList<SolarSystem> universeGenerate() {
        // Get number of available system names
        int numberOfName = SolarSystem.Name.values().length;
        Random randObject = new Random();
        // Generate 2 arrayLists
        ArrayList<Integer> numArray = new ArrayList();
        ArrayList<SolarSystem> universe = new ArrayList();
        // Generate each planet and add it to the array
        for (int i = 0; i < 50; i++) {
            
            // Generate a random unique universe name
            int nextNum = randObject.nextInt(numberOfName);
            while (numArray.contains(nextNum)) {
                nextNum = randObject.nextInt(numberOfName);
            }
            SolarSystem.Name systemName = SolarSystem.Name.values()[nextNum];
            // Pick tech level and resources randomly
            SolarSystem.TechLevel systemLevel = SolarSystem.TechLevel.values()[randObject.nextInt(8)];
            SolarSystem.Resources systemResources = SolarSystem.Resources.values()[randObject
                                                           .nextInt(13)];
            numArray.add(nextNum);
            
            // Generate a random set of x,y coordinates for the current planet,
            // then iterate through the list of coordinates to ensure the new
            // set is unique. If not generate a new set of coords and check again
            int x = Math.abs(randObject.nextInt()) % MAX_X;
            int y = Math.abs(randObject.nextInt()) % MAX_Y;
            int[] newCoords = {x, y};
            if (map.isEmpty()) {
                map.add(newCoords);
            } else {
                boolean invalidCoords = false;
                do {
                    for (int[] coords : map) {
                        if (coords[0] == x && coords[1] == y) {
                            x = Math.abs(randObject.nextInt()) % MAX_X;
                            y = Math.abs(randObject.nextInt()) % MAX_Y;
                            invalidCoords = true;
                        } else {
                            invalidCoords = false;
                        }
                    }
                }
                while (invalidCoords);
                newCoords[0] = x;
                newCoords[1] = y;
                map.add(newCoords);
            }
            
            universe.add(new SolarSystem(systemName, x, y, systemLevel, systemResources));
        }
        return universe;
    }
    
    /**
     * Create a string representation for the system
     * @return: The string represent a solar system.
     */
    @Override
    public String toString() {
        String universeString = "";
        for (SolarSystem s : systems) {
            universeString += "Name: " + s.getName() + "\n" + "X,Y Coords: " + "(" + s.getX()
                + "," + s.getY() + ")" + "\n" + "Tech Level: " + s.getTechLevel()
                + "\n" + "Resources: " + s.getResources() + "\n" + "\n";
        }
        
       return universeString;
    }
    
    /**
     * Getter method for the Universe object.
     * @return systems An ArrayList of solar systems in the universe.
     */
    public ArrayList<SolarSystem> getUniverse() {
        return systems;
    }
    
}
