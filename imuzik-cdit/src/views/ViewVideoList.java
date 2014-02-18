/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import Control.Controller;
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
public class ViewVideoList extends Form implements ActionListener{
    private List videoList = null;
    Command back= new Command(Var.quayLai);
    public ViewVideoList()
    {
        Vector items= new Vector();
        items.addElement("video 1");
        items.addElement("video 2");
        items.addElement("video 3");
        
        videoList = new List(items);
        
        addComponent(videoList);
        setBackCommand(back);
        addCommand(back);
        addCommandListener(this);
        
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==videoList){
            // videoList.getSelectedIndex();  - lấy vị trí video được chọn trong list
            
            // play video đó
            
            
        } else if(ae.getCommand()==back){
            Controller.getInstance().showHome();
        }
    
    }
}
