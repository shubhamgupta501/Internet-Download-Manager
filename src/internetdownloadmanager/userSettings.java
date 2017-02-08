/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internetdownloadmanager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author racer
 */
public class userSettings {
    
    public static Properties prop =new Properties();
    FileInputStream fin;
    FileOutputStream fout;
    
    public void storeProperty(String key,String value){
     
        try {
            fout =new FileOutputStream("userConfiguration");
            prop.setProperty(key, value);
            prop.store(fout, null);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(userSettings.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(userSettings.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String getProperty(String key){
        
        String value=null;
        try {
            fin =new FileInputStream("userConfiguration");
            prop.load(fin);
            value =prop.getProperty(key);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(userSettings.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(userSettings.class.getName()).log(Level.SEVERE, null, ex);
        }
        return value;
    }
            
    
}
