/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.ASE.Business;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertEquals;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author JuanPablo
 */
public class DistribucionTTest {
    
    public DistribucionTTest() {
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

    @Test
    public void testCalculoDistribucion() {
        DistribucionT distribucionT = new  DistribucionT(10,1.1, 9);
        double valorCalculado = distribucionT.calculoDistribucion();
        assertEquals(0.3500589, valorCalculado, 0.01);
    } 
}
