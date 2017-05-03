/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc220.program5.jonesah2019;

import csc220.list.AddIterator;
import java.awt.Point;
import java.util.NoSuchElementException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Andy
 */
public class ListTest {
    
    public ListTest() {
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
     * Test of addIterator method, of class List.
     */
//    @Test
//    public void testAddIterator() {
//        
//       // Test addBeforeNext
//        assertTrue(testAddBeforeNext()); 
//        
//    }
    
    @Test
    public void testAddBeforeNext(){
        
        Point a = new Point(1, 1);
        Point b = new Point(2, 2);
        Point c = new Point(3, 3);
        
        List<Point> list = new csc220.program5.jonesah2019.List<>();
        list.add(a);
        list.add(b);
        list.add(c);
        AddIterator listIt = list.addIterator();
        // a - c - b - b - c - a
        listIt.next();
        listIt.addBeforeNext(c);
        listIt.next();
        listIt.addBeforeNext(b);
        listIt.next();
        listIt.addBeforeNext(a);
        AddIterator testIt = list.addIterator();
        
        Boolean pF;
        pF = (testIt.next() == a);
        if(pF == true){
            pF = (testIt.next().equals(c));
        }
        if(pF == true){
            pF = (testIt.next().equals(b));
        }
        if(pF == true){
            pF = (testIt.next().equals(b));
        }
        if(pF == true){
            pF = (testIt.next().equals(c));
        }
        if(pF == true){
            pF = (testIt.next().equals(a));
        }
        
        assertTrue(pF);
        
    }
    
    @Test
    public void testRemove(){
        
        Point a = new Point(1, 1);
        Point b = new Point(2, 2);
        Point c = new Point(3, 3);
        
        List<Point> test1, test2, test3, test4, test5;
        test1 = new csc220.program5.jonesah2019.List<>();
        test2 = new csc220.program5.jonesah2019.List<>();
        test3 = new csc220.program5.jonesah2019.List<>();
        test4 = new csc220.program5.jonesah2019.List<>();
        test5 = new csc220.program5.jonesah2019.List<>();
        test1.add(a);
        test1.add(b);
        test1.add(c);
        test2.add(a);
        test2.add(b);
        test2.add(c);
        test3.add(a);
        test3.add(b);
        test3.add(c);
        test4.add(a);
        
        AddIterator testIt1 = test1.addIterator();
        AddIterator testIt2 = test2.addIterator();
        AddIterator testIt3 = test3.addIterator();
        AddIterator testIt4 = test4.addIterator();
        AddIterator testIt5 = test5.addIterator();
        
        
        // Test scenario 1 - removal of first node
        Boolean tF1;
        testIt1.next();
        testIt1.remove();
        testIt1 = test1.addIterator();
        tF1 = (testIt1.next().equals(b));
        if(tF1 == true){
            tF1 = (testIt1.next().equals(c));
        }
        assertTrue(tF1);
        
        // Test scenario 2 - removal of middle node
        Boolean tF2;
        testIt2.next();
        testIt2.next();
        testIt2.remove();
        testIt2 = test2.addIterator();
        tF2 = (testIt2.next().equals(a));
        if(tF2 == true){
            tF2 = (testIt2.next().equals(c));
        }
        assertTrue(tF2);
        
        // Test scenario 3 - removal of last node of list
        Boolean tF3;
        testIt3.next();
        testIt3.next();
        testIt3.next();
        testIt3.remove();
        testIt3 = test3.addIterator();
        tF3 = (testIt3.next().equals(a));
        if(tF3 == true){
            tF3 = (testIt3.next().equals(b));
        }
        assertTrue(tF3);
        
        // Test scenario 4 - removal of last node left in list
        testIt4.next();
        testIt4.remove();
        assertFalse(testIt4.hasNext());
        
        // Test scenario 5 - empty list
        Boolean thrown = false;
        try {
            testIt5.remove();
        } catch (NoSuchElementException e) {
            thrown = true;
        }

        assertTrue(thrown);
        
    }

    
}
