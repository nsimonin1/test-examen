/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.simon.pascal;

import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author simon.pascal.ngos
 */
public class MainIT {
    
    public MainIT() {
    }
     
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    

    /**
     * Test of execution method, of class Main.
     */
    @Test
    public void testExecution() {
        System.out.println("execution");
        List<Integer> entiers = Arrays.asList(0,1,1,0,1); 
        Integer step = 3;
        Main instance = new Main();
        List<String> expResult = Arrays.asList("11100","10110","00111"); 
        List<String> result = instance.execution(entiers, step);
        assertEquals(expResult, result);
        
    }
    
    
    
    
}
