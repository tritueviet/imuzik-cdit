/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import com.nokia.mid.ui.CategoryBar;
import com.nokia.mid.ui.ElementListener;
import com.nokia.mid.ui.IconCommand;
import com.sun.lwuit.plaf.UIManager;
import com.sun.lwuit.util.Resources;
import event.Event;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.Image;
import views.LoadScreen;
import views.*;

/**
 *
 * @author TRITUEVIET
 */
public class Controller {

    private static Controller instance = null;
    public CategoryBar categoryBar;
    private Image icon;
    private Main main;
    public ViewMusicInDeviceList musicInDevice = null;
    public ViewMusicList musicList = null;
    public ViewVideoList videoList = null;
    public ViewHome viewHome=null;
    public ViewPlay viewPlay=null;
    public static Resources theme = null;

    private Controller() {
        // Init here
        // getCurrentLocation();
        init();
    }

    public static void loadTheme() {
        try {
            theme = Resources.open("/themes/full_touch_theme.res");
            UIManager.getInstance().setThemeProps(theme.getTheme(theme.getThemeResourceNames()[0]));
        } catch (Throwable ex) {
        }
    }

    public void init() {
        IconCommand[] iconCommands = new IconCommand[2];

        for (int i = 0; i < iconCommands.length; i++) {
            try {
                icon = Image.createImage("/images/icon" + (i + 1) + ".png");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            iconCommands[i] = new IconCommand("", icon, icon, Command.SCREEN, 1);

        }
        categoryBar = new CategoryBar(iconCommands, true);
        // categoryBar.setHighlightColour(bankId);

        categoryBar.setElementListener(new CategoryElementListener());

        categoryBar.setVisibility(true);

    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }
    
    public void chay(Main main) {
        this.main = main;
        if (1 == 0) {
            LoadScreen load = new LoadScreen(main);
            javax.microedition.lcdui.Display.getDisplay(main).setCurrent(load);
            load.start();
            load = null;
        }
        categoryBar.setVisibility(false);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        categoryBar.setVisibility(true);
        //  show in here
        showHome();
    }

    public void categorry(boolean show) {
        if (show== false) {
            categoryBar.setVisibility(false);
        } else {
            categoryBar.setVisibility(true);
        }
    }

    public void handleEvent(int eventType, Event evt) {
        switch (eventType) {

        }
    }
    public void showPlay(){
        viewPlay= new ViewPlay();
        viewPlay.show();
    }
    public void exit() {
        //   saveConfig();
        main.destroyApp(true);
    }

    public void showAbout() {
        // hiển thị giới thiệu
    }
    public void showHome(){
        categoryBar.setVisibility(true);
        
        viewHome= new ViewHome();
        viewHome.show();
        
        System.gc();
    }
    public void showMusicInDevice()
    {
        categorry(false);
        musicInDevice = new ViewMusicInDeviceList();
        musicInDevice.show();
    }
    public void showMusicList()
    {
        categorry(false);
        musicList = new ViewMusicList();
        musicList.show();
    }
    public void showVideoList()
    {
        categorry(false);
        videoList = new ViewVideoList();
        videoList.show();
    }
    class CategoryElementListener implements ElementListener {

        public void notifyElementSelected(CategoryBar bar, int selectedIndex) {
            if (bar == categoryBar) {
                if (selectedIndex == 0) {
                    // showFindATMView();
                } else if (selectedIndex == 1) {
                    showPlay();
                    
                } else if (selectedIndex == 2) {
                    // showLocationATM();
                } else if (selectedIndex == 3) {
                    // showOptionATM();
                } else {
                    try {
                        exit();
                    } catch (Exception ex) {
                        System.out.println("k thoats ddc ");
                    }
                }

            }
        }
    }
}