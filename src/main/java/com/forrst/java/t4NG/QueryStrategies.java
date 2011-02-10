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

import javax.jdo.Query;

import com.forrst.java.t4NG.QueryConfigurations.QueryConfigurationBuilder;

/**
 * @author Markos Charatzas [http://forrst.me/Cue]
 * @date Feb 10, 2011
 *
 * QueryStrategies ready for consumption
 */
public final class QueryStrategies
{
    public static final class GreetingStrategies
    {
        public static QueryStrategy<Greeting> latestByAuthor(User author) 
        {
            QueryConfiguration configuration = 
                new QueryConfigurationBuilder()
                    .filter("author == :author")
                    .ordering("date desc")
                    .build();
        
        return new QueryStrategyBuilder<Greeting>(Greeting.class)
                    .args(author)
                    .configuration( configuration )
                    .build();
        }
        
        public static QueryStrategy<Greeting> mostRecent(int toExl) 
        {
            QueryConfiguration configuration = 
                new QueryConfigurationBuilder()
                    .filter("date desc")
                    .toExl(toExl)
                    .build();
            
            return new QueryStrategyBuilder<Greeting>(Greeting.class)
                .configuration( configuration )
                .build();
        }                
    }
    
    public static final class QueryStrategyBuilder<T>
    {
        private final Class<T> clazz;
        private Object[] args = new Object[]{};
        private QueryConfiguration configuration = QueryConfigurations.DEFAULT;

        /**
         * @param clazz
         */
        private QueryStrategyBuilder(Class<T> clazz)
        {
            this.clazz = clazz;
        }

        public QueryStrategyBuilder<T> args(Object... args)
        {
            this.args = args;
            
        return this;
        }
        
        public QueryStrategyBuilder<T> configuration(QueryConfiguration configuration)
        {
            this.configuration = configuration;
            
        return this;
        }
        
        public QueryStrategy<T> build()
        {
        return new QueryStrategy<T>() {
            
            @Override
            public Class<T> type() {
            return clazz;
            }
            
            @Override
            public void configure(Query query) {
                configuration.configure(query);
            }
            
            @Override
            public Object[] arguments() {
            return args;
            }
        };    
        }
    }
    
    private QueryStrategies(){}
}
