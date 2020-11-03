package me.trqnquility.masterworks.inventory;

import com.google.common.collect.Lists;
import me.trqnquility.masterworks.Game;
import me.trqnquility.masterworks.entity.model.inanimate.item.EntityItem;
import me.trqnquility.masterworks.gfx.Assets;
import me.trqnquility.masterworks.ui.UIOverlay;

import java.awt.image.BufferedImage;
import java.util.List;

public class Inventory extends UIOverlay {

    List<EntityItem> items;

    public Inventory(int x, int y, int width, int height, BufferedImage icon) {
        super(x, y, width, height, icon);

        items = Lists.newArrayListWithCapacity(4);
    }

    public Inventory(int inventorySize) {
        super(Game.getInstance().width / 5 * 4,10, 117, 40, Assets.inventory);
        items = Lists.newArrayListWithCapacity(inventorySize - 1);

    }

    public void addItem(EntityItem item) {
        if (!isFull()) {
            items.add(item);
        }
    }

    @Override
    public void tick() {

    }

    public boolean isFull() {
        return (items.size() == 5);
    }

}
