/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.ASE.Business;

import static junit.framework.TestCase.assertEquals;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author JuanPablo
 */
public class ResultDataTest {
    
    public ResultDataTest() {
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
     * Test of cosienteIntervaloGradosLibertad method, of class ResultData.
     */
    @Test
    public void testValorCalculado() 
    {
        System.out.println("valorCalculado");
        ResultData instance = new ResultData(1, 0.11, 4, 9, 0.388035);
        double expResult = 0.05653;
        double result = instance.valorCalculado();
        assertEquals(expResult, result, 0.001);
    }
}
