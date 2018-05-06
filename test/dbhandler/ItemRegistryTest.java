package dbhandler;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ItemRegistryTest {
    
    public ItemRegistryTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findItem method, of class ItemRegistry.
     */
    @Test
    public void testFindItem() {
        String name = "Banana";
        ItemRegistry instance = new ItemRegistry();
        ItemDTO expResult = instance.getItem(2);
        ItemDTO result = instance.findItem(name);
        assertEquals(expResult, result);
    }
}


