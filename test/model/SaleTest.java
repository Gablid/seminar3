/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dbhandler.ItemDTO;
import dbhandler.Printer;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gabriel Blid
 */
public class SaleTest {
    
    public SaleTest() {
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
     * Test of addItem method, of class Sale.
     */
    @Test
    public void testAddItem() {
        ItemDTO item = new ItemDTO("Banana", "a beautifully rotten banana",
                                    3, 0.09);
        Sale instance = new Sale();
        String expResult = "3.0kr, a beautifully rotten banana, 3.0kr";
        String result = instance.addItem(item);
        assertEquals(expResult, result);
    }

    /**
     * Test of addItems method, of class Sale.
     */
    @Test
    public void testAddItems() {
        ItemDTO item = new ItemDTO("Banana", "a beautifully rotten banana",
                                   3, 0.09);
        int quantity = 2;
        Sale instance = new Sale();
        String expResult = "3.0kr, a beautifully rotten banana, 6.0kr";
        String result = instance.addItems(item, quantity);
        assertEquals(expResult, result);
    }

    /**
     * Test of calculateTaxes method, of class Sale.
     */
    @Test
    public void testCalculateTaxes() {
        ItemDTO item = new ItemDTO("Banana", "a beautifully rotten banana",
                                   3, 0.09);
        Sale instance = new Sale();
        instance.addItem(item);
        double expResult = 0.27;
        double result = instance.calculateTaxes();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of calculateChange method, of class Sale.
     */
    @Test
    public void testCalculateChange() {
        ItemDTO item = new ItemDTO("Banana", "a beautifully rotten banana",
                + 3, 0.09);
        
        double paidAmount = 5.0;
        Sale instance = new Sale();
        instance.addItem(item);
        double expResult = 2.0;
        double result = instance.calculateChange(paidAmount);
        assertEquals(expResult, result, 0.0);
    }
}
