/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import Control.IconDetail;
import com.sun.lwuit.Button;
import com.sun.lwuit.Container;
import com.sun.lwuit.Image;
import com.sun.lwuit.Label;
import com.sun.lwuit.Slider;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;
import com.sun.lwuit.events.DataChangedListener;
import com.sun.lwuit.layouts.BorderLayout;
import java.io.IOException;
import javax.microedition.location.ProximityListener;

/**
 *
 * @author TRITUEVIET
 */
public class ViewPlay extends IconDetail implements ActionListener{

    Image img = null;
    Button btnPlay=null, btnStop=null;
    Slider sliVolum=null, sliMusic=null;

    public ViewPlay() {
        try {
            img = Image.createImage("/images/nenNhac.jpg");
            btnPlay= new Button(Image.createImage("/images/play.png"));
            btnStop= new Button(Image.createImage("/images/pause.png"));
            btnPlay.addActionListener(this);
            btnStop.addActionListener(this);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Label lb = new Label(img);
        addComponent(lb);
        sliMusic= new Slider();
        sliMusic.setMaxValue(100);
        sliMusic.setMinValue(0);
        sliMusic.setEditable(true);
        sliMusic.setInfinite(true);
        
        sliMusic.addDataChangedListener(new DataChangedListener() {

            public void dataChanged(int i, int i1) {
                System.out.println("++music: "+ sliMusic.getProgress());
            }
        });
        addComponent(sliMusic);
        
        Container con = new Container(new BorderLayout());
        con.addComponent(BorderLayout.WEST,btnPlay);
        con.addComponent( BorderLayout.EAST, btnStop);
        addComponent(con);
        sliVolum= new Slider();
        sliVolum.setMaxValue(100);
        sliVolum.setMinValue(0);
        sliVolum.setEditable(true);
        sliVolum.setRenderValueOnTop(true);
        sliVolum.addDataChangedListener(new DataChangedListener() {

            public void dataChanged(int i, int i1) {
                System.out.println("++volum: "+ sliVolum.getProgress());
            }
        });
        addComponent(sliVolum);
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==btnPlay){
            try {
                btnPlay.setIcon(Image.createImage("/images/pause.png"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        
        }else{
            
        }
    
    }
    
}
