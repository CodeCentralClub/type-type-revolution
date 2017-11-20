package org.codecentral.type.objects;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.concurrent.ThreadLocalRandom;

public class Letter extends GameObject {

    /**
     * The number of pixels to move upon each movement.
     *
     * @see #moveForward()
     */
    private int speed = 10;

    private char letter;

    public Letter(int x, int y) {
        this(generateRandomLetter(), x, y);
    }

    public Letter(char letter, int x, int y) {
        super(x, y);
        this.letter = letter;
    }

    @Override
    public void onDraw(Graphics g) {
        g.setFont(new Font("SansSerif", Font.BOLD, 10));
        g.setColor(Color.WHITE);
        g.drawString(String.valueOf(letter), getX(), getY());
    }

    public void moveForward() {
        setY(getY() - speed);
    }

    public void setSpeed(int newSpeed) {
        speed = newSpeed;
    }

    private static char generateRandomLetter() {
        int upperCase = ThreadLocalRandom.current().nextInt(56, 90 + 1);
        int lowerCase = ThreadLocalRandom.current().nextInt(97, 122 + 1);
        return (char) (ThreadLocalRandom.current().nextInt(0, 1 + 1) == 0
                ? upperCase
                : lowerCase);
    }
}
