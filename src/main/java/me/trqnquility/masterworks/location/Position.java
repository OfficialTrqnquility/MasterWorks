package me.trqnquility.masterworks.location;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Position {

    private int x = 0;
    private int y = 0;

    private int width;
    private int height;

    public void add(int x, int y) {
        this.x += x;
        this.y += y;
    }

    public void add(Position position) {
        this.add(position.getX(), position.getY());
    }

}
