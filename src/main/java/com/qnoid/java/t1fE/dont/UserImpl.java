/*
 *  This file is under the licence Attribution-ShareAlike 3.0 Unported 
 *  (CC BY-SA 3.0) http://creativecommons.org/licenses/by-sa/3.0/
 *
 *  You are free:
 *      to Share - to copy, distribute and transmit the work
 *      to Remix - to adapt the work
 *
 *  Under the following conditions:
 *
 *  Attribution - You must attribute the work in the manner specified by the 
 *  author or licensor (but not in any way that suggests that they endorse you 
 *  or your use of the work).
 *  
 *  Share Alike - If you alter, transform, or build upon this work, you may 
 *  distribute the resulting work only under the same or similar license to 
 *  this one.
 *
 *  With the understanding that:
 *
 *  Waiver - Any of the above conditions can be waived if you get permission 
 *  from the copyright holder.
 *
 *  Public Domain - Where the work or any of its elements is in the public 
 *  domain under applicable law, that status is in no way affected by the 
 *  license.
 *
 *  Other Rights - In no way are any of the following rights affected by the 
 *  license:
 *  Your fair dealing or fair use rights, or other applicable copyright 
 *  exceptions and limitations;
 *
 *  The author's moral rights;
 *  Rights other persons may have either in the work itself or in how the work 
 *  is used, such as publicity or privacy rights.
 *
 */
package com.qnoid.java.t1fE.dont;

import com.qnoid.java.t1fE.UnregisteredUserException;

/**
 * @author Markos Charatzas [http://forrst.me/Cue]
 * @date Jan 19, 2011
 * 
 * Abusing if like there is no tomorrow
 */
public class UserImpl
{
    private static final String REGISTERING = "registering user '%s'";
    private static final String NOT_REGISTERED = "user '%s' not registered";
    private static final String ALREADY_REGISTERED = "User %s already registered";
    private static final String ALREADY_LOGGED_IN = "User %s already logged in";    

    private final String username;

    /*
     * Notice how your class is filled with non-final fields making it harder to
     * debug, make it thread-safe and extend.
     */
    private boolean registered;
    private boolean loggedIn;

    /**
     * @param username
     */
    public UserImpl(String username)
    {
        this.username = username;
        this.registered = false;
        this.loggedIn = false;
    }

    void nowRegistered() {
        this.registered = true;
    }

    void nowLoggedIn() {
        this.loggedIn = true;
    }

    public void register()
    {
        if(this.isRegistered()){
            throw new IllegalStateException( String.format(ALREADY_REGISTERED, this));
        }
        else
        {
            System.out.println( String.format(REGISTERING, this));
            this.nowRegistered();
        }
    }

    public void login()
    {
        if(this.isLoggedIn()){
            throw new IllegalStateException( String.format(ALREADY_LOGGED_IN, this) );            
        }
                
        if(!this.isRegistered()){
            throw new UnregisteredUserException( String.format(NOT_REGISTERED, this) );
        }
        else
        {
            System.out.println( String.format("'%s' logged in", this) );
            this.nowLoggedIn();            
        }            
    }

    public boolean isRegistered() {
    return this.registered;
    }

    public boolean isLoggedIn() {
    return this.loggedIn;
    }

    @Override
    public String toString() {
    return this.username;
    }    
}
