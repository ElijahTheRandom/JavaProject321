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
    
    private Tag tag;
    
    public TagTest() {
    }
    
    @Before
    public void setUp() {
      tag = new Tag("Test");
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
        Tag instance = tag;
        String expResult = "Test";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of compareTo method, of class Tag.
     */
    @Test
    public void testCompareTo() {
      System.out.println("compareTo");
      Tag instance = tag;

      // A tag compared to itself is the same.
      assertEquals(true, instance.compareTo(instance) == 0);

      // A tag compared to a tag beginning with 'U' is smaller.
      Tag compare_1 = new Tag("Uest");
      assertEquals(false, instance.compareTo(compare_1) > 1);

      // A tag compared to a tag beginning with 'R' is larger.
      Tag compare_2 = new Tag("Rest");
      assertEquals(true, instance.compareTo(compare_2) > 1);
    }

    /**
     * Test of equals method, of class Tag.
     */
    @Test
    public void testEquals() {
      System.out.println("equals");
      Tag instance = tag;

      // A tag compared to itself should return true.
      assertEquals(true, instance.equals(instance));

      // A tag compared to another Tag object with the same
      // "name" should be true.
      Tag sameName = new Tag("Test");
      assertEquals(true, instance.equals(sameName));

      // A tag compared to another Tag object with a different
      // name should be false.
      Tag diffName = new Tag("Diff");
      assertEquals(false, instance.equals(diffName));
    }
}
    