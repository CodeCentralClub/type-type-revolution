package org.codecentral.type;

import org.codecentral.type.objects.Row;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JApplet;
import javax.swing.JFrame;

/**
 * A clone of Guitar Hero, but with keyboard inputs.
 *
 * @author David Robles, Willie Chalmers III, Nason Lewis
 */
public class TTRGame extends JApplet {

    private static final String NAME = "Type Type Revolution";

    private List<Row> rows = new ArrayList<>(4);

    public static void main(String[] args) {
        JFrame f = new JFrame(NAME);
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        JApplet game = new TTRGame();
        f.add(game);
        game.init();
        f.pack();
        f.setExtendedState(f.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        f.setSize(screenSize.width - 100, screenSize.height - 100);
        f.setVisible(true);
    }

    @Override
    public void init() {
        initializeRows();
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        drawRows(graphics);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        repaint();
    }

    private void initializeRows() {
        int yPos = 100;
        for (int i = 0; i < rows.size(); i++) {
            rows.set(i, new Row(0, yPos));
            yPos += 50;
        }
    }

    /**
     * Draws the rows onto the screen.
     *
     * @param graphics The window's root graphics
     */
    private void drawRows(Graphics graphics) {
        for (Row row : rows) {
            row.onDraw(graphics);
        }
    }
}
