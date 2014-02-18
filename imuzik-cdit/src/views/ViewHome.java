/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import Control.IconDetail;
import Control.Controller;
import com.sun.lwuit.List;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;
import java.util.Vector;
import models.Var;

/**
 *
 * @author TRITUEVIET
 */
public class ViewHome extends IconDetail implements ActionListener{
    List ds=null;
    
    public ViewHome() {
        
        Vector items= new Vector();
        items.addElement(Var.baiHat);
        items.addElement(Var.video);
        items.addElement(Var.album);
        items.addElement(Var.bxh);
        ds= new List(items);
        ds.addActionListener(this);
        addComponent(ds);
        
        
    }
  public void actionPerformed(ActionEvent ae) {
      event(ae);
      if(ae.getSource()==ds) {
       if(ds.getSelectedIndex() == 0)//bai hat
          {
           System.out.println("load music");
              Controller.getInstance().showMusicInDevice();
          }
          else if(ds.getSelectedIndex() == 1)//video
          {
              System.out.println("load video");
              Controller.getInstance().showVideoList();
          }
          else if(ds.getSelectedIndex() == 2)//album
          {
              
          }
          else if(ds.getSelectedIndex() == 3)//bxh
          {
             
          }
          //System.out.println("abc");
      }
  }  
    
    
}
