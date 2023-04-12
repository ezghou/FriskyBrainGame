package FriskyBrain;

/**
 * This class holds the main method of the game Frisky Brain.
 * 
 * @author EzGhou
 * @author Thereze
 */
public class Frisky_Brain {
    
    public static HomeScreen hm;
    
    /**
     * The main method of game.
     * @param args Unused
     */
    public static void main(String[] args) {
        SplashScreen screen = new SplashScreen();
        Frisky_Brain.hm = new HomeScreen();
    }
}
    

