/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author roungureanu
 */
public class SessionCounterManager {

    // static variable single_instance of type Singleton 
    private static SessionCounterManager instance = null; 
    
    private int count = 1;
  
    // private constructor restricted to this class itself 
    private SessionCounterManager() 
    { 
    } 
  
    public synchronized int getCount()
    {
        return count;
    }
    
    public synchronized void incrementCount()
    {
        count += 1;
    }
    
    public synchronized void decrementCount()
    {
        count -= 1;
    }
    
    // static method to create instance of Singleton class 
    public static SessionCounterManager getInstance() 
    { 
        if (instance == null) 
            instance = new SessionCounterManager(); 
  
        return instance; 
    } 
}
