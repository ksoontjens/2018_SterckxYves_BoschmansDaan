/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.awt.*;
import java.util.Timer;
import org.dvb.event.*;
// import org.dvb.ui.*;
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
    
    int x = 347;
    int y = 263;
    
    //String[] images = {"1.png","2.png","3.png","4.png","5.png","6.png","bomb.png"};
    
    public MyComponent() {
        this.setBounds(0,0,720,576);
        
<<<<<<< HEAD
        //Entity hamburgerPiece = new Entity();
        
        this.loadImages();
=======
        spaceship = this.getToolkit().getImage("spaceship.png");       
        MediaTracker mt = new MediaTracker(this);
        mt.addImage(spaceship, 0);
        
        try {
            mt.waitForAll();
        }
        catch(InterruptedException ex) {
            ex.printStackTrace();
        }
>>>>>>> 552c2363f9205f8670e5bc62fd47bcab504d8894
        
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
        
        gameTimer.scheduleAtFixedRate(gtt, 0, 100);
        entityTimer.scheduleAtFixedRate(ett, 0, 2000);  
        
    }
    public void callback() { // update functie
        this.repaint();
    }
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(images[5], this.x, this.y, this);
    }
    public void userEventReceived(UserEvent e) {
        if(e.getType() == HRcEvent.KEY_PRESSED) {
            if(e.getCode() == HRcEvent.VK_LEFT) {
                this.x -= 5;
                this.repaint();
            }
            if(e.getCode() == HRcEvent.VK_RIGHT) {
                this.x += 5;
                this.repaint();
            }
            if(e.getCode() == HRcEvent.VK_UP) {
                this.y -= 5;
                this.repaint();
            }
            if(e.getCode() == HRcEvent.VK_DOWN) {
                this.y += 5;
                this.repaint();
            }
        }
        // throw new UnsupportedOperationException("Not supported yet.");
    }
       
    public void loadImages() {
        this.images[0] = this.getToolkit().getImage("player.png");
        this.images[1] = this.getToolkit().getImage("1.png");
        this.images[2] = this.getToolkit().getImage("2.png");
        this.images[3] = this.getToolkit().getImage("3.png");
        this.images[4] = this.getToolkit().getImage("4.png");
        this.images[5] = this.getToolkit().getImage("5.png");
        this.images[6] = this.getToolkit().getImage("6.png");
        this.images[7] = this.getToolkit().getImage("bomb.png");
        
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
        this.entityCounter = ++this.entityCounter;
    }
}
