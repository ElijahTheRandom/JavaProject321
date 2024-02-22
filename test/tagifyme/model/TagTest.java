/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package tagifyme.model;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 *
 * @author ethan
 */
public class TagTest {
    
    private Tag t;
    
    public TagTest() {
    }
    
    @Before
    public void setUp() {
      t = new Tag("Test");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getName method, of class Tag.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Tag instance = t;
        String expResult = "Test";
        String result = instance.getName();
        assertEquals(expResult, result);
    }
}
