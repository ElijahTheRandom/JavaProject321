/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package tagifyme.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ethan
 */
public class DataTest {

    private Data d;
    
    public DataTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
      d = new Data("Test");
    }
    
    @AfterEach
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
