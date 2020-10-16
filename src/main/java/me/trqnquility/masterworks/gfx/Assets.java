package me.trqnquility.masterworks.gfx;

import me.trqnquility.masterworks.utils.Utils;

import java.awt.image.BufferedImage;

public class Assets {

    private static final int width = 32, height = 32;

    public static BufferedImage grass;
    public static BufferedImage dirt;
    public static BufferedImage water;
    public static BufferedImage darkWater, waterToLightBottomLeft, waterToLightLeft, waterToLightRight, waterToLightBottom, waterToDarkTopRight, waterToDarkTop, waterToDarkBottomLeft, waterToDarkTopLeft;
    public static BufferedImage dock, dockCenter, dockDown, dockSide, dockFeet, dockFeetLeft, dockFeetRight, dockLeft, dockRight;
    public static BufferedImage[] player_down, player_up, player_left, player_right;
    public static BufferedImage[] player_hit;

    public static BufferedImage startButton;

    public static void init(){
        SpriteSheet environmentsheet = new SpriteSheet(Utils.loadImage("/textures/envnironmenttextures.png"), width, height);
        SpriteSheet tileSheet = new SpriteSheet(Utils.loadImage("/textures/tilemap.png"), 32, 32);

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

        grass = tileSheet.crop(width, height * 2);
        water = tileSheet.crop(width * 3, height * 21);
        darkWater = tileSheet.crop(width * 5, height * 21);
        waterToLightBottomLeft = tileSheet.crop(width * 8, height * 18);
        waterToDarkTop = tileSheet.crop(width * 7, height * 18);;
        waterToLightLeft = tileSheet.crop(width * 8, height * 17);
        waterToLightRight = tileSheet.crop(width * 6, height * 17);
        waterToDarkTopRight = tileSheet.crop(width * 3, height * 16);
        waterToDarkBottomLeft = tileSheet.crop(width * 6, height * 18);
        waterToDarkTopLeft = tileSheet.crop(width * 2, height * 16);
        waterToLightBottom = tileSheet.crop(width * 7, height * 16);

        dock = tileSheet.crop(width * 10, height);
        dockSide = tileSheet.crop(width * 10, height * 2);
        dockCenter = tileSheet.crop(width * 9, height);
        dockDown = tileSheet.crop(width * 4, height * 18);
        dockFeet = tileSheet.crop(width * 4, height * 19);
        dockFeetRight = tileSheet.crop(width * 4, height * 20);
        dockFeetLeft = tileSheet.crop(width * 4, height * 21);
        dockLeft = tileSheet.crop(width * 4, height * 17);
        dockRight = tileSheet.crop(width * 5, height * 17);



        startButton = Utils.loadImage("/textures/startbutton.png");

    }


}
