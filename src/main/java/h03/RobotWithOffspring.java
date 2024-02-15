package h03;

import fopbot.Direction;
import fopbot.Robot;

public class RobotWithOffspring extends Robot {

    private final int numberOfColumnsOfWorld;
    private final int numberOfRowsOfWorld;
    protected Robot offspring;

    /**
     * Constructor of RobotWithOffspring
     *@param numberOfColumnsOfWorld	    x-coordinate
     *@param numberOfRowsOfWorld		y-coordinate
     *@param direction				    direction
     *@param numberOfCoins			    number of coins
     */
    public RobotWithOffspring(int numberOfColumnsOfWorld, int numberOfRowsOfWorld, Direction direction, int numberOfCoins) {
        super(numberOfColumnsOfWorld / 2, numberOfRowsOfWorld / 2, direction,numberOfCoins);
        this.numberOfColumnsOfWorld = numberOfColumnsOfWorld;
        this.numberOfRowsOfWorld = numberOfRowsOfWorld;
    }

    /**
     * Creates a object of the class Robot
     * @param direction in which way the Robot looks
     * @param numberOfCoins number of coins
     */
    public void initOffspring(Direction direction, int numberOfCoins) {
        offspring = new Robot(getX(), getY(), direction, numberOfCoins);
    }

    /**
     * @return x-coordinate of offspring
     */
    public int getXOfOffspring() {
        return offspring.getX();
    }

    /**
     * @return the y-coordinate of offspring
     */
    public int getYOfOffspring() {
        return offspring.getY();
    }

    /**
     * @return the direction of offspring
     */
    public Direction getDirectionOfOffspring() {
        return offspring.getDirection();
    }

    /**
     * @return the amount of coins of offspring
     */
    public int getNumberOfCoinsOfOffspring() {
        return offspring.getNumberOfCoins();
    }

    /**
     * @return true if offspring has been initialized
     */
    public boolean offspringIsInitialized() {
        return offspring != null;
    }

    /**
     * If the offspring has been initialized, adds the given value to the
     * x-coordinate of the offspring. If the target coordinate is not in the range
     * of columns of the world, the offspring is placed at the border, as close to
     * the target coordinate as possible.
     * @param x The value to be added to the current x-coordinate of the offspring.
     */
    public void addToXOfOffspring(int x) {
        if (offspringIsInitialized()) {
            int n = offspring.getX() + x;
            if (0 < n && n < numberOfColumnsOfWorld - 1) {
                offspring.setX(n);
            } else if (n < 0) {
                offspring.setX(0);
            } else if ((numberOfColumnsOfWorld - 1) < n) {
                offspring.setX(numberOfColumnsOfWorld - 1);
            }
        }
    }

    /**
     * If the offspring has been initialized, adds the given value to the
     * y-coordinate of the offspring. If the target coordinate is not in the range
     * of columns of the world, the offspring is placed at the border, as close to
     * the target coordinate as possible.
     *
     * @param y The value to be added to the current y-coordinate of the offspring.
     */
    public void addToYOfOffspring(int y) {
        if (offspringIsInitialized()) {
            int n = offspring.getY() + y;
            if (n < 0) {
                offspring.setY(0);
            } else if ((numberOfRowsOfWorld - 1) < n) {
                offspring.setY(numberOfRowsOfWorld - 1);
            } else {
                offspring.setY(n);
            }
        }
    }

    /**
     * Takes an integer and adds that number of turns to the current direction of
     * the offspring. Uses modular arithmetic to calculate the target direction and
     * then turns the offspring to point in that direction.
     *
     * @param direction The integer value to be added to the given
     *                           direction. Represents the number of right turns of
     *                           the offspring.
     */
    public void addToDirectionOfOffspring(int direction) {
        if (offspringIsInitialized()) {
            int currentDir = offspring.getDirection().ordinal();
            int n = currentDir + direction;
            Direction newDirection;
            if (n < 0) {
                newDirection = Direction.values()[(4 - ((-n) % 4)) % 4];
            } else {
                newDirection = Direction.values()[n % 4];
            }
            while (offspring.getDirection() != newDirection) {
                offspring.turnLeft();
            }
        }
    }

    /**
     * Adds the given number of coins to the coins the offspring currently owns.
     *
     * @param coins The number of coins to be added.
     */
    public void addToNumberOfCoinsOfOffspring(int coins) {
            if (offspringIsInitialized()) {
                int n = offspring.getNumberOfCoins() + coins;
                if (n > 0) {
                    offspring.setNumberOfCoins(n);
                } else {
                    offspring.setNumberOfCoins(0);
                }
            }
        }
}
