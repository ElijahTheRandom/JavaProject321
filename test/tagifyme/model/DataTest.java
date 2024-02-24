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
 * @author ethan
 */
public class DataTest {

    private Data data;
    
    public DataTest() {
    }
    
    @Before
    public void setUp() {
      data = new Data("Test");
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
        Data instance = data;
        String expResult = "Test";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of compareTo method, of class Data.
     */
    @Test
    public void testCompareTo() {
      System.out.println("compareTo");
      Data instance = data;

      // A data compared to itself is the same.
      assertEquals(true, instance.compareTo(instance) == 0);

      // A data compared to a data beginning with 'U' is smaller.
      Data compare_1 = new Data("Uest");
      assertEquals(false, instance.compareTo(compare_1) > 1);

      // A data compared to a data beginning with 'R' is larger.
      Data compare_2 = new Data("Rest");
      assertEquals(true, instance.compareTo(compare_2) > 1);
    }
}
