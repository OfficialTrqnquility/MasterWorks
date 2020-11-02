package me.trqnquility.masterworks.keymanager;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;

public class KeyManager implements KeyListener {

    private boolean[] keys;
    public boolean up, down, left, right;

    public KeyManager() {
        keys = new boolean[256];
    }

    public void tick() {
        up = keys[KeyEvent.VK_W] && !keys[KeyEvent.VK_S];
        down = keys[KeyEvent.VK_S] && !keys[KeyEvent.VK_W];
        left = keys[KeyEvent.VK_A] && !keys[KeyEvent.VK_D];
        right = keys[KeyEvent.VK_D] && !keys[KeyEvent.VK_A];

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }
}
