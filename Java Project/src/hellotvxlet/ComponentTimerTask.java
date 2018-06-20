/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.util.TimerTask;

/**
 *
 * @author student
 */
public class ComponentTimerTask extends TimerTask {
    MyComponent mc;
    
    public void setCallback(MyComponent mc) {
        this.mc = mc;
    }
    
    public void run() {
        this.mc.callback();
    }
}
