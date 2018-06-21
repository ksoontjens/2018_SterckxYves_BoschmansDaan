package hellotvxlet;

import java.awt.event.*;
import javax.tv.xlet.*;
// import java.awt.*;
import org.havi.ui.*;
import org.havi.ui.event.*;
import org.dvb.ui.*;


public class HelloTVXlet implements Xlet, HActionListener {

    public HStaticText tekstlabel;
    public HTextButton restartKnop;
    public HStaticText healthText;
    public HelloTVXlet() {
    
    }
    
    public void initXlet(XletContext context) throws XletStateChangeException {
        HScene scene = HSceneFactory.getInstance().getDefaultHScene();
        MyComponent mc = new MyComponent();
        
        tekstlabel = new HStaticText("SCORE: " + mc.getScore());
        tekstlabel.setLocation(120,0);
        tekstlabel.setSize(500,50);
        //tekstlabel.setBackground(new DVBColor(255,255,255,150));
        tekstlabel.setBackgroundMode(HVisible.BACKGROUND_FILL);

        healthText = new HStaticText("Health: " + mc.getHealth()); 
        healthText.setLocation(0,0);
        healthText.setSize(125,50);
        //healthText.setBackground(new DVBColor(255,255,255,150));
        healthText.setBackgroundMode(HVisible.BACKGROUND_FILL);

        scene.add(mc);
        scene.add(healthText);
        scene.add(tekstlabel);   
        
        scene.validate();
        scene.setVisible(true);
        
      
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
}
