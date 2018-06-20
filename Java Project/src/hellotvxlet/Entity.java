/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.util.Random;

/**
 *
 * @author student
 */
public class Entity {
    
    int max = 7;
    int min = 1;
    int imageNumber;
    
    Random rand = new Random();
    
    public Entity() {
        this.imageNumber = rand.nextInt((this.max - this.min) + 1) + this.min;
    }
    
    public int getImage() {
        return this.imageNumber;
    }
}
