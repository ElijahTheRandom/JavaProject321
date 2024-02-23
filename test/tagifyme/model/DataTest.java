/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package tagifyme.model;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author Olivia
 */
public class DataTest {

    private Data d;
    
    public DataTest() {
    }
    
    @Before
    public void setUp() {
      d = new Data("Test");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getName method, of class Data.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Data instance = d;
        String expResult = "Test";
        String result = instance.getName();
        assertEquals(expResult, result);
    }
}
