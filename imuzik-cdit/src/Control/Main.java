package Control;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import com.sun.lwuit.Display;
import javax.microedition.midlet.*;

/**
 * @author TRITUEVIET
 */
public class Main extends MIDlet {
    public LoadAPI loadAPI;
    public Main() {
        Display.init(this);
        
    }

    
    public void startApp() {
        Controller.getInstance().loadTheme();
       // loadAPI = new LoadAPI();
        Controller.getInstance().chay(this);
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
        notifyDestroyed();
    }
}
