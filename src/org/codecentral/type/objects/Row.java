package org.codecentral.type.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Row extends GameObject {

    private static final int HEIGHT = 128;

    private static final int DEFAULT_WIDTH = 1000;

    private List<Letter> letters = new ArrayList<>();

    public Row(int x, int y) {
        super(x, y);
    }

    public void drawLetters(Graphics graphics) {
        letters.forEach(letter -> letter.onDraw(graphics));
    }

    @Override
    public void onDraw(Graphics g) {
        if (letters.size() == 0) {
            for (int i = 0; i < 10; i++) {
                letters.add(new Letter(200, 200));
            }
        }
        // Draw this row
        g.setColor(Color.BLACK);
        g.drawRect(getX(), getY(), DEFAULT_WIDTH, HEIGHT);
        // Draw the letters
        drawLetters(g);
    }
}
