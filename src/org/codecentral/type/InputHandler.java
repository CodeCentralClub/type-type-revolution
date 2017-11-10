package org.codecentral.type;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 */
public class InputHandler implements KeyListener {

    public InputHandler() {

    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        System.out.println(KeyEvent.getKeyText(keyEvent.getKeyCode()));
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }

    public interface Callback {

        void onPress(char letter);
    }
}