package org.codecentral.type;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 */
public class InputHandler extends KeyAdapter {

    public InputHandler() {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        System.out.println(KeyEvent.getKeyText(keyEvent.getKeyCode()));
    }
}