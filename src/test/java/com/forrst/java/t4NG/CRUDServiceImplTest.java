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
package com.forrst.java.t4NG;

import java.util.List;

import javax.jdo.PersistenceManager;

import org.junit.Test;

import com.forrst.java.t4NG.CRUDService;
import com.forrst.java.t4NG.CRUDServiceImpl;
import com.forrst.java.t4NG.Greeting;
import com.forrst.java.t4NG.QueryStrategy;
import com.forrst.java.t4NG.User;
import com.forrst.java.t4NG.QueryStrategies.GreetingStrategies;


/**
 * @author Markos Charatzas [http://forrst.me/Cue]
 * @date Feb 10, 2011
 * 
 * Let's see how it looks from the client side
 */
public class CRUDServiceImplTest
{
    private final PersistenceManager pm = null;
    private final CRUDService<Greeting> service = new CRUDServiceImpl<Greeting>(pm);
    
    @Test
    public void getLatestByAythor() throws Exception
    {
        User author = new User() {};
        
        QueryStrategy<Greeting> queryStrategy = 
            GreetingStrategies.latestByAuthor(author);
        
        Greeting greeting = service.unique(queryStrategy);
    }
    
    @Test
    public void mostRecent() throws Exception
    {
        int count = 10;
        
        QueryStrategy<Greeting> queryStrategy = 
            GreetingStrategies.mostRecent(count);
        
        List<Greeting> greetings = service.list(queryStrategy);
    }
}
