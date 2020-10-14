package me.trqnquility.masterworks.gfx;

import me.trqnquility.masterworks.utils.Utils;

import java.awt.image.BufferedImage;

public class Assets {

    private static final int width = 32, height = 32;

    public static BufferedImage dirt, grass, stone, tree, rock;
    public static BufferedImage[] player_down, player_up, player_left, player_right;
    public static BufferedImage[] player_hit;

    public static void init(){
        SpriteSheet sheet = new SpriteSheet(Utils.loadImage("/textures/textures.png"), width, height);

        player_down = new BufferedImage[2];
        player_up = new BufferedImage[2];
        player_left = new BufferedImage[2];
        player_right = new BufferedImage[2];

        player_down[0] = sheet.crop(width * 4, 0);
        player_down[1] = sheet.crop(width * 5, 0);
        player_up[0] = sheet.crop(width * 6, 0);
        player_up[1] = sheet.crop(width * 7, 0);
        player_right[0] = sheet.crop(width * 4, height);
        player_right[1] = sheet.crop(width * 5, height);
        player_left[0] = sheet.crop(width * 6, height);
        player_left[1] = sheet.crop(width * 7, height);

        dirt = sheet.crop(width, 0);
        grass = sheet.crop(width * 2, 0);
        stone = sheet.crop(width * 3, 0);
        tree = sheet.crop(0, 0 * 2);
        rock = sheet.crop(0, height * 2);
    }


}
