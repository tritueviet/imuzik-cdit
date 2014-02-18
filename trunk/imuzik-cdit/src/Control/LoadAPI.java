/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.io.IOException;
import java.io.InputStream;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Form;

/**
 *
 * @author Hanh
 */

public final class LoadAPI {
    HttpConnection httpC = null;
    InputStream inStr = null;
    private Display mDisplay;
    private Form mForm;
    private String mSession = null; 
    public LoadAPI()
    {
        AuthorClient();
    }
            
    public void AuthorClient() {
        String url = "http://imuzik3g.vega.com.vn/api.php/auth/validate?api_version=2&client_id=vegatest&fortest=1";
        System.out.println("---------------->" + url);
        try {
            httpC = (HttpConnection) Connector.open(url);
            String cookie = httpC.getHeaderField("Set-cookie");
            int statuscode = httpC.getResponseCode();
            inStr = httpC.openInputStream();
            if(statuscode !=200)return;        
            if (cookie != null) {
                int semicolon = cookie.indexOf(';');
                mSession = cookie.substring(0, semicolon);
                System.out.println("lay ve la: " + mSession);
            }
            int length = (int) httpC.getLength();
            byte[] raw = new byte[length];
            inStr.read(raw);
            //String s = new String(raw);
            //Alert a = new Alert("Response1", s, null, null);
            //a.setTimeout(Alert.FOREVER);
            //mDisplay.setCurrent(a, mForm);
            inStr.close();
            httpC.close();
            Autologin();
        } catch (IOException ioe) {
            Alert a = new Alert("Exception", ioe.toString(), null, null);
            a.setTimeout(Alert.FOREVER);
            mDisplay.setCurrent(a, mForm);
        }
    }
//dang nhap. chen "Cookie" vao request (cookie lay tu ham xac thuc client) sau do lay thuoc tinh "Set-cookie" cua response tra ve
    public void Autologin() {
        String url = "http://imuzik3g.vega.com.vn/api.php/account/login?username=84987710411&password=998899";
        System.out.println("---------------->" + url);
        try {
            httpC = (HttpConnection) Connector.open(url);

            if (mSession != null) {
                httpC.setRequestProperty("Cookie", mSession);
            }
            String cookie = httpC.getHeaderField("Set-cookie");
            int statuscode = httpC.getResponseCode();
            inStr = httpC.openInputStream();
            if(statuscode !=200)return;   
            System.out.println("cookie : " + cookie);
            if (cookie != null) {
                int semicolon = cookie.indexOf(';');
                mSession = cookie.substring(0, semicolon);
                System.out.println("lay ve la: " + mSession);
            }
          
            int length = (int) httpC.getLength();
            byte[] raw = new byte[length];
            inStr.read(raw);
            //String s = new String(raw);
            //Alert a = new Alert("Response1", s, null, null);
            //a.setTimeout(Alert.FOREVER);
            ///mDisplay.setCurrent(a, mForm);

            //System.out.println("2:  raw " + s + "\n  cook: " + mSession);
            //System.out.println("\n\n chay 3");
            inStr.close();
            httpC.close();
            GetNews();
        } catch (IOException ioe) {
            Alert a = new Alert("Exception", ioe.toString(), null, null);
            a.setTimeout(Alert.FOREVER);
            mDisplay.setCurrent(a, mForm);
        }
    }
// API lay danh sach tin tuc, chen "Cookie" vao request (cookie lay tu ham dang nhap) 
    public void GetNews() {
        String url = "http://imuzik3g.vega.com.vn/api.php/news";
        System.out.println("---------------->" + url);
        try {
            httpC = (HttpConnection) Connector.open(url);
            if (mSession != null) {
                httpC.setRequestProperty("Cookie", mSession);
                System.out.println("cai thanh cong la: " + mSession);
            }

            inStr = httpC.openInputStream();

            int length = (int) httpC.getLength();
            byte[] raw = new byte[length];
            inStr.read(raw);
            String s = new String(raw);
            //Alert a = new Alert("Response3", s, null, null);
            //a.setTimeout(Alert.FOREVER);
            //mDisplay.setCurrent(a, mForm);
            System.out.println("3:    raw " + s + "\n  cook: " + mSession);

            inStr.close();
            httpC.close();

        } catch (IOException ioe) {
            Alert a = new Alert("Exception", ioe.toString(), null, null);
            a.setTimeout(Alert.FOREVER);
            mDisplay.setCurrent(a, mForm);
        }
    }
}
