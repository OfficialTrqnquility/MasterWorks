package me.trqnquility.masterworks.gfx;

import me.trqnquility.masterworks.utils.Utils;

import java.awt.image.BufferedImage;

public class Assets {

    private static final int width = 16, height = 16;

    public static BufferedImage grass, grassLeft, grassRight, grassTop, grassBottom, grassTopLeft, grassTopRight, grassBottomLeft, grassBottomRight;
    public static BufferedImage dirt, dirtTopleft, dirtTopRight, dirtBottomLeft, dirtBottomRight;
    public static BufferedImage forest;
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
        grassRight = environmentsheet.crop(width * 2, height);
        grassBottomLeft = environmentsheet.crop(0, height * 2);
        grassBottom = environmentsheet.crop(width, height * 2);
        grassBottomRight = environmentsheet.crop(width * 2, height * 2);
        dirt = environmentsheet.crop(width, height);
        dirtTopleft = environmentsheet.crop(width * 3, 0);
        dirtTopRight = environmentsheet.crop(width * 4, 0);
        dirtBottomLeft = environmentsheet.crop(width * 3, height);
        dirtBottomRight = environmentsheet.crop(width * 4, height);
        forest = environmentsheet.crop(width * 7, height * 4);

    }


}
