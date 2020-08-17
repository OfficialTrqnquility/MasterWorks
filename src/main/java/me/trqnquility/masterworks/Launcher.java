package me.trqnquility.masterworks;

import me.trqnquility.masterworks.utils.Utils;

import java.io.File;

public class Launcher {

    public static void main(String[] args) {
        Game game = new Game("MasterWorks", 640, 640);
        game.start();
    }

}
