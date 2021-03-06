
package space.trader.location;

import java.util.ArrayList;
import java.util.Random;

/**
 * Represents the game universe.
 * Contains 50 randomly generated solar systems with unique locations in the
 * universe.
 * @author Justin
 */
public class Universe {

    private static final int MAX_X = 50;
    private static final int MAX_Y = 100;
    private static final int MAX_SYSTEMS = 50;
    private static final int TECHLEVEL_RANDMAX = 7;
    private static final int RESOURCES_RANDMAX = 13;

    private ArrayList<SolarSystem> systems;
    // An ArrayList of int arrays representing the x,y coords of each planet
    // in the solar system
    private ArrayList<int[]> map;

    public Universe() {
        map = new ArrayList();
        systems = universeGenerate();
    }

    /**
     * Generates 50 solar systems in the game universe.
     * Each solar system contains 1 planet, each with its own set of resources,
     * a given technology level, and a unique (x,y) location in the universe.
     * Resources, tech levels, and coordinates are randomly generated for each
     * solar system upon creation of a new Universe object.
     *
     * @return universe ArrayList containing the solar systems in the universe.
     */
    private ArrayList<SolarSystem> universeGenerate() {
        // Get number of available system names
        int numberOfName = SystemStats.Name.values().length;
        Random randObject = new Random();
        // Generate 2 arrayLists
        ArrayList<Integer> numArray = new ArrayList();
        ArrayList<SolarSystem> universe = new ArrayList();
        // Generate each planet and add it to the array
        for (int i = 0; i < MAX_SYSTEMS; i++) {

            // Generate a random unique universe name
            int nextNum = randObject.nextInt(numberOfName);
            while (numArray.contains(nextNum)) {
                nextNum = randObject.nextInt(numberOfName);
            }
            SystemStats.Name systemName = SystemStats.Name.values()[nextNum];
            // Pick tech level and resources randomly
            SystemStats.TechLevel systemLevel =
                    SystemStats.TechLevel.values()
                        [randObject.nextInt(TECHLEVEL_RANDMAX) + 1];
            SystemStats.Resources systemResources =
                    SystemStats.Resources.values()
                        [randObject.nextInt(RESOURCES_RANDMAX)];
            numArray.add(nextNum);

            // Generate a random set of x,y coordinates for the current planet,
            // then iterate through the list of coordinates to ensure the new
            // set is unique. If not generate a new set of coords & check again
            int x = Math.abs(randObject.nextInt(Integer.MAX_VALUE)) % MAX_X;
            int y = Math.abs(randObject.nextInt(Integer.MAX_VALUE)) % MAX_Y;
            int[] newCoords = {x, y};
            if (map.isEmpty()) {
                map.add(newCoords);
            } else {
                boolean invalidCoords = false;
                do {
                    for (int[] coords : map) {
                        if (coords[0] == x && coords[1] == y) {
                            x = Math.abs(randObject.nextInt(Integer.MAX_VALUE))
                                    % MAX_X;
                            y = Math.abs(randObject.nextInt(Integer.MAX_VALUE))
                                    % MAX_Y;
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

            universe.add(new SolarSystem(systemName.toString(),
                                         x, y, systemLevel, systemResources));
        }
        return universe;
    }

    /**
     * Getter method for the Universe object.
     * @return systems An ArrayList of solar systems in the universe.
     */
    public ArrayList<SolarSystem> getSystems() {
        return systems;
    }

    public void setSystems(ArrayList<SolarSystem> s) {
        systems = s;
    }

    public int getMaxSystems() {
        return MAX_SYSTEMS;
    }

}
