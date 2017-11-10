package org.codecentral.type.objects;

import java.awt.Graphics;

public class Letter extends GameObject {

    private char letter;

    public Letter(char letter, int x, int y) {
        super(x, y);
        this.letter = letter;
    }

    @Override
    public void onDraw(Graphics g) {
        g.drawString(String.valueOf(letter), getX(), getY());
    }
}
