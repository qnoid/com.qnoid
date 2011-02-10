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
import javax.jdo.Query;

/**
 * @author Markos Charatzas [http://forrst.me/Cue]
 * @date Feb 10, 2011
 *
 */
public final class CRUDServiceImpl<T> implements CRUDService<T> 
{
    private final PersistenceManager pm;

    public CRUDServiceImpl(PersistenceManager pm)
    {
        this.pm = pm;
    }

    @Override
    public void store(T model) {
        pm.makePersistent(model);
    }
    
    @Override
    public List<T> list(QueryStrategy<T> queryStrategy)
    {
        Query query = pm.newQuery(queryStrategy.type());

        queryStrategy.configure(query);
            
        /*
         * Effective Java 2nd Edition, Joshua Bloch, Item 24, page 116
         */
        @SuppressWarnings("unchecked")
        List<T> result = (List<T>)query.executeWithArray(queryStrategy.arguments());
    
    return result;
    }

    @Override
    public T unique(QueryStrategy<T> queryStrategy)
    {
        List<T> list = this.list(queryStrategy);
        
        if(list.isEmpty())
        {
            /*
             * It is a good idea to provide as much information as possible 
             * to the exception. That way the client code can take action. 
             */
            throw new ObjectNotFoundException(queryStrategy.type());
        }
        
    return list.get(0);
    }
}
