/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

/**
 *
 * @author student
 */
public class Entity {
    
    int imageNumber;
    int range = 6;
    int x;
    int y = 0;
    
    public Entity() {
        this.imageNumber = (int) Math.round(Math.random() * this.range);
        this.x = (int) Math.round(Math.random() * (576 - 64));
    }
    
    public int getImage() {
        return this.imageNumber;
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    public void setY(int addition) {
        this.y += addition;
    }
}
