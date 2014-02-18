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
import event.Event;
import java.util.Vector;
import models.Var;

/**
 *
 * @author Hanh
 */
public  class ViewMusicList extends Form implements ActionListener{
    private List musicList = null;
    Command back= new Command(Var.quayLai);
    public ViewMusicList()
    {
        Vector items= new Vector();
        items.addElement("nhac 1");
        items.addElement("nhac 2");
        items.addElement("nhac 3");
        
        musicList = new List(items);
        
        addComponent(musicList);
        setBackCommand(back);
        addCommand(back);
        addCommandListener(this);
        
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==musicList){
            // musicList.getSelectedIndex();  - lấy vị trí bài hát được chọn trong list
            
            // play bài hát đó
            
            
        } else if(ae.getCommand()==back){
            Controller.getInstance().showHome();
        }
    
    }
}
