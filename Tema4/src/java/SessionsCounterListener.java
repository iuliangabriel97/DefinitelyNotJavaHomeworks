
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author roungureanu
 */
public class SessionsCounterListener implements HttpSessionListener {  
      private static int activeSessions = 0;    

      public void sessionCreated(HttpSessionEvent se) {
          SessionCounterManager.getInstance().incrementCount();
      }  

      public void sessionDestroyed(HttpSessionEvent se) {  
          SessionCounterManager.getInstance().decrementCount();
      }  

     public static int getActiveSessions() {  
          return SessionCounterManager.getInstance().getCount();
      }   
}  