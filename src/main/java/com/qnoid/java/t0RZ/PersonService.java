/*
 *	This file is under the licence
 *	Attribution-ShareAlike 3.0 Unported (CC BY-SA 3.0)
 *	(http://creativecommons.org/licenses/by-sa/3.0/)
 *
 *	You are free:
 *		to Share — to copy, distribute and transmit the work
 *		to Remix — to adapt the work
 *
 *	Under the following conditions:
 *	Attribution — You must attribute the work in the manner specified by the author or licensor 
 *	(but not in any way that suggests that they endorse you or your use of the work).
 *	
 *	Share Alike — If you alter, transform, or build upon this work, you may distribute the resulting work only under the same or similar license to this one.
 *
 *	With the understanding that:
 *		Waiver — Any of the above conditions can be waived if you get permission from the copyright holder.
 *		Public Domain — Where the work or any of its elements is in the public domain under applicable law, that status is in no way affected by the license.
 *		Other Rights — In no way are any of the following rights affected by the license:
 *		Your fair dealing or fair use rights, or other applicable copyright exceptions and limitations;
 *		The author's moral rights;
 *		Rights other persons may have either in the work itself or in how the work is used, such as publicity or privacy rights.
 *
 */
package com.qnoid.java.t0RZ;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import com.qnoid.java.t0RZ.Person.PersonBuilder;
import com.qnoid.java.t0SA.Column;
import com.qnoid.java.t0SA.Row;
import com.qnoid.java.t0mR.ResultSetListHandler;
import com.qnoid.java.t0mR.TemplateResultSetHandler;

/**
 * @author Markos Charatzas [http://forrst.me/Cue]
 * @date Jan 15, 2011
 * 
 * Use to query for {@link Person}s
 */
public class PersonService
{
    /**
     * All columns related to the person.
     */
    private static class Columns
    {
        public static final Column<Integer> ID = 
            Column.newIntegerType("id");
        
        public static final Column<String> NAME = 
            Column.newStringType("name");
        
        public static final Column<Date> DATE =
            Column.newDateType("date");

        public static final ArrayList<Column<?>> ALL = 
            new ArrayList<Column<?>>()
            {
                {
                    this.add(Columns.ID);
                    this.add(Columns.NAME);
                    this.add(Columns.DATE);
                }
            };
    }
    
    /**
     * Implementation of a template handler 
     * to create a new Person out of a Row
     */
    private static final ResultSetHandler<Person> PERSON_TEMPLATE_HANDLER = 
        new TemplateResultSetHandler<Person>(Columns.ALL) 
        {    
            @Override
            protected Person newType(Row row)
            {
                Integer id = row.get(Columns.ID);
                String name = row.get(Columns.NAME);
                Date date = row.get(Columns.DATE);
                                
            return new PersonBuilder()
                    .id(id)
                    .name(name)
                    .date(date)
                    .build();
            }                               
        };
    
    /**
     * Handler to use when retrieving a list of {@link Person}s
     */
    private static final ResultSetHandler<List<Person>> PERSONS_HANDLER = 
        new ResultSetListHandler<Person>(PERSON_TEMPLATE_HANDLER);

    private static final String SELECT_PERSONS = 
        "SELECT id, name, date, FROM person";

    private final DataSource datasource;
    
    PersonService(DataSource datasource)
    {
        this.datasource = datasource;
    }

    public List<Person> list() throws SQLException
    {
        QueryRunner queryRunner = new QueryRunner(this.datasource);
        
    return queryRunner.query(SELECT_PERSONS, PERSONS_HANDLER);
    }
}

