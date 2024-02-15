package h03;

import fopbot.Direction;

public class RobotWithOffspring2 extends RobotWithOffspring {

    private int directionAccu;

    /**
     * Constructor of RobotWithOffspring2. Calls the super constructor.
     *
     * @param numberOfColumnsOfWorld Number of columns in the world the robot is
     *                               supposed to be placed in.
     * @param numberOfRowsOfWorld    Number of row in the world the robot is
     *                               supposed to be placed in.
     * @param direction              The initial direction the robot points at.
     * @param coins                  The initial amount of coins the robot owns.
     */
    public RobotWithOffspring2(int numberOfColumnsOfWorld, int numberOfRowsOfWorld, Direction direction, int coins) {
        super(x, y, direction, coins);
    }

    @Override
    public void initOffspring(Direction direction, int numberOfCoins) {
        super.initOffspring(direction, numberOfCoins);
        this.directionAccu = direction.ordinal();
    }

    private Direction getDirectionFromAccu() {
        Direction newDirection;
        if (directionAccu < 0) {
            newDirection = Direction.values()[(4 - ((-directionAccu) % 4)) % 4];
        } else {
            newDirection = Direction.values()[directionAccu % 4];
        }
        return newDirection;
    }

    @Override
    public Direction getDirectionOfOffspring() {
        return getDirectionFromAccu();
    }

    @Override
    public void addToDirectionOfOffspring(int direction) {
        if (offspringIsInitialized()) {
            directionAccu += direction;
            Direction newDirection = getDirectionFromAccu();
            while (offspring.getDirection() != newDirection) {
                offspring.turnLeft();
            }
        }
    }
}
