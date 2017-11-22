package org.codecentral.type;

import org.codecentral.type.objects.Row;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JApplet;
import javax.swing.JFrame;

/**
 * A clone of Guitar Hero, but with keyboard inputs.
 *
 * @author David Robles, Willie Chalmers III, Nason Lewis
 */
public class TTRGame extends JApplet {

    private static final String NAME = "Type Type Revolution";

    private static final int ROW_AMOUNT = 4;

    private InputHandler inputHandler = new InputHandler();

    private List<Row> rows = new ArrayList<>();

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
        addKeyListener(inputHandler);
        setFocusable(true);
        initializeRows();
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        drawBackground(graphics);
        drawRows(graphics);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        repaint();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        updateRows();
    }

    private void drawBackground(Graphics g) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("assets/metalbackground.png"));
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Couldn't draw background");
        }
        g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
    }

    private void initializeRows() {
        int yPos = 100;
        for (int i = 0; i < ROW_AMOUNT; i++) {
            Row row = new Row(0, yPos, getWidth());
            rows.add(i, row);
            yPos += row.getHeight() + 100;
        }
    }

    private void updateRows() {
        rows.forEach(Row::onUpdate);
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