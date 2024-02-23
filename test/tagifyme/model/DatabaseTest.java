/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package tagifyme.model;

import java.util.Iterator;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 *
 * @author ethan
 */
public class DatabaseTest {
    
    public DatabaseTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of loadDatabase method, of class Database.
     */
    @Test
    public void testLoadDatabase() throws Exception {
        System.out.println("loadDatabase");
        Database expResult = null;
        Database result = Database.loadDatabase();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dumpDatabase method, of class Database.
     */
    @Test
    public void testDumpDatabase() {
        System.out.println("dumpDatabase");
        Database instance = new Database();
        instance.dumpDatabase();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getData method, of class Database.
     */
    @Test
    public void testGetData() {
        System.out.println("getData");
        Database instance = new Database();
        Iterator<Data> expResult = null;
        Iterator<Data> result = instance.getData();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTag method, of class Database.
     */
    @Test
    public void testGetTag() {
        System.out.println("getTag");
        Database instance = new Database();
        Iterator<Tag> expResult = null;
        Iterator<Tag> result = instance.getTag();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRelationship method, of class Database.
     */
    @Test
    public void testGetRelationship() {
        System.out.println("getRelationship");
        Database instance = new Database();
        Iterator<Relationship> expResult = null;
        Iterator<Relationship> result = instance.getRelationship();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
