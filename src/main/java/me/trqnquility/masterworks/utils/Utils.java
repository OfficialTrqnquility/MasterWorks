package me.trqnquility.masterworks.utils;

import me.trqnquility.masterworks.boundingbox.BoundingBox;
import me.trqnquility.masterworks.location.Position;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Utils {

    public static String loadFileAsString(String path) {
        StringBuilder builder = new StringBuilder();

        try {

            BufferedReader br = new BufferedReader(new FileReader("src/main/resources/" + path));
            String line;

            while ((line = br.readLine()) != null) {

                builder.append(line + "\n");
            }

            br.close();

        } catch (IOException e) {

            e.printStackTrace();

        }

        return builder.toString();
    }


    public static BufferedImage loadImage(String path) {

        try {
            return ImageIO.read(Utils.class.getResourceAsStream(path));

        } catch (IOException e) {

            e.printStackTrace();
            System.exit(1);

        }

        return null;
    }


    public static int parseInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static boolean isOverlapping(Position position1, Position position2, BoundingBox boundingBox1, BoundingBox boundingBox2) {
        if (position1.getY() + boundingBox1.getYOffset() < position2.getY() + boundingBox2.getYOffset() + boundingBox2.getHeight()
                || position1.getY() + boundingBox1.getYOffset() + boundingBox1.getHeight() > position2.getY() + boundingBox2.getYOffset()) {
            return false;
        }
        if (position1.getX() + boundingBox1.getXOffset() + boundingBox1.getWidth() < position2.getX() + boundingBox2.getXOffset()
                || position1.getX() + boundingBox1.getXOffset() > position2.getX() + boundingBox2.getWidth() + boundingBox2.getXOffset()) {
            return false;
        }
        return true;
    }
}
