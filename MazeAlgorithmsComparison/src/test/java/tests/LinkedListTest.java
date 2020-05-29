package tests;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import maze.data_structures.LinkedList;

/**
 *
 * @author taleiko
 */
public class LinkedListTest {
    LinkedList list;
    
    @Before
    public void setUp() {
        this.list = new LinkedList();
    }
    
    @Test
    public void addTest() {
        int limit = 5;
        for (int i = 0; i < limit; i++) {
            list.add(i);
        }
        long n = 0;
        int check = 0;
        while (n < limit) {
            assertTrue(list.get(n) == check);
            n++;
            check++;
        }
    }
    
    @Test
    public void sizeTest() {
        assertTrue(list.size() == 0);
        list.add(0);
        assertTrue(list.size() == 1);
        for (int i = 0; i < 10; i++) {
            list.add(7);
        }
        assertTrue(list.size() == 11);
    }
    
//    @Test
//    public void removeTest() {
//        for (int i = 0; i < 6; i++) {
//            list.add(i);
//        }
//        assertTrue(list.size() == 6);
//        list.remove(5);
//        assertTrue(list.size() == 5);
//        list.remove(0);
//        assertTrue(list.size() == 4 && list.get(0) == 1);
//        for (int i = 0; i < 2; i++) {
//            list.remove(i);
//        }
//        assertTrue(list.size() == 2 && list.get(0) == 2);
//        list.remove(0);
//        list.remove(0);
//        assertTrue(list.size() == 0);
//        
//        //Removing a number in the middle of a longer list
//        for (int i = 0; i < 15; i++) {
//            list.add(i);
//        }
//        assertTrue(list.get(11) == 10);
//        list.remove(11);
//        assertTrue(list.get(11) == 11);
//    }
    
    @Test
    public void insertTest() {
        list.add(1);
        list.add(4);
        list.insert(1, 2);
        assertTrue(list.get(0) == 1);
        assertTrue(list.get(1) == 2);
        assertTrue(list.get(2) == 4);
        list.insert(0, 0);
        list.insert(3, 3);
        for (int i = 0; i < list.size(); i++) {
            assertTrue(list.get(i) == i);
        }
    }
    
    @Test
    public void copyToTest() {
        list.add(5);
        list.add(25);
        list.add(5);
        list.add(2);
        list.add(6543);
        list.add(6);
        LinkedList listToCopyTo = new LinkedList();
        list.copyTo(listToCopyTo);
        for (int i = 0; i < list.size(); i++) {
            assertTrue(list.get(i) == listToCopyTo.get(i));
        }
    }
    
    @Test
    public void clearTest() {
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        assertTrue(list.size() == 10);
        list.clear();
        assertTrue(list.size() == 0);
        list.add(7);
        assertTrue(list.size() == 1 && list.get(0) == 7);
    }
}
