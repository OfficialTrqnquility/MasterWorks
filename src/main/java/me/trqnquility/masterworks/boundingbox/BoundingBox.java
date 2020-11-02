package me.trqnquility.masterworks.boundingbox;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class BoundingBox {

    private int width;
    private int height;

    private int xOffset;
    private int yOffset;

    public BoundingBox(int width, int height, int xOffset, int yOffset) {
        this.width = width;
        this.height = height;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }

    public static BoundingBox of(int width, int height, int xOffset, int yOffset) {
        return new BoundingBox(width, height, xOffset, yOffset);
    }
}
