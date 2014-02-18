/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import com.sun.lwuit.Command;
import com.sun.lwuit.Form;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;
import models.Var;

/**
 *
 * @author TRITUEVIET
 */
public class IconDetail extends Form implements ActionListener {

    public Command login = new Command(Var.dangNhap);
    public Command signUp = new Command(Var.dangKi);
    public Command exit = new Command(Var.thoat);
    public Command about = new Command(Var.gioiThieu);
    public Command timerApp = new Command(Var.henGio);
    public Command category = new Command(Var.theLoai);
    public Command lastHeard = new Command(Var.ngheGanDay);
    public Command ringback = new Command(Var.nhacCho);
    public Command playlist = new Command(Var.nhacTrongMay);
    public Command logout = new Command(Var.dangXuat);
    

    public IconDetail() {
        addCommand(exit);
        addCommand(login);
        addCommand(signUp);
        addCommand(about);
        addCommand(category);
        addCommand(playlist);
        addCommand(timerApp);
        addCommandListener(this);
        
    }

    public void logined() {
        this.removeAllCommands();
        
        addCommand(exit);
        addCommand(logout);
        addCommand(ringback);
        addCommand(lastHeard);
        addCommand(about);
        addCommand(category);
        addCommand(playlist);
        addCommand(timerApp);
        addCommandListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
    }
    
    public void event(ActionEvent ae){
            if (ae.getCommand() == exit) {
            Controller.getInstance().exit();
        } else if (ae.getCommand() == about) {
            Controller.getInstance().showAbout();
        } else if (ae.getCommand() == timerApp) {
            //Controller.getInstance().
        } else if (ae.getCommand() == category) {
            // Controller.getInstance().
        } else if (ae.getCommand() == signUp) {
            //Controller.getInstance().
        } else if (ae.getCommand() == login) {
            //Controller.getInstance().
        } else if (ae.getCommand() == logout) {
            //Controller.getInstance().
        } else if (ae.getSource() == playlist) {
            System.out.println("music in device");
            Controller.getInstance().showMusicInDevice();
        } else if (ae.getCommand() == lastHeard) {
            //Controller.getInstance().
        } else if (ae.getCommand() == ringback) {
            //Controller.getInstance().
        }

    
    }
}
