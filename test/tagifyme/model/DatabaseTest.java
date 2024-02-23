/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package tagifyme.model;

import java.util.Optional;
import java.util.Arrays;
import java.lang.Iterable;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 *
 * @author ELIJAH SHANNON
 */
public class DatabaseTest {

    private Database db;
    
    public DatabaseTest() {

    }
    
    @Before
    public void setUp() {
      // Before each test, we setup the database with some data.
      Tag t1 = new Tag("t1");
      Tag t2 = new Tag("t2");
      Tag[] t_arr = {t1, t2};

      Data d1 = new Data("d1");
      Data d2 = new Data("d2");
      Data[] d_arr = {d1, d2};

      Relationship r1 = new Relationship(d1, t1);
      Relationship r2 = new Relationship(d2, t2);
      Relationship[] r_arr = {r1, r2};

      Optional<Iterable<Data>> o_data = Optional.of(Arrays.asList(d_arr));
      Optional<Iterable<Tag>> o_tag = Optional.of(Arrays.asList(t_arr));
      Optional<Iterable<Relationship>> o_rel = Optional.of(Arrays.asList(r_arr));
            
      // At this point, we need to create the database.
      // TODO: Do we wrap the above in Lists and feed them in via
      // constructor? Do we call `.addTag`, etc. repeatedly here?

      db = new Database(o_data, o_tag, o_rel);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test deleting a tag.
     */
    @Test
    public void deleteTag() {
       Database instance = this.db;
       // TODO: What does t1 need to be here? Is it an `object` (we then
       // need something to prove equivalency between objects), or is it
       // an index into a list. See the note above the corresponding function
       // in the model definition.
       
       // this.db.deleteTag(t1);
     
       // After this, we need to check and make sure that 
       // A) The tag no longer exists in the database.
       // B) That the relationships that had such tag have been removed aswell.
       // TODO: Implement the above requirements.
       fail("This test case is a prototype");
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
}
