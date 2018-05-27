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
    
    Image spaceship; // 25x50
    int x = 347;
    int y = 263;
    
    public MyComponent() {
        this.setBounds(0,0,720,576);
        
        spaceship = this.getToolkit().getImage("spaceship.png");
        
        MediaTracker mt = new MediaTracker(this);
        mt.addImage(spaceship, 0);
        
        try {
            mt.waitForAll();
        }
        catch(InterruptedException ex) {
            ex.printStackTrace();
        }
        
        UserEventRepository repo = new UserEventRepository("repo");
        repo.addAllArrowKeys();
        // repo.addKey(49);
        
        EventManager manager = EventManager.getInstance();
        manager.addUserEventListener(this, repo);
        
        Timer t = new Timer();
        MyTimerTask mtt = new MyTimerTask();
        mtt.setCallback(this);
        t.scheduleAtFixedRate(mtt, 0, 100);
        // Start op 0 ms elke 20 ms
    }
    public void callback() {
        this.repaint();
    }
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(spaceship, this.x, this.y, this);      
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

}
