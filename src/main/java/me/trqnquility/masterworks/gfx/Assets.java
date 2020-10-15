package me.trqnquility.masterworks.gfx;

import me.trqnquility.masterworks.utils.Utils;

import java.awt.image.BufferedImage;

public class Assets {

    private static final int width = 16, height = 16;

    public static BufferedImage dirt, grass, grassLeft, grassRight, grassTop, grassBottom, grassTopLeft, grassTopRight, grassBottomLeft, grassBottomRight;
    public static BufferedImage[] player_down, player_up, player_left, player_right;
    public static BufferedImage[] player_hit;

    public static void init(){
        SpriteSheet environmentsheet = new SpriteSheet(Utils.loadImage("/textures/envnironmenttextures.png"), width, height);

        player_down = new BufferedImage[2];
        player_up = new BufferedImage[2];
        player_left = new BufferedImage[2];
        player_right = new BufferedImage[2];

//        player_down[0] = sheet.crop(width * 4, 0);
//        player_down[1] = sheet.crop(width * 5, 0);
//        player_up[0] = sheet.crop(width * 6, 0);
//        player_up[1] = sheet.crop(width * 7, 0);
//        player_right[0] = sheet.crop(width * 4, height);
//        player_right[1] = sheet.crop(width * 5, height);
//        player_left[0] = sheet.crop(width * 6, height);
//        player_left[1] = sheet.crop(width * 7, height);

        grass = environmentsheet.crop(0, height * 3);
        grassTopLeft = environmentsheet.crop(0, 0);
        grassTop = environmentsheet.crop(width, 0);
        grassTopRight = environmentsheet.crop(width * 2, 0);
        grassLeft = environmentsheet.crop(0, height);
        grassRight = environmentsheet.crop(0, height * 3);
        grassTopLeft = environmentsheet.crop(0, height * 4);
        grassTop = environmentsheet.crop(width, height * 4);
        grassTopRight = environmentsheet.crop(width * 2, height * 4);
        dirt = environmentsheet.crop(width, height);
    }


}
