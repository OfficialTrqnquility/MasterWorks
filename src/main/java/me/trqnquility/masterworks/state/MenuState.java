package me.trqnquility.masterworks.state;

import com.google.common.collect.Sets;
import lombok.Getter;
import me.trqnquility.masterworks.ui.UIObject;
import me.trqnquility.masterworks.worlds.World;

import java.awt.*;
import java.util.Set;

@Getter
public class MenuState extends State {

    private Set<UIObject> uiObjects;

    public MenuState() {
        uiObjects = Sets.newConcurrentHashSet();
        uiObjects.add(new UIObject(50, 50, 50, 100) {
            @Override
            protected void onClick() {
                System.out.println("click");
                State.setState(new GameState(new World("worlds/overworld.txt")));
            }
        });
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        for (UIObject uiObject : uiObjects) {
            g.drawRect(uiObject.getX(), uiObject.getY(), uiObject.getWidth(), uiObject.getHeight());
        }
    }
}
