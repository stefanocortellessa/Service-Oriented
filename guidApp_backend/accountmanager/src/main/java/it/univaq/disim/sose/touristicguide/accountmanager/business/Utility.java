package it.univaq.disim.sose.touristicguide.accountmanager.business;

import java.security.SecureRandom;

public class Utility {

    protected static SecureRandom random = new SecureRandom();
    
    //Method to generate a User Token 
    public static String generateToken() {
        
    	long longToken = Math.abs(random.nextLong());
        
        return Long.toString(longToken, 200);
    }
}
