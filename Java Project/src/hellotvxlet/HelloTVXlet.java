package hellotvxlet;

import java.awt.event.*;
import java.util.Timer;
import javax.tv.xlet.*;
// import java.awt.*;
import org.havi.ui.*;
import org.havi.ui.event.*;


public class HelloTVXlet implements Xlet, HActionListener {

    HStaticText tekstlabel;
    HTextButton restartKnop;
    HStaticText healthText;
    HScene scene;
    MyComponent mc;
    
    public HelloTVXlet() {
     
    }
    
    public void initXlet(XletContext context) throws XletStateChangeException {
        this.scene = HSceneFactory.getInstance().getDefaultHScene();
        this.mc = new MyComponent();
        
        this.tekstlabel = new HStaticText("SCORE: " + mc.getScore());
        this.tekstlabel.setLocation(120,0);
        this.tekstlabel.setSize(500,50);
        this.tekstlabel.setBackgroundMode(HVisible.BACKGROUND_FILL);
        
        this.healthText = new HStaticText("Health: " + mc.getHealth()); 
        this.healthText.setLocation(0,0);
        this.healthText.setSize(125,50);
        this.healthText.setBackgroundMode(HVisible.BACKGROUND_FILL);
        
        Timer timer = new Timer();
        
        TextTimer tt = new TextTimer();
        tt.setCallback(this);
        
        timer.scheduleAtFixedRate(tt, 0, 100);

        this.scene.add(mc);
        this.scene.add(healthText);
        this.scene.add(tekstlabel);
        
        this.scene.validate();
        this.scene.setVisible(true);
        
      
    }

    public void startXlet() {
    
    }

    public void pauseXlet() {
     
    }

    public void destroyXlet(boolean unconditional) {
     
    }

    public void actionPerformed(ActionEvent arg0) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public void updateText() {
        this.scene.remove(this.tekstlabel);
        this.scene.remove(this.healthText);
        
        this.tekstlabel = new HStaticText("SCORE: " + mc.getScore());
        this.tekstlabel.setLocation(120,0);
        this.tekstlabel.setSize(500,50);
        this.tekstlabel.setBackgroundMode(HVisible.BACKGROUND_FILL);
        
        this.healthText = new HStaticText("Health: " + mc.getHealth()); 
        this.healthText.setLocation(0,0);
        this.healthText.setSize(125,50);
        this.healthText.setBackgroundMode(HVisible.BACKGROUND_FILL); 
        
        this.scene.add(this.healthText);
        this.scene.add(this.tekstlabel);
        this.scene.validate();
    }
}
