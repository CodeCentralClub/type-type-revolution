package org.codecentral.type.objects;

import java.awt.Graphics;

public class Row extends GameObject {

    private static final int HEIGHT = 128;

    private static final int DEFAULT_WIDTH = 1000;

    public Row(int x, int y) {
        super(x, y);
    }

    public void run() {

    }

    public void drawLetters() {

    }

    @Override
    public void onDraw(Graphics g) {
        g.drawRect(getX(), getY(), HEIGHT, DEFAULT_WIDTH);
    }
}
