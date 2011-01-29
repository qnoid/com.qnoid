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
package com.forrst.java.t1fE;

import java.util.EnumMap;

import com.google.common.base.Preconditions;

/**
 * @author Markos Charatzas [http://forrst.me/Cue]
 * @date Jan 19, 2011
 * 
 * A user implemented as a state machine
 */
public class TheUser implements User
{
    public static final class TheUserBuilder
    {        
        private final String username;

        public TheUserBuilder(String username)
        {
            this.username = username;
        }

        /**
         * @return a new unregistered user
         */
        public TheUser build()
        {            
            TheUser user = new TheUser(this.username);
            
            User unregistered = new Unregistered(user);
            User registered = new Registered(user);
            User loggedin = new LoggedIn(user);
            
            user.addState(UserState.UNREGISTERED, unregistered);
            user.addState(UserState.REGISTERED, registered);
            user.addState(UserState.LOGGED_IN, loggedin);
            
            user.setState(unregistered);
            
        return user;
        }
    }
    
    private static final String UNSPECIFIED_STATE = 
        "State %s not specified for user. Add a state using #addState(%s, state)";

    /*
     * All possible states
     */    
    private final EnumMap<UserState, User> states = 
        new EnumMap<UserState, User>(UserState.class);
    
    private final String username;
    
    /*
     * The current state and only non-final field
     */
    private User state;
    
    /**
     * @param username
     */
    public TheUser(String username)
    {
        this.username = username;
    }

    /**
     * @param type
     * @param state
     */
    private void addState(UserState type, User state) {
        this.states.put(type, state);
    }

    private void setState(User state) {
        this.state = state;
    }

    private User getState(UserState type) 
    {
        User state = this.states.get(type);
        
        Preconditions.checkNotNull(state, 
                String.format(UNSPECIFIED_STATE, state, state));
        
    return state;
    }

    private User registeredState() {
    return this.getState(UserState.REGISTERED);
    }

    private User loggedInState() {
    return this.getState(UserState.LOGGED_IN);
    }

    void nowRegistered() {
        this.setState( this.registeredState() );
    }

    void nowLoggedIn() {
        this.setState( this.loggedInState() );        
    }

    /* (non-Javadoc)
     * @see com.forrst.java.ifs.state.User#register()
     */
    @Override
    public void register() {
        this.state.register();
    }

    /* (non-Javadoc)
     * @see com.forrst.java.ifs.state.User#login()
     */
    @Override
    public void login() {
        this.state.login();
    }

    /* (non-Javadoc)
     * @see com.forrst.java.ifs.state.User#isRegistered()
     */
    @Override
    public boolean isRegistered() {
    return this.state.isRegistered();
    }

    /* (non-Javadoc)
     * @see com.forrst.java.ifs.state.User#isLoggedIn()
     */
    @Override
    public boolean isLoggedIn() {
    return this.state.isLoggedIn();
    }

    @Override
    public String toString() {
    return this.username;
    }    
}
