package org.codecentral.type.objects;

import java.awt.Graphics;
import java.awt.Point;
import java.util.Objects;

/**
 * The base class for all displayable on-screen components.
 */
abstract class GameObject {

    private Point position;

    private int width;
    private int height;

    public GameObject(int x, int y, int width, int height) {
        this(new Point(x, y), width, height);
    }

    public GameObject(Point position, int width, int height) {
        this.position = position;
        this.width = width;
        this.height = height;
    }

    public int getX() {
        return (int) position.getX();
    }

    public int getY() {
        return (int) position.getY();
    }

    public void setX(double x) {
        position.setLocation(x, getY());
    }

    public void setY(double y) {
        position.setLocation(getX(), y);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Updates game logic and prepare for a redraw.
     */
    public void onUpdate() {

    }

    /**
     * Redraws currently displayed graphics.
     */
    public abstract void onDraw(Graphics g);

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }

    /**
     * Returns true if the given object has the same X and Y coordinates as this.
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof GameObject)) {
            return false;
        }
        GameObject object = (GameObject) o;
        return (object.getX() == getX()) && (object.getY() == getY());
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "[x=" + getX() + ",y=" + getY() + "]";
    }
}
