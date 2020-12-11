package me.trqnquility.masterworks.boundingbox;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class BoundingBox {

    private int width;
    private int height;

    public BoundingBox(int width, int height) {
        this.width = width;
        this.height = height;

    }

    public static BoundingBox of(int width, int height) {
        return new BoundingBox(width, height);
    }
}
