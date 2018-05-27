/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.awt.*;
import java.util.Timer;
import org.dvb.event.*;
import org.dvb.ui.DVBColor;
import org.havi.ui.HComponent;
import org.havi.ui.event.HRcEvent;

/**
 *
 * @author Yves Sterckx & Daan Boschmans
 */
public class MyComponent extends HComponent implements UserEventListener {
    
    Image spaceship;
    Image stars;
    
    public MyComponent() {
        this.setBounds(0,0,720,576);
        
        spaceship = this.getToolkit().getImage("spaceship.png");
        stars = this.getToolkit().getImage("stars.png");
        
        MediaTracker mt = new MediaTracker(this);
        mt.addImage(spaceship, 0);
        mt.addImage(stars, 1);
        
        try {
            mt.waitForAll();
        }
        catch(InterruptedException ex) {
            ex.printStackTrace();
        }
        
        Timer t = new Timer();
        MyTimerTask mtt = new MyTimerTask();
        mtt.setCallback(this);
        t.scheduleAtFixedRate(mtt, 0, 100);
    }
    public void callback() {
        this.repaint();
    }
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(spaceship, 50, 50, this);
    }
    public void userEventReceived(UserEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
