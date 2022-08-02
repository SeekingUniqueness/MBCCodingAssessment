package com.example.virtualfan;

import javafx.beans.property.*;

/**
 * The Fan class represents a virtual ceiling fan with two pullstrings: one that increases the speed of the fan and one that changes its direction.
 * If the fan has reached its maximum speed, pulling the speed pullstring will turn the fan off.
 */
public class Fan {
    private final IntegerProperty speed;
    private final ObjectProperty<Direction> direction;
    private final int numSpeeds; // does not include the off position

    /**
     * The directions in which the virtual fan can spin
     */
    public enum Direction {
        /**
         * The clockwise direction
         */
        CLOCKWISE("Clockwise"),
        /**
         * The counterclockwise direction
         */
        COUNTERCLOCKWISE("Counterclockwise");

        private final String description;

        Direction(String description) {
            this.description = description;
        }

        /**
         * Returns a string representation of the direction
         * @return a string representation of the direction
         */
        @Override
        public String toString() {
            return description;
        }

    }

    /**
     * Initializes a virtual fan with three possible speeds (not including off).
     * The fan is initially off and set to spin in a clockwise direction.
     */
    public Fan() {
        speed = new SimpleIntegerProperty(0);
        direction = new SimpleObjectProperty<>(Direction.CLOCKWISE);
        numSpeeds = 3;
    }

    /**
     * Initializes a virtual fan with the given number of possible speeds (not including off).
     * The fan is initially off and set to spin in the given direction.
     *
     * @param numSpeeds the number of speeds that fan can be set to (not including off);
     *                  an argument less than 1 will be treated as 1
     * @param direction the initial direction to which the fan is set to spin
     */
    public Fan(int numSpeeds, Direction direction) {
        speed = new SimpleIntegerProperty(0);
        this.direction = new SimpleObjectProperty<>(direction);
        this.numSpeeds = Math.max(numSpeeds, 1);
    }

    /**
     * Simulates pulling the speed pullstring
     */
    public void pullSpeedString() {
        // finding the value modulo (numSpeeds + 1) will result in a number between 0 and numSpeeds
        speed.set((speed.get() + 1) % (numSpeeds + 1));
    }

    /**
     * Simulates pulling the direction pullstring
     */
    public void pullDirectionString() {
        if (direction.get() == Direction.CLOCKWISE)
            direction.set(Direction.COUNTERCLOCKWISE);
        else
            direction.set(Direction.CLOCKWISE);
    }

    /**
     * Provides a description of the current state of the virtual fan
     * @return the description of the state
     */
    public String toString() {
        return "Speed: " + speed.get() + ", Direction: " + direction.get();
    }

    /**
     * Indicates whether the fan is currently stopped
     * @return true if the fan is stopped and false otherwise
     */
    public boolean isStopped() {
        return speed.get() == 0;
    }

    /**
     * Gets the current speed of the fan
     * @return the speed of the fan (0 means the fan is stopped)
     */
    public final int getSpeed() {
        return speed.get();
    }

    /**
     * The current speed of the fan
     * @return the speed of the fan (0 means the fan is stopped)
     */
    public IntegerProperty speedProperty() {
        return speed;
    }

    /**
     * Gets the direction in which the fan is set to spin (regardless of whether it is actually spinning)
     * @return the currently set spin direction
     */
    public final Direction getDirection() {
        return direction.get();
    }

    /**
     * The direction in which the fan is set to spin (regardless of whether it is actually spinning)
     * @return the currently set spin direction
     */
    public ObjectProperty<Direction> directionProperty() {
        return direction;
    }
}
