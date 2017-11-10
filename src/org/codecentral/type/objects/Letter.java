package org.codecentral.type.objects;

import java.awt.Graphics;
import java.awt.Point;

public class Letter extends GameObject {

    private char letter;

    public Letter(int x, int y) {
        super(x, y);
    }

    public Letter(Point position) {
        super(position);
    }

    @Override
    public void onDraw(Graphics g) {
        g.drawString(String.valueOf(letter), getX(), getY());
    }

}
