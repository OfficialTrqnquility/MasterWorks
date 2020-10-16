package me.trqnquility.masterworks.state;

import com.google.common.collect.Sets;
import lombok.Getter;
import me.trqnquility.masterworks.Game;
import me.trqnquility.masterworks.gfx.Assets;
import me.trqnquility.masterworks.ui.UIButton;
import me.trqnquility.masterworks.ui.UIObject;
import me.trqnquility.masterworks.worlds.World;

import java.awt.*;
import java.util.Set;

@Getter
public class MenuState extends State {

    private Set<UIObject> uiObjects;

    public MenuState() {
        uiObjects = Sets.newConcurrentHashSet();
        uiObjects.add(new UIButton( (Game.getInstance().width - 500) / 2, (Game.getInstance().height - 250) / 2, 500, 250, Assets.startButton) {
            @Override
            protected void onClick() {
                System.out.println("click");
                State.setState(new GameState(new World("worlds/tileworld.txt")));
            }


        });
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Game.getInstance().width, Game.getInstance().height);
        for (UIObject uiObject : uiObjects) {
            uiObject.render(g);
        }
    }
}
