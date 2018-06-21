/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.awt.*;
import java.util.Timer;
import org.dvb.event.*;
import org.havi.ui.HComponent;
import org.havi.ui.event.HRcEvent;

/**
 *
 * @author Yves Sterckx & Daan Boschmans
 */
public class MyComponent extends HComponent implements UserEventListener {
    
    Image[] images = new Image[8];
    
    Entity[] entities = new Entity[10];
    int entityCounter = 0;
    
    int x = 316;
    int y = 470;
    
    int score = 0;
    int health = 3;

    
    public MyComponent() {
        this.setBounds(0,0,720,576);
        
        this.loadImages();
        
        UserEventRepository repo = new UserEventRepository("repo");
        repo.addAllArrowKeys();
        
        EventManager manager = EventManager.getInstance();
        manager.addUserEventListener(this, repo);
        
        Timer gameTimer = new Timer();
        Timer entityTimer = new Timer();
        
        ComponentTimerTask gtt = new ComponentTimerTask();
        gtt.setCallback(this);
        
        EntityTimerTask ett = new EntityTimerTask();
        ett.setCallback(this);
        
        gameTimer.scheduleAtFixedRate(gtt, 0, 35);
        entityTimer.scheduleAtFixedRate(ett, 0, 2500);
        
        for (int e = 0; e < this.entities.length; e++) {
            entities[e] = new Entity();
        }
        
    }
    public void callback() { // update functie
        this.repaint();
  
           for (int i = 0; i < this.entityCounter ; i++) {
               
               if ((this.x - this.entities[i].getX()) < 50 && (this.y - this.entities[i].getY()) < 50 ){
                   
                   this.score += 10;
                   System.out.println(this.score);
               }
           }
      
        }
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(images[7],this.x, this.y, this);
        for (int i = 0; i < this.entityCounter; i++) {
            entities[i].setY(5);
            g.drawImage(images[entities[i].getImage()], entities[i].getX(), entities[i].getY(), this);
        }
<<<<<<< HEAD
      
=======
        ++this.score;
        System.out.println(this.x);
>>>>>>> 0c8a5ca0adf09e115a206200e944f6d2e17b8292
    }
    public void userEventReceived(UserEvent e) {
        if(e.getType() == HRcEvent.KEY_PRESSED) {
            if(e.getCode() == HRcEvent.VK_LEFT) {
                this.x -= 10;
            }
            if(e.getCode() == HRcEvent.VK_RIGHT) {
                this.x += 10;
            }
        }
    }
       
    public void loadImages() {
        this.images[0] = this.getToolkit().getImage("1.png");
        this.images[1] = this.getToolkit().getImage("2.png");
        this.images[2] = this.getToolkit().getImage("3.png");
        this.images[3] = this.getToolkit().getImage("4.png");
        this.images[4] = this.getToolkit().getImage("5.png");
        this.images[5] = this.getToolkit().getImage("6.png");
        this.images[6] = this.getToolkit().getImage("bomb.png");
        this.images[7] = this.getToolkit().getImage("player.png");
        
        MediaTracker mt = new MediaTracker(this);
        
        for (int i = 0; i < images.length; i++) {
            mt.addImage(images[i], 0);
        }
         
        try {
            mt.waitForAll();
        }
        catch(InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    public void increaseEntityCounter() {
        if (this.entityCounter <= 9 && this.entities[8].getY() < 720) {
            this.entityCounter = ++this.entityCounter;
            System.out.println( this.entityCounter);
        } 
        
        if (this.entityCounter > 9 && this.entities[8].getY() > 720){
            this.entityCounter = 1;
            this.resetEntityY();
<<<<<<< HEAD
            
       

=======
>>>>>>> 0c8a5ca0adf09e115a206200e944f6d2e17b8292
        }
    }
    public void resetEntityY() {
        System.out.println("Resetting entities");
        for (int i = 0; i < this.entities.length; i++) {
            if (entities[i].getY() > 720) {entities[i].resetY();}
        }
    }
    
    public String getScore() {
        return Integer.toString(this.score);
    }
    public String getHealth() {
        return Integer.toString(this.health);
    }
}
