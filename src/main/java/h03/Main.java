package h03;

import fopbot.Direction;
import fopbot.World;

/**
 * Main entry point in executing the program.
 */
public class Main {

    /**
     * Main entry point in executing the program.
     *
     * @param args program arguments, currently ignored
     */
    public static void main(String[] args) {
        sandboxTests();
    }

    private static void sandboxTests() {
        World.setSize(7, 5);
        World.setVisible(true);

        // Put your code here
        int numberOfColumns = World.getWidth();
        int numberOfRows = World.getHeight();
        RobotWithOffspring robot = new RobotWithOffspring(numberOfColumns, numberOfRows, Direction.UP, 0);
    }
}
