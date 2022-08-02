package com.example.virtualfan;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VirtualFanTest {

    Fan fan;

    @BeforeEach
    void setUp() {
        fan = new Fan();
    }

    @Test
    @DisplayName("The fan should be initialized properly")
    void initialState() {
        assertEquals(fan.getSpeed(), 0);
        assertEquals(fan.getDirection(), Fan.Direction.CLOCKWISE);
    }

    @Test
    @DisplayName("Changing the fan's direction should work")
    void changeDirection() {
        fan.pullDirectionString();
        assertEquals(fan.getDirection(), Fan.Direction.COUNTERCLOCKWISE);
        fan.pullDirectionString();
        assertEquals(fan.getDirection(), Fan.Direction.CLOCKWISE);
    }

    @Test
    @DisplayName("Changing the fan's speed should work")
    void changeSpeed() {
        fan.pullSpeedString();
        assertEquals(fan.getSpeed(), 1);
        fan.pullSpeedString();
        assertEquals(fan.getSpeed(), 2);
        fan.pullSpeedString();
        assertEquals(fan.getSpeed(), 3);
        fan.pullSpeedString();
        assertEquals(fan.getSpeed(), 0);
    }

    @Test
    @DisplayName("Ensure a combination of changes to speed and direction work properly")
    void testFunctionality() {
        fan.pullSpeedString();
        fan.pullDirectionString();
        fan.pullSpeedString();
        assertEquals(fan.getSpeed(), 2);
        assertEquals(fan.getDirection(), Fan.Direction.COUNTERCLOCKWISE);
    }

    @Test
    @DisplayName("The string representation of the fan's state should be correct")
    void testStateDescription() {
        assertEquals(fan.toString(), "Speed: 0, Direction: Clockwise");
    }

    @Test
    @DisplayName("The fan should initialize properly when not using defaults")
    void testConstructorWithArguments() {
        fan = new Fan(5, Fan.Direction.COUNTERCLOCKWISE);
        assertEquals(fan.getSpeed(), 0);
        assertEquals(fan.getDirection(), Fan.Direction.COUNTERCLOCKWISE);
    }

    @Test
    @DisplayName("Changing the fan's speed with more than the default number of speeds should work")
    void testNonDefaultNumberOfSpeeds() {
        fan = new Fan(5, Fan.Direction.COUNTERCLOCKWISE);
        for (int i = 0; i < 5; ++i) {
            fan.pullSpeedString();
        }
        assertEquals(fan.getSpeed(), 5);
        fan.pullSpeedString();
        assertEquals(fan.getSpeed(), 0);
    }
}
