package me.trqnquility.masterworks.mouse;

import me.trqnquility.masterworks.state.GameState;
import me.trqnquility.masterworks.state.MenuState;
import me.trqnquility.masterworks.state.State;
import me.trqnquility.masterworks.ui.UIObject;

import java.awt.event.*;

public class MouseManager implements MouseListener, MouseMotionListener {

    public MouseManager() {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        State state = State.getState();
        if (state instanceof GameState) {
            ((GameState) state).getPlayer().onClick(new ClickType(e.getButton() == MouseEvent.BUTTON1, e.getButton() == MouseEvent.BUTTON2, e.getX(), e.getY()));
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        State state = State.getState();
        if (state instanceof MenuState) {
            for (UIObject uiOject : ((MenuState) state).getUiObjects()) {
                uiOject.onMouseRelease();

            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        State state = State.getState();

        if (state instanceof MenuState) {
            for (UIObject uiOject : ((MenuState) state).getUiObjects()) {
                uiOject.onMouseMove(e);
            }
        }
    }
}
