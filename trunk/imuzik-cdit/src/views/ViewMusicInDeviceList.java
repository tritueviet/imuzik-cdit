/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import Control.Controller;
import Control.IconDetail;
import com.sun.lwuit.Command;
import com.sun.lwuit.Form;
import com.sun.lwuit.List;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;
import java.util.Vector;
import models.Var;

/**
 *
 * @author Hanh
 */
public class ViewMusicInDeviceList extends IconDetail implements ActionListener {
    private List musicInDeviceList = null;
    Command back= new Command(Var.quayLai);
    public ViewMusicInDeviceList()
    {
        Vector items= new Vector();
        items.addElement("nhac 1");
        items.addElement("nhac 2");
        items.addElement("nhac 3");
        
        musicInDeviceList = new List(items);
        
        addComponent(musicInDeviceList);
        setBackCommand(back);
        addCommand(back);
        addCommandListener(this);
        
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==musicInDeviceList){
            // musicInDeviceList.getSelectedIndex();  - lấy vị trí bài hát được chọn trong list
            
            // play bài hát đó
            
            
        } else if(ae.getCommand()==back){
            Controller.getInstance().showHome();
        }
    
    }
}